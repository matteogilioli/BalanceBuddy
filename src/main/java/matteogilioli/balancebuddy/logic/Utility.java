package matteogilioli.balancebuddy.logic;

import javax.swing.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public final class Utility {
    private static JFrame mainFrame;

    public static void setJFrame(JFrame frame) {
        mainFrame = frame;
    }

    public static JFrame getJFrame() {
        return mainFrame;
    }

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
