package matteogilioli.balancebuddy.gui.buttons.listener;

import matteogilioli.balancebuddy.gui.Application;
import matteogilioli.balancebuddy.gui.window.FormDialog;
import matteogilioli.balancebuddy.logic.Balance;
import matteogilioli.balancebuddy.logic.BalanceEntry;
import matteogilioli.balancebuddy.logic.ExpenseEntry;
import matteogilioli.balancebuddy.logic.IncomeEntry;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Locale;

public class AddListener implements ActionListener {
    private final FormDialog form;

    public AddListener(FormDialog form) {
        this.form = form;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
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

        BalanceEntry entry = switch (form.getSelectedType()) {
            case "Entrata" -> new IncomeEntry(description, amount, datetime);
            case "Uscita" -> new ExpenseEntry(description, amount, datetime);
            default -> throw new IllegalStateException("Unexpected value: " + form.getSelectedType());
        };

        form.dispose();
        Balance.addEntry(entry);
        Application.refreshData();
    }
}
