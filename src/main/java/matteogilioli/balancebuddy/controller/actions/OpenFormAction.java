package matteogilioli.balancebuddy.controller.actions;

import matteogilioli.balancebuddy.view.FormDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class OpenFormAction extends AbstractAction {
    public OpenFormAction(String name) {
        super(name);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Nuova Entrata")) {
            new FormDialog("Entrata");
        } else if (e.getActionCommand().equals("Nuova Uscita")) {
            new FormDialog("Uscita");
        }
    }
}