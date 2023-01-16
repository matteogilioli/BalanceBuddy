package matteogilioli.balancebuddy.controller.menuActions;

import matteogilioli.balancebuddy.controller.Utility;
import matteogilioli.balancebuddy.controller.table.BalanceTableModel;
import matteogilioli.balancebuddy.logic.file.FileLoadSave;
import matteogilioli.balancebuddy.logic.model.Balance;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class LoadAction extends AbstractAction {
    private final BalanceTableModel tableModel;

    public LoadAction(String name, JTable table) {
        super(name);
        this.tableModel = (BalanceTableModel) table.getModel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame = Utility.getJFrame();

        Object data;

        JFileChooser fileChooser = new JFileChooser();
        int userSelection = fileChooser.showSaveDialog(frame);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            data = FileLoadSave.load(fileChooser.getSelectedFile());
            if (data.getClass() == Balance.getEntries().getClass()) {
                Balance.setEntries(data);
                tableModel.refresh();
                JOptionPane.showMessageDialog(frame, "Il bilancio è stato caricato con successo!");
            } else
                JOptionPane.showMessageDialog(null, "Errore durante il caricamento del bilancio.", "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }
}
