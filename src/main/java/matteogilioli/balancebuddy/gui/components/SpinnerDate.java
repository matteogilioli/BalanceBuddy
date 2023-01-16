package matteogilioli.balancebuddy.gui.components;

import javax.swing.*;

public class SpinnerDate extends JSpinner {
    public SpinnerDate(String dateFormatPattern) {
        super(new SpinnerDateModel());
        DateEditor dateEditor = new DateEditor(this, dateFormatPattern);
        this.setEditor(dateEditor);
    }
}
