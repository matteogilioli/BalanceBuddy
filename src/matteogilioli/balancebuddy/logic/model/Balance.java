package matteogilioli.balancebuddy.logic.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * La classe {@link Balance} rappresenta il bilancio dell'applicazione.
 * Contiene un {@link ArrayList} di {@link BalanceEntry}, che rappresentano le varie {@link IncomeEntry entrate} e {@link ExpenseEntry uscite},
 * inoltre fornisce metodi per l'aggiunta, la rimozione e la modifica di queste.
 */
public final class Balance {
    /**
     * L'{@link ArrayList} di {@link BalanceEntry}, ovvero la lista di tutte le entrate e uscite.
     */
    private static final ArrayList<BalanceEntry> entries = new ArrayList<>();

    /**
     * Il metodo aggiunge una nuova {@link BalanceEntry} all'{@link ArrayList} di {@link BalanceEntry}.
     *
     * @param entry la nuova {@link BalanceEntry} da aggiungere.
     */
    public static void setEntry(BalanceEntry entry) {
        entries.add(entry);
    }

    /**
     * @return l'{@link ArrayList} di {@link BalanceEntry}, ovvero la lista di tutte le entrate e uscite.
     */
    public static ArrayList<BalanceEntry> getEntries() {
        return entries;
    }

    /**
     * Il metodo aggiunge un nuovo array di {@link BalanceEntry} all'esistente {@link ArrayList} di {@link BalanceEntry},
     * cancellando quello precedente.
     *
     * @param newEntries la nuova {@link ArrayList} di {@link BalanceEntry} da aggiungere.
     */
    public static void setEntries(ArrayList<BalanceEntry> newEntries) {
        entries.clear();
        entries.addAll(newEntries);
    }

    /**
     * Il metodo rimuove le {@link BalanceEntry} corrisspondenti agli indici passati come parametro.
     *
     * @param indexesToRemove gli indici delle {@link BalanceEntry} da rimuovere.
     */
    public static void removeEntries(int[] indexesToRemove) {
        Arrays.sort(indexesToRemove);
        for (int i = indexesToRemove.length - 1; i >= 0; i--)
            entries.remove(indexesToRemove[i]);
    }

    /**
     * Il metodo modifica l'importo di una {@link BalanceEntry} presente nell'{@link ArrayList} di {@link BalanceEntry}.
     * Se l'importo è negativo e la voce è una {@link IncomeEntry}, viene convertita in {@link ExpenseEntry},
     * mentre se è positivo ed è una {@link ExpenseEntry}, viene convertita in {@link IncomeEntry}.
     *
     * @param index     l'indice della {@link BalanceEntry} da modificare.
     * @param newAmount il nuovo importo della {@link BalanceEntry} (codificato come {@link BigDecimal}).
     */
    public static void editAmount(int index, BigDecimal newAmount) {
        BalanceEntry entry = entries.get(index);

        if (newAmount.compareTo(BigDecimal.valueOf(0)) < 0 && entry instanceof IncomeEntry)
            entries.set(index, new ExpenseEntry(entry.getDescription(), newAmount, entry.getDatetime()));
        else if (newAmount.compareTo(BigDecimal.valueOf(0)) >= 0 && entry instanceof ExpenseEntry)
            entries.set(index, new IncomeEntry(entry.getDescription(), newAmount, entry.getDatetime()));
        else entry.setAmount(newAmount);
    }
}
