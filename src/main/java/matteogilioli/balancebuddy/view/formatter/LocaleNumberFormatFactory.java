package matteogilioli.balancebuddy.view.formatter;

import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;

public final class LocaleNumberFormatFactory extends DefaultFormatterFactory {
    private static final NumberFormat nf = NumberFormat.getNumberInstance();

    public LocaleNumberFormatFactory() {
        super(new NumberFormatter(nf));
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
    }
}
