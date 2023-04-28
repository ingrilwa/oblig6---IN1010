import java.util.ArrayList;

public class SortRute extends Rute {

    public SortRute(int rad, int kol, Labyrint labyrint) {
        super(rad,kol,labyrint);
    }

    // overskriver finn-metode
    @Override
    public void finn(Rute fra) {
        return;
    }

    public char tilTegn() {
        return '#';
    }

}
