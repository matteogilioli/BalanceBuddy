package matteogilioli.balancebuddy.view.components;

import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.swing.FontIcon;

import javax.swing.*;
import java.awt.*;

public class SearchButton extends JButton {
    private static final FontIcon icon = FontIcon.of(FontAwesomeSolid.SEARCH, 16, Color.GRAY);

    public SearchButton() {
        super(icon);
        this.setPreferredSize(new Dimension(30, 30));
    }
}
