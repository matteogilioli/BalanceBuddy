package matteogilioli.balancebuddy.logic.formatter;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;

/**
 * {@link NumberFormat} che formatta i numeri in modo che siano sempre positivi.
 */
public class LocalePositiveNumberFormat extends NumberFormat {
    /**
     * Il {@link NumberFormat} che verrà usato al posto dell'originale.
     */
    private static final NumberFormat nf = NumberFormat.getNumberInstance();

    /**
     * Imposta il {@link NumberFormat} in modo che abbia sempre due cifre decimali.
     */
    public LocalePositiveNumberFormat() {
        super();
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
    }

    /**
     * Rende il numero positivo e utilizza il {@link NumberFormat#format(double)} per formattarlo.
     */
    @Override
    public StringBuffer format(double number, StringBuffer toAppendTo, FieldPosition pos) {
        if (number < 0) number = Math.abs(number);
        return nf.format(number, toAppendTo, pos);
    }

    /**
     * Rende il numero positivo e utilizza il {@link NumberFormat#format(long)} per formattarlo.
     */
    @Override
    public StringBuffer format(long number, StringBuffer toAppendTo, FieldPosition pos) {
        if (number < 0) number = Math.abs(number);
        return nf.format(number, toAppendTo, pos);
    }

    /**
     * Rende il numero positivo e utilizza {@link NumberFormat#parse(String)} per parsarlo.
     */
    @Override
    public Number parse(String source, ParsePosition parsePosition) {
        Number number = nf.parse(source, parsePosition);
        if (number != null && number.doubleValue() < 0)
            number = Math.abs(number.doubleValue());
        return number;
    }
}
