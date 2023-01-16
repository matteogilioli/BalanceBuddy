package matteogilioli.balancebuddy.controller.menuActions;

import matteogilioli.balancebuddy.controller.Utility;
import matteogilioli.balancebuddy.logic.file.FileLoadSave;
import matteogilioli.balancebuddy.logic.model.Balance;
import org.apache.commons.io.FilenameUtils;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SaveAction extends AbstractAction {
    private final JFrame frame;

    public SaveAction(String name) {
        super(name);
        frame = Utility.getJFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Balancebuddy Backup", "balancebuddy");
        fileChooser.setFileFilter(filter);
        fileChooser.setAcceptAllFileFilterUsed(false);

        LocalDateTime now = LocalDateTime.now();
        String defaultFileName = String.format("Backup %s.balancebuddy", now.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        File defaultFile = new File(defaultFileName);

        boolean fileSaved = false;

        while (!fileSaved) {
            fileChooser.setSelectedFile(defaultFile);
            int userSelection = fileChooser.showSaveDialog(frame);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                if (!FilenameUtils.getExtension(file.getName()).equalsIgnoreCase("balancebuddy"))
                    file = new File(file + ".balancebuddy");
                if (file.exists()) {
                    int confirm = JOptionPane.showConfirmDialog(frame, "Il file esiste già, vuoi sovrascriverlo?", "Conferma sovrascrittura", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION)
                        fileSaved = saveFile(file);
                } else fileSaved = saveFile(file);
            } else if (userSelection == JFileChooser.CANCEL_OPTION)
                fileSaved = true;
        }
    }

    private boolean saveFile(File file) {
        if (FileLoadSave.save(Balance.getEntries(), file)) {
            JOptionPane.showMessageDialog(frame, "Il bilancio è stato salvato con successo!");
            return true;
        } else {
            JOptionPane.showMessageDialog(frame, "Errore durante il salvataggio del bilancio.", "Errore", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}