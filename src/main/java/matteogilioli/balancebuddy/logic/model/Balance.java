package matteogilioli.balancebuddy.logic.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public final class Balance {
    private static final ArrayList<BalanceEntry> entries = new ArrayList<>();

    public static void addEntry(BalanceEntry entry) {
        entries.add(entry);
    }

    public static ArrayList<BalanceEntry> getEntries() {
        return entries;
    }

    public static void setEntries(ArrayList<BalanceEntry> data) {
        entries.clear();
        entries.addAll(data);
    }

    public static void removeEntries(int[] indexesToRemove) {
        Arrays.sort(indexesToRemove);
        for (int i = indexesToRemove.length - 1; i >= 0; i--)
            entries.remove(indexesToRemove[i]);
    }

    public static void editAmount(int index, BigDecimal newAmount) {
        BalanceEntry entry = entries.get(index);

        if (newAmount.compareTo(BigDecimal.valueOf(0)) < 0 && entry instanceof IncomeEntry)
            entries.set(index, new ExpenseEntry(entry.getDescription(), newAmount, entry.getDatetime()));
        else if (newAmount.compareTo(BigDecimal.valueOf(0)) >= 0 && entry instanceof ExpenseEntry)
            entries.set(index, new IncomeEntry(entry.getDescription(), newAmount, entry.getDatetime()));
        else entry.setAmount(newAmount);
    }
}
