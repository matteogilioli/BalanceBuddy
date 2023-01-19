package matteogilioli.balancebuddy;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import matteogilioli.balancebuddy.gui.BudgetBuddyFrame;
import matteogilioli.balancebuddy.logic.file.BackupManager;
import matteogilioli.balancebuddy.logic.model.Balance;

import javax.swing.*;
import java.io.File;

public final class Main {
    public static void main(String[] args) {
        System.setProperty("apple.laf.useScreenMenuBar", "true");
        System.setProperty("apple.awt.application.name", "BalanceBuddy");
        FlatMacLightLaf.setup();

        // Test data
        Balance.setEntries(new BackupManager().load(new File("examples/esempi.balancebuddy")));

        SwingUtilities.invokeLater(BudgetBuddyFrame::new);
    }
}