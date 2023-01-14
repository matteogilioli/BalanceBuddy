package matteogilioli.balancebuddy.model;

import java.util.ArrayList;

public enum FilterType {
    ALL(0), YEAR(1), MONTH(2), WEEK(3), DAY(4), CUSTOM(5);

    FilterType(int i) { }

    public static FilterType get(int i) {
        return values()[i];
    }
}
