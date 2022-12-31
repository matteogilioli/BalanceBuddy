package logic;

public class Bilancio {
    private static double saldo = 0;

    public static void aggiungi(VoceBilancio voce) {
        if (voce instanceof VoceEntrata)
            saldo += voce.getImporto();
        else if (voce instanceof VoceSpesa)
            saldo -= voce.getImporto();
    }

    public static double getSaldo() {
        return saldo;
    }
}
