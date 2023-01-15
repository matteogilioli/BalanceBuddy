package matteogilioli.balancebuddy.controller.formatter;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;

public class LocalePositiveNumberFormat extends NumberFormat {
    private static final NumberFormat nf = NumberFormat.getNumberInstance();

    public LocalePositiveNumberFormat() {
        super();
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
    }

    @Override
    public StringBuffer format(double number, StringBuffer toAppendTo, FieldPosition pos) {
        if (number < 0) number = Math.abs(number);
        return nf.format(number, toAppendTo, pos);
    }

    @Override
    public StringBuffer format(long number, StringBuffer toAppendTo, FieldPosition pos) {
        if (number < 0) number = Math.abs(number);
        return nf.format(number, toAppendTo, pos);
    }

    @Override
    public Number parse(String source, ParsePosition parsePosition) {
        Number number = nf.parse(source, parsePosition);
        if (number != null && number.doubleValue() < 0)
            number = Math.abs(number.doubleValue());
        return number;
    }
}
