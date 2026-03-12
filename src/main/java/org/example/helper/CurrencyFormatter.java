package org.example.helper;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormatter {

    private static final Locale DEFAULT_LOCALE = Locale.GERMANY;

    public static String format(double amount) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(DEFAULT_LOCALE);
        return formatter.format(amount);
    }
}

