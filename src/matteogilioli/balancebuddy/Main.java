package matteogilioli.balancebuddy;

import matteogilioli.balancebuddy.gui.BudgetBuddyFrame;
import matteogilioli.balancebuddy.logic.Balance;
import matteogilioli.balancebuddy.logic.ExpenseEntry;
import matteogilioli.balancebuddy.logic.IncomeEntry;

import javax.swing.*;

public final class Main {

    private static final Balance balance = new Balance();

    public static void main(String[] args) {

        // Voci di esempio
        Balance.newEntry(new ExpenseEntry("Netflix", 14.99));
        Balance.newEntry(new ExpenseEntry("Spesa", 50));
        Balance.newEntry(new IncomeEntry("Stipendio", 800));
        Balance.newEntry(new ExpenseEntry("Mancia nonni", 50));
        Balance.newEntry(new ExpenseEntry("Sushi", 14.99));
        Balance.newEntry(new IncomeEntry("Benzina", 60));

        BudgetBuddyFrame f = new BudgetBuddyFrame(balance);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}