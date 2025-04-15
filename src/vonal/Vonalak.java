package vonal;

public class Vonalak {

    public static final String PIROS_SZIN = "piros";
    public static final String ZOLD_SZIN = "zöld";
    public static final String SARGA_SZIN = "sárga";
    private int hossz;
    private String szin;
    private int eltolas;
    private String forma;
    public static final String SZAGGATOTT_V = "szaggatott";
    public static final String NORMAL_V = "normál";
    public static final String DUPLA_V = "dupla";
    public static final String PONT_V = "pont";

    public Vonalak(int hossz, String szin, int eltolas, String forma) throws IllegalArgumentException {
        if (!szin.equals(PIROS_SZIN) && !szin.equals(ZOLD_SZIN) && !szin.equals(SARGA_SZIN)) {
            throw new IllegalArgumentException("nem létező szín:" + szin);
        }
        if (!forma.equals(SZAGGATOTT_V) & !forma.equals(NORMAL_V) && !forma.equals(DUPLA_V) && !forma.equals(PONT_V)) {
            throw new IllegalArgumentException("Nem létező forma:" + forma);
        }
        if (hossz < 1) {
            throw new IllegalArgumentException("A hossz nem lehet 1-nél kisebb:" + hossz);
        }

        this.hossz = hossz;
        this.szin = szin;
        setEltolas(eltolas);
        this.forma = forma;

    }

    public void setEltolas(int ujeltolas) throws IllegalArgumentException {
        if (ujeltolas < 0) {
            throw new IllegalArgumentException("Az eltolás nem lehet negatív:" + eltolas);
        }
        this.eltolas = ujeltolas;
    }

    public int getHossz() {
        return this.hossz;
    }

    public void setSzin(String szin) {
        boolean joSzin = szin.equals(Vonalak.PIROS_SZIN)
                || szin.equals(Vonalak.ZOLD_SZIN)
                || szin.equals(Vonalak.SARGA_SZIN);
        if (!joSzin) {
            throw new IllegalArgumentException("Nem létező szín: " + szin);
        }
        this.szin = szin;
    }

    public void setSzin() {

        String RESET = "\u001B[0m";
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";
        String YELLOW = "\u001B[33m";

        String kod = "";
        switch (szin) {
            /* case "piros": */
            case Vonalak.PIROS_SZIN:
                kod = RED;
                break;
            //case "zöld":
            case Vonalak.ZOLD_SZIN:
                kod = GREEN;
                break;
            case Vonalak.SARGA_SZIN:
                kod = YELLOW;
                break;
            default:
                kod = RESET;
        }
        this.szin = kod;
    }

    public String vonalForma() {
        String SZAGGATOTT = " -";
        String NORMAL = "-";
        String DUPLA = "=";
        String POTTYOS = ".";
        String eredmeny = "";
        String RESET = "\u001B[30m";
        switch (forma) {
            case Vonalak.DUPLA_V:
                eredmeny = DUPLA;
                break;
            case Vonalak.PONT_V:
                eredmeny = POTTYOS;
                break;
            case Vonalak.NORMAL_V:
                eredmeny = NORMAL;
                break;
            case Vonalak.SZAGGATOTT_V:
                eredmeny = SZAGGATOTT;
                break;

        }
        return this.szin + eredmeny.repeat(hossz) + RESET;

    }

    public String getSzin() {
        return this.szin;
    }

    public int getEltolas() {
        return this.eltolas;
    }

    public String getForma() {
        return this.forma;
    }

}
