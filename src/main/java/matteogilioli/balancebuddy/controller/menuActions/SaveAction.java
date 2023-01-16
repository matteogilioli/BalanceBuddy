package matteogilioli.balancebuddy.controller.menuActions;

import matteogilioli.balancebuddy.controller.Utility;
import matteogilioli.balancebuddy.logic.file.FileLoadSave;
import matteogilioli.balancebuddy.logic.model.Balance;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SaveAction extends AbstractAction {
    public SaveAction(String name) {
        super(name);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame = Utility.getJFrame();

        JFileChooser fileChooser = new JFileChooser();
        int userSelection = fileChooser.showSaveDialog(frame);
        if (userSelection == JFileChooser.APPROVE_OPTION)
            if (FileLoadSave.save(Balance.getEntries(), fileChooser.getSelectedFile()))
                JOptionPane.showMessageDialog(frame, "Il bilancio è stato salvato con successo!");
            else
                JOptionPane.showMessageDialog(null, "Errore durante il salvataggio del bilancio.", "Errore", JOptionPane.ERROR_MESSAGE);
    }
}
