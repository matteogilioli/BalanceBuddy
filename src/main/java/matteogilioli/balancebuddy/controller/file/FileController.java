package matteogilioli.balancebuddy.controller.file;

import matteogilioli.balancebuddy.controller.Utility;
import org.apache.commons.io.FilenameUtils;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public abstract class FileController {
    private final JFileChooser fileChooser;
    private final String extensionDescription;
    private final String extensionName;
    private String defaultFileName;
    private boolean completed;

    public FileController(String extensionName, String extensionDescription) {
        this.extensionName = extensionName;
        this.extensionDescription = extensionDescription;
        fileChooser = new JFileChooser();
        defaultFileName = "";
    }

    public void create() {
        FileNameExtensionFilter filter = new FileNameExtensionFilter(extensionDescription, extensionName);
        fileChooser.setFileFilter(filter);
        fileChooser.setAcceptAllFileFilterUsed(false);

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