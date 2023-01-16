package matteogilioli.balancebuddy.controller.formatter;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;

public class LocaleNumberFormat extends NumberFormat {
    private static final NumberFormat nf = NumberFormat.getNumberInstance();

    public LocaleNumberFormat() {
        super();
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
    }

    @Override
    public StringBuffer format(double number, StringBuffer toAppendTo, FieldPosition pos) {
        return nf.format(number, toAppendTo, pos);
    }

    @Override
    public StringBuffer format(long number, StringBuffer toAppendTo, FieldPosition pos) {
        return nf.format(number, toAppendTo, pos);
    }

    @Override
    public Number parse(String source, ParsePosition parsePosition) {
        return nf.parse(source, parsePosition);
    }
}
