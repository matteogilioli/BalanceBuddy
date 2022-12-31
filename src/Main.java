import javax.swing.*;
import gui.BudgetBuddyFrame;
import logic.VoceBilancio;
import logic.VoceEntrata;
import logic.VoceSpesa;

import java.util.ArrayList;

public final class Main {
    private static ArrayList<VoceBilancio> voci;

    public static void main(String[] args) {
        voci = new ArrayList<>();

        // Voci di esempio
        voci.add(new VoceSpesa("Netflix", 14.99));
        voci.add(new VoceSpesa("Spesa", 50));
        voci.add(new VoceEntrata("Stipendio", 800));

        BudgetBuddyFrame f = new BudgetBuddyFrame(voci);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}