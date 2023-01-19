package matteogilioli.balancebuddy.controller.menuActions.file;

import matteogilioli.balancebuddy.controller.file.export.SaveCSV;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ExportCSVAction extends AbstractAction {
    public ExportCSVAction(String name) {
        super(name);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new SaveCSV().create();
    }
}