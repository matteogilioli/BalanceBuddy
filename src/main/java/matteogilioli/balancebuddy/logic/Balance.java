package matteogilioli.balancebuddy.logic;

import java.math.BigDecimal;
import java.util.ArrayList;

public final class Balance {
    private final ArrayList<BalanceEntry> entries = new ArrayList<>();
    private BigDecimal totalBalance = BigDecimal.valueOf(0);

    public void addEntry(BalanceEntry entry) {
        entries.add(entry);
        totalBalance = totalBalance.add(entry.getAmount());
    }

    public BigDecimal getTotal() {
        return totalBalance;
    }

    public ArrayList<BalanceEntry> getEntries() {
        return entries;
    }

    public void removeEntries(int[] indexesToRemove) {
        for (int i = indexesToRemove.length - 1; i >= 0; i--) {
            BalanceEntry entry = entries.get(indexesToRemove[i]);
            totalBalance = totalBalance.subtract(entry.getAmount());
            entries.remove(indexesToRemove[i]);
        }
    }

    public void editAmount(int index, BigDecimal newAmount) {
        BalanceEntry entry = entries.get(index);
        totalBalance = totalBalance.subtract(entry.getAmount());

        if (newAmount.compareTo(BigDecimal.valueOf(0)) < 0 && entry instanceof IncomeEntry)
            entries.set(index, new ExpenseEntry(entry.getDescription(), newAmount.negate(), entry.getDatetime()));
        else if (newAmount.compareTo(BigDecimal.valueOf(0)) >= 0 && entry instanceof ExpenseEntry)
            entries.set(index, new IncomeEntry(entry.getDescription(), newAmount, entry.getDatetime()));
        else
            entry.setAmount(newAmount);

        totalBalance = totalBalance.add(newAmount);
    }
}
