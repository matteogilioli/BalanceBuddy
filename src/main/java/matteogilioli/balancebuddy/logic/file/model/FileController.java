package matteogilioli.balancebuddy.logic.file.model;

import matteogilioli.balancebuddy.logic.Utility;
import org.apache.commons.io.FilenameUtils;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public abstract class FileController {
    private final JFileChooser fileChooser;
    private final String extensionName;
    private String defaultFileName;
    private boolean completed;

    public FileController(String extensionName, String extensionDescription) {
        this.extensionName = extensionName;
        fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter(extensionDescription, extensionName));
        fileChooser.setAcceptAllFileFilterUsed(false);
        defaultFileName = "";
    }

    public void create() {
        File defaultFile = new File(defaultFileName);

        completed = false;
        while (!completed) {
            fileChooser.setSelectedFile(defaultFile);
            int userSelection = dialogFunction(Utility.getJFrame());
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                boolean extensionIsCorrect = FilenameUtils.getExtension(file.getName()).equals(extensionName);
                loadingOrSaving(file, extensionIsCorrect);
            } else if (userSelection == JFileChooser.CANCEL_OPTION) completed = true;
        }
    }

    protected void setCompleted(boolean completed) {
        this.completed = completed;
    }

    protected JFileChooser getFileChooser() {
        return fileChooser;
    }

    protected String getExtensionName() {
        return extensionName;
    }

    protected void setDefaultFileName(String defaultFileName) {
        this.defaultFileName = defaultFileName;
    }

    protected abstract void loadingOrSaving(File file, boolean extensionIsCorrect);
    protected abstract int dialogFunction(JFrame frame);
}