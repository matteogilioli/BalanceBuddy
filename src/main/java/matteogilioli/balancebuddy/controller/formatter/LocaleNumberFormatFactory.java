package matteogilioli.balancebuddy.controller.formatter;

import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

public final class LocaleNumberFormatFactory extends DefaultFormatterFactory {
    public LocaleNumberFormatFactory() {
        super(new NumberFormatter(new LocaleNumberFormat()));
    }
}
