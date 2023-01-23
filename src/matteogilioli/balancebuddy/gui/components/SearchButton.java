package matteogilioli.balancebuddy.gui.components;

import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.swing.FontIcon;

import javax.swing.*;
import java.awt.*;

/**
 * Il {@link JButton} accanto alla barra di ricerca, usato per avviare la ricerca.
 */
public class SearchButton extends JButton {
    /**
     * Icona del {@link JButton}.
     */
    private static final FontIcon icon = FontIcon.of(FontAwesomeSolid.SEARCH, 16, new Color(40, 100, 228));

    /**
     * Costruttore che inizializza il {@link JButton} con l'icona e il nome.
     */
    public SearchButton() {
        super(icon);
        this.setPreferredSize(new Dimension(30, 30));
    }
}
