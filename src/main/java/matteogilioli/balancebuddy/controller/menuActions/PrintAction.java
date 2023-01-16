package matteogilioli.balancebuddy.controller.menuActions;

import matteogilioli.balancebuddy.controller.Utility;
import matteogilioli.balancebuddy.gui.table.BalanceTable;

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
        try {
            String total = table.getTotalLabel().getText();
            table.print(JTable.PrintMode.FIT_WIDTH, new MessageFormat("Bilancio"), new MessageFormat(total + " - Pagina {0}"));
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(Utility.getJFrame(), "Errore durante la stampa.", "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }
}
