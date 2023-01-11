package matteogilioli.balancebuddy;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import matteogilioli.balancebuddy.gui.BudgetBuddyFrame;
import matteogilioli.balancebuddy.logic.Balance;
import matteogilioli.balancebuddy.logic.ExpenseEntry;
import matteogilioli.balancebuddy.logic.IncomeEntry;

import javax.swing.*;
import java.math.BigDecimal;

public final class Main {
    private static final Balance balance = new Balance();

    public static void main(String[] args) {
        FlatMacLightLaf.setup();

        // Voci di esempio
        balance.addEntry(new ExpenseEntry("Netflix", new BigDecimal(14.99)));
        balance.addEntry(new ExpenseEntry("Spesa", new BigDecimal(50)));
        balance.addEntry(new IncomeEntry("Stipendio", new BigDecimal(800)));
        balance.addEntry(new ExpenseEntry("Mancia", new BigDecimal(50)));
        balance.addEntry(new ExpenseEntry("Ristorante Oriente", new BigDecimal(14.99)));
        balance.addEntry(new IncomeEntry("Benzina", new BigDecimal(60)));

        BudgetBuddyFrame f = new BudgetBuddyFrame(balance);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}