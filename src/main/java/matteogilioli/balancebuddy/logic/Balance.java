package matteogilioli.balancebuddy.logic;

import java.util.ArrayList;

public final class Balance {
    private final ArrayList<BalanceEntry> entries = new ArrayList<>();
    private double totalBalance = 0;

    public void addEntry(BalanceEntry entry) {
        entries.add(entry);
        totalBalance += entry.getAmount();
    }

    public double getTotal() {
        return totalBalance;
    }

    public ArrayList<BalanceEntry> getEntries() {
        return entries;
    }

    public void removeEntries(int[] indexesToRemove) {
        for (int i = indexesToRemove.length - 1; i >= 0; i--) {
            BalanceEntry entry = entries.get(indexesToRemove[i]);
            totalBalance -= entry.getAmount();
            entries.remove(indexesToRemove[i]);
        }
    }
}
