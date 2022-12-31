package logic;

import java.util.Date;

public class VoceEntrata extends VoceBilancio {
    public VoceEntrata(Date data, String descrizione, double importo) {
        super(data, descrizione, importo);
    }

    public VoceEntrata(String descrizione, double importo) {
        super(descrizione, importo);
    }
}
