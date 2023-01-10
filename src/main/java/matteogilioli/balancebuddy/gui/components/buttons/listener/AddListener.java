package matteogilioli.balancebuddy.gui.components.buttons.listener;

import matteogilioli.balancebuddy.gui.panels.FormPanel;
import matteogilioli.balancebuddy.gui.panels.TablePanel;
import matteogilioli.balancebuddy.gui.table.BalanceTable;
import matteogilioli.balancebuddy.logic.Balance;
import matteogilioli.balancebuddy.logic.BalanceEntry;
import matteogilioli.balancebuddy.logic.ExpenseEntry;
import matteogilioli.balancebuddy.logic.IncomeEntry;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class AddListener implements ActionListener {
    private final FormPanel form;
    private final TablePanel tablePanel;
    private final Balance balance;

    public AddListener(FormPanel form, TablePanel tablePanel, Balance balance) {
        this.form = form;
        this.tablePanel = tablePanel;
        this.balance = balance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String description = form.getDescription();
        String amountString = form.getAmount();
        Date datetime = form.getDatetime();

        if (description.isBlank() && amountString.isBlank())
            form.setError("ERRORE: Descrizione ed importo mancanti");
        else if (description.isBlank())
            form.setError("ERRORE: Descrizione mancante");
        else if (amountString.isBlank())
            form.setError("ERRORE: Importo mancante");
        if (description.isBlank() || amountString.isBlank())
            return;

        Double amount = Double.parseDouble(amountString);

        BalanceEntry entry = switch (form.getType()) {
            case "Entrata" -> new IncomeEntry(description, amount, datetime);
            case "Uscita" -> new ExpenseEntry(description, amount, datetime);
            default -> throw new IllegalStateException("Unexpected value: " + form.getType());
        };

        form.clear();
        balance.addEntry(entry);
        tablePanel.updateTable();
    }
}
