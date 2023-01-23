package matteogilioli.balancebuddy.logic.table.filter;

import matteogilioli.balancebuddy.gui.panels.FiltersPanel;
import matteogilioli.balancebuddy.logic.table.BalanceTableModel;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.WeekFields;

/**
 * Un {@link RowFilter} personalizzato per filtrare la tabella basandosi sulle date in input fornite da {@link FiltersPanel}.
 */
public class DateRowFilter extends RowFilter<BalanceTableModel, Integer> {
    /**
     * Un {@link FilterType} per rappresentare i possibili tipi di filtro.
     */
    private FilterType filterType;

    /**
     * La data d'inizio del filtro.
     */
    private LocalDate startDate;

    /**
     * Un oggetto {@link LocalDate} che rappresenta la data di fine del filtro (facoltativa).
     */
    private LocalDate endDate;

    /**
     * Costruttore della classe.
     * All'inizio il filtro è di tipo {@link FilterType#ALL}.
     */
    public DateRowFilter() {
        filterType = FilterType.ALL;
    }

    /**
     * Imposta il filtro
     *
     * @param filterType il tipo di filtro
     * @param startDate  la data d'inizio del filtro
     * @param endDate    la data di fine del filtro
     */
    public void setFilter(FilterType filterType, LocalDate startDate, LocalDate endDate) {
        this.filterType = filterType;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * Ritorna true se la riga passata come parametro deve essere mostrata nella tabella, false altrimenti.
     *
     * @param entry un oggetto non null che corrisponde all'elemento da filtrare
     * @return true se l'elemento dovrebbe essere mostrato
     */
    @Override
    public boolean include(Entry<? extends BalanceTableModel, ? extends Integer> entry) {
        BalanceTableModel model = entry.getModel();
        int row = entry.getIdentifier();
        LocalDate date = ((LocalDateTime) model.getValueAt(row, 0)).toLocalDate();

        return switch (filterType) {
            case ALL -> true;
            case YEAR -> date.getYear() == startDate.getYear();
            case MONTH -> date.getMonth() == startDate.getMonth() && date.getYear() == startDate.getYear();
            case WEEK ->
                    date.get(WeekFields.ISO.weekOfWeekBasedYear()) == startDate.get(WeekFields.ISO.weekOfWeekBasedYear()) && date.getYear() == startDate.getYear();
            case DAY -> date.isEqual(startDate);
            case CUSTOM ->
                    (date.isEqual(startDate) || date.isAfter(startDate)) && (date.isEqual(endDate) || date.isBefore(endDate));
        };
    }
}

