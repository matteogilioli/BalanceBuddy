package matteogilioli.balancebuddy;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import matteogilioli.balancebuddy.gui.BudgetBuddyFrame;
import matteogilioli.balancebuddy.logic.Balance;
import matteogilioli.balancebuddy.logic.ExpenseEntry;
import matteogilioli.balancebuddy.logic.IncomeEntry;

import javax.swing.*;

public final class Main {
    private static final Balance balance = new Balance();

    public static void main(String[] args) {
        FlatMacLightLaf.setup();

        // Voci di esempio
        Balance.addEntry(new ExpenseEntry("Netflix", 14.99));
        Balance.addEntry(new ExpenseEntry("Spesa", 50));
        Balance.addEntry(new IncomeEntry("Stipendio", 800));
        Balance.addEntry(new ExpenseEntry("Mancia", 50));
        Balance.addEntry(new ExpenseEntry("Ristorante Oriente", 14.99));
        Balance.addEntry(new IncomeEntry("Benzina", 60));

        BudgetBuddyFrame f = new BudgetBuddyFrame(balance);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}