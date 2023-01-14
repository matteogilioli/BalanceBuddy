package matteogilioli.balancebuddy.controller;

import javax.swing.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public final class Utility {
    public static LocalDateTime getDateTime(JSpinner datetime) {
        Object obj = datetime.getValue();
        Date date = (Date) obj;
        Instant inst = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(inst, zone);
    }

    public static LocalDate getDate(JSpinner datetime) {
        Object obj = datetime.getValue();
        Date date = (Date) obj;
        Instant inst = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        return LocalDate.ofInstant(inst, zone);
    }
}
