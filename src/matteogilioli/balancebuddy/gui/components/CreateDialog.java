package matteogilioli.balancebuddy.gui.components;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class CreateDialog extends JDialog {
    public CreateDialog() {
        super();
        JPanel panel = new JPanel();
        panel.add(new JLabel("Nuova voce"));
        this.getContentPane().add(panel);
        this.setVisible(true);
    }
}