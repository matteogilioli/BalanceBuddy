package matteogilioli.balancebuddy;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import matteogilioli.balancebuddy.model.Balance;
import matteogilioli.balancebuddy.model.ExpenseEntry;
import matteogilioli.balancebuddy.model.IncomeEntry;
import matteogilioli.balancebuddy.view.BudgetBuddyFrame;

import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Random;

public final class Main {
    public static void main(String[] args) {
        System.setProperty("apple.laf.useScreenMenuBar", "true");
        System.setProperty("apple.awt.application.name", "BalanceBuddy");
        FlatMacLightLaf.setup();
        populate(); // Examples

        SwingUtilities.invokeLater(BudgetBuddyFrame::new);
    }

    public static void populate() {
        Balance.addEntry(new ExpenseEntry("Netflix", BigDecimal.valueOf(14.99), randomDateTime()));
        Balance.addEntry(new ExpenseEntry("Spesa", BigDecimal.valueOf(100), randomDateTime()));
        Balance.addEntry(new IncomeEntry("Stipendio Gennaio", BigDecimal.valueOf(800), randomDateTime()));
        Balance.addEntry(new IncomeEntry("Mancia dei Nonni", BigDecimal.valueOf(50), randomDateTime()));
        Balance.addEntry(new ExpenseEntry("Ristorante Oriente", BigDecimal.valueOf(15), randomDateTime()));
        Balance.addEntry(new ExpenseEntry("Benzina", BigDecimal.valueOf(60), randomDateTime()));
        Balance.addEntry(new ExpenseEntry("Biglietto del cinema", BigDecimal.valueOf(7), randomDateTime()));
        Balance.addEntry(new IncomeEntry("Stipendio Febbraio", BigDecimal.valueOf(1000), randomDateTime()));
        Balance.addEntry(new ExpenseEntry("Shopping vestiti", BigDecimal.valueOf(65.90), randomDateTime()));
        Balance.addEntry(new ExpenseEntry("Ferramenta", BigDecimal.valueOf(7.50), randomDateTime()));
    }

    public static LocalDateTime randomDateTime() {
        LocalDateTime from = LocalDateTime.of(2021, 7, 1, 0, 0);
        LocalDateTime to = LocalDateTime.now();
        long startSeconds = from.toEpochSecond(ZoneOffset.UTC);
        long endSeconds = to.toEpochSecond(ZoneOffset.UTC);
        long randomSeconds = startSeconds + new Random().nextInt((int)(endSeconds - startSeconds));
        return LocalDateTime.ofEpochSecond(randomSeconds, 0, ZoneOffset.UTC);
    }
}