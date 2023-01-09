package matteogilioli.balancebuddy.gui.buttons.listener;

import matteogilioli.balancebuddy.gui.panels.FormPanel;
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
    private final BalanceTable table;
    private final Balance balance;

    public AddListener(FormPanel form, BalanceTable table, Balance balance) {
        this.form = form;
        this.table = table;
        this.balance = balance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String description = form.getDescription();
        double amount = form.getAmount();
        Date datetime = form.getDatetime();

        BalanceEntry entry = switch (form.getType()) {
            case "Entrata" -> new IncomeEntry(description, amount, datetime);
            case "Uscita" -> new ExpenseEntry(description, amount, datetime);
            default -> throw new IllegalStateException("Unexpected value: " + form.getType());
        };

        form.clear();
        balance.addEntry(entry);
        table.updateTable();
    }
}
