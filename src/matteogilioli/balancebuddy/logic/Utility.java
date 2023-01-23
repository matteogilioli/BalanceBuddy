package matteogilioli.balancebuddy.logic;

import javax.swing.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Classe che contiene metodi utili in tutto il programma.
 */
public final class Utility {
    /**
     * Il {@link JFrame} principale del programma.
     */
    private static JFrame mainFrame;

    /**
     * @return il {@link JFrame} principale del programma
     */
    public static JFrame getJFrame() {
        return mainFrame;
    }

    /**
     * Imposta il {@link JFrame} principale del programma.
     *
     * @param frame il {@link JFrame} principale del programma
     */
    public static void setJFrame(JFrame frame) {
        mainFrame = frame;
    }

    /**
     * Funzione per convertire l'input di un {@link JSpinner} in un {@link LocalDateTime},
     * basandosi sul {@link ZoneId} di default.
     *
     * @param datetime il {@link JSpinner} da convertire in {@link LocalDateTime}
     * @return il {@link LocalDateTime} convertito
     */
    public static LocalDateTime getDateTime(JSpinner datetime) {
        Object obj = datetime.getValue();
        Date date = (Date) obj;
        Instant inst = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(inst, zone);
    }

    /**
     * Funzione per convertire l'input di un {@link JSpinner} in un {@link LocalDate},
     * basandosi sul {@link ZoneId} di default.
     *
     * @param datetime il {@link JSpinner} da convertire in {@link LocalDate}
     * @return il {@link LocalDate} convertito
     */
    public static LocalDate getDate(JSpinner datetime) {
        Object obj = datetime.getValue();
        Date date = (Date) obj;
        Instant inst = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        return LocalDate.ofInstant(inst, zone);
    }
}
