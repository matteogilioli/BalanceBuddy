package matteogilioli.balancebuddy.gui.components;

import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.swing.FontIcon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Il {@link JButton} per eliminare uno o più movimenti.
 */
public class DeleteButton extends JButton {
    /**
     * Icona del {@link JButton}.
     */
    private static final FontIcon icon = FontIcon.of(FontAwesomeSolid.TRASH_ALT, 16, Color.RED);

    /**
     * Costruttore che inizializza il {@link JButton} con l'icona e il nome.
     *
     * @param onDeleteButtonClick l'{@link ActionListener} che gestisce il click sul {@link JButton}
     */
    public DeleteButton(ActionListener onDeleteButtonClick) {
        super("Elimina selezionati", icon);
        this.addActionListener(onDeleteButtonClick);
        this.setPreferredSize(new Dimension(180, 35));
    }
}
