package logic;

import java.util.ArrayList;

public class Bilancio {

    private static ArrayList<VoceBilancio> voci;
    private static double saldo = 0;

    public Bilancio() {
        voci = new ArrayList<VoceBilancio>();
    }

    public static void aggiungi(VoceBilancio voce) {
        voci.add(voce);
        if (voce instanceof VoceEntrata)
            saldo += voce.getImporto();
        else if (voce instanceof VoceSpesa)
            saldo -= voce.getImporto();
    }

    public static double getSaldo() {
        return saldo;
    }

    public static ArrayList<VoceBilancio> getVoci() {
        return voci;
    }
}
