import java.util.Date;

public abstract class VoceBilancio {
    private Date data;
    private String descrizione;
    private double importo;

    public VoceBilancio(Date data, String descrizione, double importo) {
        this.data = data;
        this.descrizione = descrizione;
        this.importo = importo;
    }

    public VoceBilancio(String descrizione, double importo) {
        this(new Date(), descrizione, importo);
    }

    public Date getData() {
        return data;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public double getImporto() {
        return importo;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setImporto(double importo) {
        this.importo = importo;
    }
}



