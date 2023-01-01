package matteogilioli.balancebuddy.logic;

public final class ExpenseEntry extends BalanceEntry {
    public ExpenseEntry(String description, double amount) {
        super(description, -amount);
    }

    @Override
    public void setAmount(double amount) {
        super.setAmount(-amount);
    }
}