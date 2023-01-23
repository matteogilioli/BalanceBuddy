package matteogilioli.balancebuddy.gui.table.renderer;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Classe che estende {@link CellColor} per renderizzare le celle della tabella
 * corrispondenti a date, in modo da formattarle secondo il pattern specificato.
 */
public class DateCellColor extends CellColor {
    /**
     * Il formato utilizzato per formattare le date.
     */
    private final DateTimeFormatter formatter;

    /**
     * Costruttore che inizializza {@link #formatter} con un pattern.
     */
    public DateCellColor() {
        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    }

    /**
     * Formatta la data in input, e la imposta.
     * @param value la data da formattare
     */
    @Override
    public void setValue(Object value) {
        setText(((LocalDateTime) value).format(formatter));
        this.setHorizontalAlignment(JLabel.CENTER);
    }
}