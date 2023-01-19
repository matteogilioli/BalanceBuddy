package matteogilioli.balancebuddy.logic.actions.menuActions.file;

import matteogilioli.balancebuddy.logic.file.export.SaveCSV;
import matteogilioli.balancebuddy.logic.file.model.SaveFile;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ExportCSVAction extends AbstractAction {
    private final SaveFile csv;

    public ExportCSVAction(String name) {
        super(name);
        this.csv = new SaveCSV();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        csv.create();
    }
}