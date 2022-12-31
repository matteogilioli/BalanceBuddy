package logic;

import java.time.LocalDateTime;

public abstract class VoceBilancio {
    private String descrizione;
    private double importo;
    private LocalDateTime data;

    public VoceBilancio(String descrizione, double importo) {
        this.data = LocalDateTime.now();
        this.descrizione = descrizione;
        this.importo = importo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public double getImporto() {
        return importo;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setImporto(double importo) {
        this.importo = importo;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}



