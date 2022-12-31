import javax.swing.*;
import gui.BudgetBuddyFrame;
import logic.Bilancio;
import logic.VoceEntrata;
import logic.VoceSpesa;


public final class Main {

    private static Bilancio bl;

    public static void main(String[] args) {
        bl = new Bilancio();

        // Voci di esempio
        bl.aggiungi(new VoceSpesa("Netflix", 14.99));
        bl.aggiungi(new VoceSpesa("Spesa", 50));
        bl.aggiungi(new VoceEntrata("Stipendio", 800));

        BudgetBuddyFrame f = new BudgetBuddyFrame(bl);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}