import java.util.ArrayList;

public class HvitRute extends Rute {

    public HvitRute(int rad, int kol, Labyrint labyrint) {
        super(rad,kol,labyrint);
    }

    // oversskrider finn metode
    @Override
    public void finn(Rute fra) {
        if (fra == null) {
            // nord
            naboer[0].finn(this);
            // ost
            naboer[1].finn(this);
            // sor
            naboer[2].finn(this);
            // vest
            naboer[3].finn(this);
        } else {
            if (naboer[0] != null && naboer[0] != fra) {
                naboer[0].finn(this);
            }

            if (naboer[1] != null && naboer[1] != fra) {
                naboer[1].finn(this);
            }

            if (naboer[2] != null && naboer[2] != fra) {
                naboer[2].finn(this);
            }

            if (naboer[3] != null && naboer[3] != fra) {
                naboer[3].finn(this);
            }
        }

        return;
    }

    public char tilTegn() {
        return '.';
    }
}
