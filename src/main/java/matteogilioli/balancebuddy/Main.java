package matteogilioli.balancebuddy;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import matteogilioli.balancebuddy.gui.BudgetBuddyFrame;
import matteogilioli.balancebuddy.logic.Balance;
import matteogilioli.balancebuddy.logic.ExpenseEntry;
import matteogilioli.balancebuddy.logic.IncomeEntry;

import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public final class Main {
    private static final Balance balance = new Balance();

    public static void main(String[] args) {
        FlatMacLightLaf.setup();

        populate(); // Examples

        BudgetBuddyFrame f = new BudgetBuddyFrame(balance);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public static void populate() {
        balance.addEntry(new ExpenseEntry("Netflix", new BigDecimal(14.99), randomDateTime()));
        balance.addEntry(new ExpenseEntry("Spesa", new BigDecimal(50), randomDateTime()));
        balance.addEntry(new IncomeEntry("Stipendio", new BigDecimal(800), randomDateTime()));
        balance.addEntry(new ExpenseEntry("Mancia", new BigDecimal(50), randomDateTime()));
        balance.addEntry(new ExpenseEntry("Ristorante Oriente", new BigDecimal(14.99), randomDateTime()));
        balance.addEntry(new IncomeEntry("Benzina", new BigDecimal(60), randomDateTime()));
    }

    public static LocalDateTime randomDateTime() {
        LocalDateTime from = LocalDateTime.of(2022, 6, 1, 0, 0);
        LocalDateTime to = LocalDateTime.now();
        long startSeconds = from.toEpochSecond(ZoneOffset.UTC);
        long endSeconds = to.toEpochSecond(ZoneOffset.UTC);
        long randomSeconds = startSeconds + new Random().nextInt((int)(endSeconds - startSeconds));
        return LocalDateTime.ofEpochSecond(randomSeconds, 0, ZoneOffset.UTC);
    }
}