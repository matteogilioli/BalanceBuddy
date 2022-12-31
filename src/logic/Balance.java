package logic;

import java.util.ArrayList;

public class Balance {

    private static ArrayList<BalanceEntry> entries;
    private static double totalBalance = 0;

    public Balance() {
        entries = new ArrayList<BalanceEntry>();
    }

    public static void aggiungi(BalanceEntry entry) {
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
}
