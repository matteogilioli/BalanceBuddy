package matteogilioli.balancebuddy.gui.components;

import javax.swing.*;

public class SpinnerDate extends JSpinner {
    public SpinnerDate() {
        super(new SpinnerDateModel());
        DateEditor dateEditor = new DateEditor(this, "dd MMMM yyyy");
        this.setEditor(dateEditor);
    }
}
