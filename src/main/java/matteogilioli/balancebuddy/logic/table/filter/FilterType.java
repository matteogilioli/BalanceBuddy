package matteogilioli.balancebuddy.logic.table.filter;

public enum FilterType {
    ALL(0), YEAR(1), MONTH(2), WEEK(3), DAY(4), CUSTOM(5);

    private final int index;

    FilterType(int index) {
        this.index = index;
    }

    public static FilterType get(int index) {
        for (FilterType filterType : values()) {
            if (filterType.index == index) {
                return filterType;
            }
        }
        throw new IllegalArgumentException("Invalid index: " + index);
    }
}
