package matteogilioli.balancebuddy.logic;

import java.util.ArrayList;

public final class Balance {
    private static ArrayList<BalanceEntry> entries = new ArrayList<>();
    private static double totalBalance = 0;

    public static void newEntry(BalanceEntry entry) {
        entries.add(entry);
        if (entry instanceof IncomeEntry)
            totalBalance += entry.getAmount();
        else if (entry instanceof ExpenseEntry)
            totalBalance -= entry.getAmount();
    }

    public static double getTotalBalance() {
        return totalBalance;
    }

    public static ArrayList<BalanceEntry> getEntries() {
        return entries;
    }

    public static void removeEntries(int[] indexesToRemove) {
        for (int i = indexesToRemove.length - 1; i >= 0; i--) {
            BalanceEntry entry = entries.get(indexesToRemove[i]);
            if (entry instanceof IncomeEntry)
                totalBalance -= entry.getAmount();
            else if (entry instanceof ExpenseEntry)
                totalBalance += entry.getAmount();
            entries.remove(indexesToRemove[i]);
        }
    }
}
