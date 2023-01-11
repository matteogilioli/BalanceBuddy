package matteogilioli.balancebuddy.gui.panels;

import javax.swing.*;
import java.awt.*;

public class GenericFormPanel extends JPanel {
    public GenericFormPanel() {
        super(new GridBagLayout());
    }

    public void populate(String[] labels, JComponent[] components, JButton submitButton) {
        GridBagConstraints c = new GridBagConstraints();

        for (int i = 0; i < components.length; i++) {
            c.anchor = GridBagConstraints.LINE_END; c.gridx = 0; c.gridy = i;
            c.insets = new Insets(5, 0, 0, 10);
            this.add(new JLabel(labels[i]), c);
            c.insets = new Insets(5, 0, 0, 0);
            c.anchor = GridBagConstraints.LINE_START; c.gridx = 1;
            components[i].setPreferredSize(new Dimension(180, 30));
            this.add(components[i], c);
        }

        if (submitButton != null) {
            c.gridx = 1; c.gridy = components.length + 1;
            this.add(submitButton, c);
        }
    }

    public void populate(String[] labels, JComponent[] components) {
        this.populate(labels, components, null);
    }
}
