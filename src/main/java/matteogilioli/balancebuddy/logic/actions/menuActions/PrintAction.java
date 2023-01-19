package matteogilioli.balancebuddy.logic.actions.menuActions;

import matteogilioli.balancebuddy.gui.table.BalanceTable;
import matteogilioli.balancebuddy.logic.Utility;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.print.PrinterException;
import java.text.MessageFormat;

public class PrintAction extends AbstractAction {
    private final BalanceTable table;

    public PrintAction(String name, JTable table) {
        super(name);
        this.table = (BalanceTable) table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String header = "Bilancio";
        String footer = table.getTotalLabel().getText() + " - Pagina {0}";
        String errorMessage = "Errore durante la stampa";

        try {
            table.print(JTable.PrintMode.FIT_WIDTH, new MessageFormat(header), new MessageFormat(footer));
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(Utility.getJFrame(), errorMessage, "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }
}
