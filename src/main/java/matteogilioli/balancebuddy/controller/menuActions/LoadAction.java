package matteogilioli.balancebuddy.controller.menuActions;

import matteogilioli.balancebuddy.controller.Utility;
import matteogilioli.balancebuddy.controller.table.BalanceTableModel;
import matteogilioli.balancebuddy.logic.file.FileLoadSave;
import matteogilioli.balancebuddy.logic.model.Balance;
import org.apache.commons.io.FilenameUtils;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.io.File;

public class LoadAction extends AbstractAction {
    private final BalanceTableModel tableModel;
    private final JFrame frame;

    public LoadAction(String name, JTable table) {
        super(name);
        this.tableModel = (BalanceTableModel) table.getModel();
        frame = Utility.getJFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Balancebuddy Backup", "balancebuddy");
        fileChooser.setFileFilter(filter);
        fileChooser.setAcceptAllFileFilterUsed(false);

        boolean fileLoaded = false;

        while (!fileLoaded) {
            Object data;
            int userSelection = fileChooser.showOpenDialog(frame);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                if (file.exists()) {
                    if (FilenameUtils.getExtension(file.getName()).equalsIgnoreCase("balancebuddy")) {
                        data = FileLoadSave.load(file);
                        if (data.getClass() == Balance.getEntries().getClass()) {
                            Balance.setEntries(data);
                            tableModel.refresh();
                            fileLoaded = true;
                            JOptionPane.showMessageDialog(frame, "Il bilancio è stato caricato con successo!");
                        } else JOptionPane.showMessageDialog(frame, "Errore durante il caricamento del bilancio.", "Errore", JOptionPane.ERROR_MESSAGE);
                    } else JOptionPane.showMessageDialog(frame, "Il file selezionato non è un backup di Balancebuddy.", "Errore", JOptionPane.ERROR_MESSAGE);
                } else JOptionPane.showMessageDialog(frame, "Il file selezionato non esiste.", "Errore", JOptionPane.ERROR_MESSAGE);
            } else if (userSelection == JFileChooser.CANCEL_OPTION) fileLoaded = true;
        }
    }
}
