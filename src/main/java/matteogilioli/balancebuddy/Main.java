package matteogilioli.balancebuddy;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import matteogilioli.balancebuddy.gui.BudgetBuddyFrame;

import javax.swing.*;

public final class Main {
    public static void main(String[] args) {
        System.setProperty("apple.laf.useScreenMenuBar", "true");
        System.setProperty("apple.awt.application.name", "BalanceBuddy");
        FlatMacLightLaf.setup();

        SwingUtilities.invokeLater(BudgetBuddyFrame::new);
    }
}