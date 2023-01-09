package matteogilioli.balancebuddy.gui.logic;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class CurrencyFilter extends DocumentFilter {
    private boolean isValid(String string, FilterBypass fb, int offset) throws BadLocationException {
        String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());

        // Verifica se la stringa da inserire è un numero o una virgola
        if (string.matches("[0-9]*\\,?[0-9]*")) {
            // Verifica se nel testo c'è già un punto
            if (currentText.contains(",")) {
                // Se c'è un punto, verifica se la stringa da inserire è una virgola
                if (string.contains(","))
                    return false;

                // Verifica se la stringa viene inserita dopo la virgola
                int index = currentText.indexOf(",");
                if (offset > index)
                    // Se la stringa viene inserita dopo il punto, verifica il numero di cifre dopo il punto
                    if (currentText.length() - index > 2)
                        return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if (isValid(string, fb, offset))
            super.insertString(fb, offset, string, attr);
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String string, AttributeSet attr) throws BadLocationException {
        if (isValid(string, fb, offset))
            super.replace(fb, offset, length, string, attr);
    }
}
