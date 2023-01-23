package matteogilioli.balancebuddy.logic.table.filter;

/**
 * Un'enumerazione per rappresentare tutti i possibili tipi di filtro.
 */
public enum FilterType {
    /**
     * Tipo di filtro che mostra tutti i dati.
     */
    ALL(0),
    /**
     * Tipo di filtro che mostra i movimenti dell'anno corrispondente alla data d'inizio.
     */
    YEAR(1),
    /**
     * Tipo di filtro che mostra i movimenti del mese corrispondente alla data d'inizio.
     */
    MONTH(2),
    /**
     * Tipo di filtro che mostra i movimenti della settimana corrispondente alla data d'inizio.
     */
    WEEK(3),
    /**
     * Tipo di filtro che mostra i movimenti del giorno corrispondente alla data d'inizio.
     */
    DAY(4),
    /**
     * Tipo di filtro che mostra i movimenti compresi tra le date d'inizio e fine.
     */
    CUSTOM(5);

    /**
     * Un intero che rappresenta il valore dell'enumerazione.
     */
    private final int index;

    /**
     * Costruttore della classe, imposta l'intero che rappresenta il valore dell'enumerazione.
     *
     * @param index il valore dell'enumerazione
     */
    FilterType(int index) {
        this.index = index;
    }

    /**
     * @param index il valore dell'enumerazione
     * @return il tipo di filtro corrispondente al valore passato
     */
    public static FilterType get(int index) {
        for (FilterType filterType : values())
            if (filterType.index == index)
                return filterType;
        throw new IllegalArgumentException("Invalid index: " + index);
    }
}
