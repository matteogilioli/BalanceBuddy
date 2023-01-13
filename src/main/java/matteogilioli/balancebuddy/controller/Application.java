package matteogilioli.balancebuddy.controller;

import matteogilioli.balancebuddy.controller.table.BalanceTableModel;

import javax.swing.*;

public class Application {
    private static JFrame mainFrame;
    private static BalanceTableModel tableModel;

    public static void setMainFrame(JFrame frame) {
        mainFrame = frame;
    }

    public static JFrame getMainFrame() {
        return mainFrame;
    }

    public static void setTableModel(BalanceTableModel model) {
        tableModel = model;
    }

    public static void refreshData () {
        tableModel.refresh();
    }
}
