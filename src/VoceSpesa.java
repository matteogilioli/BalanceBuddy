import java.util.Date;

public class VoceSpesa extends VoceBilancio {
    public VoceSpesa(Date data, String descrizione, double importo) {
        super(data, descrizione, -importo);
    }

    public VoceSpesa(String descrizione, double importo) {
        super(descrizione, -importo);
    }
}