package vonal;

public class Vonal {

    public static void main(String[] args) {
        try {

            Vonalak elso = new Vonalak(8, Vonalak.PIROS_SZIN, 11, Vonalak.DUPLA_V);
            Vonalak masodik = new Vonalak(4, "narancs", -1, Vonalak.DUPLA_V);
            Vonalak harmadik = new Vonalak(3, Vonalak.SARGA_SZIN, 4, "csíkos");

        } catch (Exception ex) {
            System.err.println("A program futása leállt!");
            System.err.println("HIBA! ---> " + ex.getMessage());
        }
    }

}
