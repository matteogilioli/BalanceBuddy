package matteogilioli.balancebuddy.gui;

import matteogilioli.balancebuddy.gui.panels.FiltersPanel;
import matteogilioli.balancebuddy.gui.panels.SearchPanel;
import matteogilioli.balancebuddy.gui.panels.TablePanel;
import matteogilioli.balancebuddy.logic.Utility;
import matteogilioli.balancebuddy.logic.file.backup.LoadBackup;
import matteogilioli.balancebuddy.logic.model.Balance;
import matteogilioli.balancebuddy.logic.table.BalanceTableModel;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class BudgetBuddyFrame extends JFrame {
    private final TablePanel tablePanel;
    private final SearchPanel searchPanel;
    private final FiltersPanel filtersPanel;

    public BudgetBuddyFrame() {
        super();

        Utility.setJFrame(this);
        tablePanel = new TablePanel();
        searchPanel = new SearchPanel(tablePanel.getTable());
        tablePanel.getTable().setSearchPanel(searchPanel);
        filtersPanel = new FiltersPanel(tablePanel.getTable());

        // Test data - DA CANCELLARE
        BalanceTableModel tableModel = (BalanceTableModel) tablePanel.getTable().getModel();
        Balance.setEntries(new LoadBackup(tableModel).load(new File("examples/esempi.balancebuddy")));
        tableModel.refresh();
        // Test data - DA CANCELLARE

        this.setJMenuBar(new MenuBar(tablePanel.getTable()));

        createGUI();
    }

    private void createGUI() {
        this.setTitle("BalanceBuddy");

        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.add(Box.createVerticalStrut(20));

        JPanel main = new JPanel(new GridBagLayout());
        main.add(Box.createHorizontalStrut(30));

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.add(searchPanel);
        leftPanel.add(Box.createVerticalStrut(20));
        leftPanel.add(filtersPanel);

        main.add(leftPanel);
        main.add(Box.createHorizontalStrut(20));
        main.add(tablePanel);
        main.add(Box.createHorizontalStrut(20));
        this.add(main);

        this.add(Box.createVerticalStrut(20));
        this.pack();
        this.setMinimumSize(this.getSize());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
