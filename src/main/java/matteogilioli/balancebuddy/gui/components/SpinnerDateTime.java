package matteogilioli.balancebuddy.gui.components;

import javax.swing.*;

public class SpinnerDateTime extends JSpinner {
    public SpinnerDateTime() {
        super(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(this, "dd/MM/yyyy hh:mm");
        this.setEditor(dateEditor);
    }
}
