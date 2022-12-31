package logic;

public class VoceSpesa extends VoceBilancio {
    public VoceSpesa(String descrizione, double importo) {
        super(descrizione, -importo);
    }

    @Override
    public void setImporto(double importo) {
        super.setImporto(-importo);
    }
}