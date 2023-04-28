abstract public class Rute {

    private Labyrint labyrint;
    protected int rad, kol;
    private Rute over, under, hoyre, venstre;
    private int skrivRad, skrivKol;
    protected Rute[] naboer = new Rute[4];

    public Rute (int rad, int kol, Labyrint labyrint) {
        this.rad = rad;
        this.kol = kol;
        this.labyrint = labyrint;
        skrivRad = rad + 1;
        skrivKol = kol + 1;
    }

    // fyller inn naboer
    public void fyllInnNaboer(Rute nord, Rute ost, Rute sor, Rute vest) {
        naboer[0] = nord;
        naboer[1] = ost;
        naboer[2] = sor;
        naboer[3] = vest;
    }

    // sjekker naboer
    public void sjekkNabo() {
        for (Rute nabo : naboer) {
            final String utskrift = nabo != null
                ? Character.toString(nabo.tilTegn())
                : "null";
                System.out.println(utskrift);
        }
    }

    abstract void finn(Rute fra);
    abstract char tilTegn();

}
