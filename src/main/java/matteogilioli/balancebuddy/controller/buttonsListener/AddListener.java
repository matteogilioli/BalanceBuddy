package matteogilioli.balancebuddy.controller.buttonsListener;

import matteogilioli.balancebuddy.controller.formatter.LocaleNumberFormat;
import matteogilioli.balancebuddy.controller.table.BalanceTableModel;
import matteogilioli.balancebuddy.gui.FormDialog;
import matteogilioli.balancebuddy.gui.table.BalanceTable;
import matteogilioli.balancebuddy.logic.model.Balance;
import matteogilioli.balancebuddy.logic.model.BalanceEntry;
import matteogilioli.balancebuddy.logic.model.ExpenseEntry;
import matteogilioli.balancebuddy.logic.model.IncomeEntry;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDateTime;

public class AddListener implements ActionListener {
    private final FormDialog form;
    private final BalanceTable table;

    public AddListener(FormDialog form, BalanceTable table) {
        this.form = form;
        this.table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String type = form.getSelectedType();
        String description = form.getDescription();
        String amountString = form.getAmount();
        LocalDateTime datetime = form.getDatetime();

        if (description.isBlank() && amountString.isBlank())
            form.setError("Descrizione ed importo mancanti");
        else if (description.isBlank())
            form.setError("Descrizione mancante");
        else if (amountString.isBlank())
            form.setError("Importo mancante");
        if (description.isBlank() || amountString.isBlank())
            return;

        NumberFormat nf = new LocaleNumberFormat();
        BigDecimal amount;
        try {
            amount = new BigDecimal(nf.parse(amountString).toString());
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }

        BalanceEntry entry = switch (type) {
            case "Entrata" -> new IncomeEntry(description, amount, datetime);
            case "Uscita" -> new ExpenseEntry(description, amount, datetime);
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };

        form.dispose();
        Balance.addEntry(entry);
        ((BalanceTableModel) table.getModel()).refresh();
    }
}
