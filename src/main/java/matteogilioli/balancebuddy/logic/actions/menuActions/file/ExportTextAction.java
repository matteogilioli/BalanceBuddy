package matteogilioli.balancebuddy.logic.actions.menuActions.file;

import matteogilioli.balancebuddy.logic.file.export.SaveText;
import matteogilioli.balancebuddy.logic.file.model.SaveFile;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ExportTextAction extends AbstractAction {
    private final SaveFile text;

    public ExportTextAction(String name) {
        super(name);
        this.text = new SaveText();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        text.create();
    }
}