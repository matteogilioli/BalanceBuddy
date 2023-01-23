package matteogilioli.balancebuddy;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import matteogilioli.balancebuddy.gui.BudgetBuddyFrame;

import javax.swing.*;

/**
 * La classe che contiene il metodo main.
 */
public final class Main {
    /**
     * Il metodo main del programma.
     * Inizializza un look and feel e crea un nuovo {@link BudgetBuddyFrame} con cui l'utente può interagire.
     *
     * @param args I parametri passati al programma dalla riga di comando
     */
    public static void main(String[] args) {
        System.setProperty("apple.laf.useScreenMenuBar", "true");
        System.setProperty("apple.awt.application.name", "BalanceBuddy");
        FlatMacLightLaf.setup();

        SwingUtilities.invokeLater(BudgetBuddyFrame::new);
    }
}