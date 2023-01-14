package matteogilioli.balancebuddy.controller.actions;

import matteogilioli.balancebuddy.controller.table.BalanceTableModel;
import matteogilioli.balancebuddy.model.Balance;
import matteogilioli.balancebuddy.model.BalanceEntry;
import matteogilioli.balancebuddy.model.ExpenseEntry;
import matteogilioli.balancebuddy.model.IncomeEntry;
import matteogilioli.balancebuddy.view.FormDialog;
import matteogilioli.balancebuddy.view.table.BalanceTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Locale;

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

        NumberFormat nf = NumberFormat.getInstance(Locale.getDefault());
        BigDecimal amount = null;
        try {
            amount = new BigDecimal(nf.parse(amountString).toString());
        } catch (ParseException ex) {
            ex.printStackTrace();
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
