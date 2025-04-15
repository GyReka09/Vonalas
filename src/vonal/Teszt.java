package vonal;

public class Teszt {

    public static void main(String[] args) {
        helyesErtekek();
        tesztSzinHiba();
        tesztHosszHiba();
        tesztFormaHiba();
        tesztEltolasHiba();
    }

    public static void helyesErtekek() {
        Vonalak vonal = new Vonalak(4, Vonalak.SARGA_SZIN, 3, Vonalak.NORMAL_V);
        assert vonal.getSzin().equals(Vonalak.SARGA_SZIN) : "Szín nem megfelelő";
        assert vonal.getEltolas() == 3 : "Eltolás nem megfelelő";
        assert vonal.getHossz() == 4 : "Hossz nem megfelelő";
        assert vonal.getForma().equals(Vonalak.NORMAL_V) : "Froma nem megfelelő";

    }

    public static void tesztSzinHiba() {
        try {
            Vonalak vonal = new Vonalak(4, "hiba", 3, Vonalak.NORMAL_V);
            assert false : "hibas szin!";
        } catch (IllegalArgumentException e) {
            System.err.println("Szin hiba:" + e.getMessage());
        }
    }

    public static void tesztHosszHiba() {
        try {
            Vonalak vonal = new Vonalak(-1, Vonalak.SARGA_SZIN, 3, Vonalak.NORMAL_V);
            assert false : "Hibás hossz!";
        } catch (IllegalArgumentException e) {
            System.err.println("Hossz hiba:" + e.getMessage());
        }
    }

    public static void tesztFormaHiba() {
        try {
            Vonalak vonal = new Vonalak(4, Vonalak.SARGA_SZIN, 3, "fodros");
            assert false : "Hibás forma!";
        } catch (IllegalArgumentException e) {
            System.err.println("Rossz forma: " + e.getMessage());
        }
    }

    public static void tesztEltolasHiba() {
        try {
            Vonalak vonal = new Vonalak(4, Vonalak.SARGA_SZIN, -9, Vonalak.NORMAL_V);
            assert false : "Nem jo eltolás";
        } catch (IllegalArgumentException e) {
            System.err.println("Rossz eltolás: " + e.getMessage());
        }
    }
}
