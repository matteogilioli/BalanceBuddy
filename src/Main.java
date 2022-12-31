import javax.swing.*;
import gui.BudgetBuddyFrame;
import logic.Balance;
import logic.IncomeEntry;
import logic.ExpenseEntry;


public final class Main {

    private static Balance bl;

    public static void main(String[] args) {
        bl = new Balance();

        // Voci di esempio
        bl.aggiungi(new ExpenseEntry("Netflix", 14.99));
        bl.aggiungi(new ExpenseEntry("Spesa", 50));
        bl.aggiungi(new IncomeEntry("Stipendio", 800));

        BudgetBuddyFrame f = new BudgetBuddyFrame(bl);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}