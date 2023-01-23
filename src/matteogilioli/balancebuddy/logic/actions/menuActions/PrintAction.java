package matteogilioli.balancebuddy.logic.actions.menuActions;

import matteogilioli.balancebuddy.gui.MenuBar;
import matteogilioli.balancebuddy.gui.table.BalanceTable;
import matteogilioli.balancebuddy.logic.Utility;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.print.PrinterException;
import java.text.MessageFormat;

/**
 * Un'{@link AbstractAction} del {@link MenuBar Menubar} che si occupa stampa la tabella.
 */
public class PrintAction extends AbstractAction {
    /**
     * La tabella da stampare.
     */
    private final BalanceTable table;

    /**
     * Costruttore che inizializza l'{@link AbstractAction} con il nome nel {@link MenuBar Menubar},
     * inizializza {@link #table} con la tabella passata come parametro.
     *
     * @param name  il nome dell'{@link AbstractAction} nel {@link MenuBar Menubar}
     * @param table la tabella da stampare
     */
    public PrintAction(String name, JTable table) {
        super(name);
        this.table = (BalanceTable) table;
    }

    /**
     * Stampa la tabella, utilizzando {@link JTable#print(JTable.PrintMode, MessageFormat, MessageFormat)}.
     * Imposta un header e un footer (contenente il totale) per la stampa.
     * Se la stampa non è andata a buon fine, viene mostrato un messaggio di errore.
     *
     * @param e l'{@link ActionEvent} che ha generato l'azione
     */
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
