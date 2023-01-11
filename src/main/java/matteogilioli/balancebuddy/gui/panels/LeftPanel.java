package matteogilioli.balancebuddy.gui.panels;

import matteogilioli.balancebuddy.logic.Balance;

import javax.swing.*;
import java.awt.*;

public class LeftPanel extends JPanel {
    private static final JLabel[] titoli = {
            new JLabel("Filtri"),
            new JLabel("Crea nuovo movimento")
    };

    public LeftPanel(Balance balance, TablePanel tablePanel) {
        super();
        createGUI(new FiltersPanel(), new FormPanel(balance, tablePanel));
    }

    public void createGUI(JPanel filtersPanel, JPanel formPanel) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        for (int i = 0; i < titoli.length; i++) {
            titoli[i].setFont(new Font("Arial", Font.BOLD, 18));
            titoli[i].setAlignmentX(Component.CENTER_ALIGNMENT);
        }

        this.add(titoli[0]);
        this.add(Box.createVerticalStrut(5));
        this.add(filtersPanel);
        this.add(Box.createVerticalStrut(40));
        this.add(titoli[1]);
        this.add(Box.createVerticalStrut(5));
        this.add(formPanel);
    }
 }
