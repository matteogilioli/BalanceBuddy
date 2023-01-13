package matteogilioli.balancebuddy.gui.window;

import matteogilioli.balancebuddy.gui.menu.MyMenuBar;

import javax.swing.*;
import java.awt.*;

public class BudgetBuddyFrame extends JFrame {
    private JPanel tablePanel;
    private JPanel filtersPanel;

    public BudgetBuddyFrame() {
        super();

        this.setJMenuBar(new MyMenuBar());
        tablePanel = new TablePanel();
        filtersPanel = new FiltersPanel();

        createGUI();
    }

    private void createGUI() {
        this.setTitle("BalanceBuddy");

        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.add(Box.createVerticalStrut(20));

        JPanel main = new JPanel(new GridBagLayout());
        main.add(Box.createHorizontalStrut(30));
        main.add(filtersPanel);
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
