package matteogilioli.balancebuddy.controller.menuActions.file;

import matteogilioli.balancebuddy.controller.file.export.SaveText;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ExportTextAction extends AbstractAction {
    public ExportTextAction(String name) {
        super(name);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new SaveText().create();
    }
}