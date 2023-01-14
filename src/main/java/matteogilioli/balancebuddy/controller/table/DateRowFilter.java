package matteogilioli.balancebuddy.controller.table;

import matteogilioli.balancebuddy.model.FilterType;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.WeekFields;

public class DateRowFilter extends RowFilter<BalanceTableModel, Integer> {
    private FilterType filterType;
    private LocalDate startDate;
    private LocalDate endDate;

    public DateRowFilter() {
        filterType = FilterType.ALL;
    }

    @Override
    public boolean include(Entry<? extends BalanceTableModel, ? extends Integer> entry) {
        BalanceTableModel model = entry.getModel();
        int row = entry.getIdentifier();
        LocalDate date = ((LocalDateTime) model.getValueAt(row, 0)).toLocalDate();

        switch (filterType) {
            case ALL:
                return  true;
            case YEAR:
                return  date.getYear() == startDate.getYear();
            case MONTH:
                return  date.getMonth() == startDate.getMonth() &&
                        date.getYear() == startDate.getYear();
            case WEEK:
                return  date.get(WeekFields.ISO.weekOfWeekBasedYear()) == startDate.get(WeekFields.ISO.weekOfWeekBasedYear()) &&
                        date.getYear() == startDate.getYear();
            case DAY:
                return  date.isEqual(startDate);
            case CUSTOM:
                return  (date.isEqual(startDate) || date.isAfter(startDate)) &&
                        (date.isEqual(endDate) || date.isBefore(endDate));
            default:
                return false;
        }
    }

    public void setFilter(FilterType filterType, LocalDate startDate, LocalDate endDate) {
        this.filterType = filterType;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}

