public class Aapning extends HvitRute {

    public Aapning(int rad, int kol, Labyrint labyrint) {
        super(rad,kol,labyrint);
    }

    // overskriver finn-metode
    @Override
    public void finn(Rute fra) {
        System.out.println("(" + kol + "," + rad + ")");
        return;
    }

}
