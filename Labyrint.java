import java.util.Scanner;
import java.io.*;

public class Labyrint {

    private Rute[][] labyrint;
    private int rader;
    private int kolonner;

    public Labyrint(String filnavn) throws FileNotFoundException {
        Scanner input = new Scanner(new File(filnavn));
        String[] stoerrelse = input.nextLine().strip().split(" ");
        // setter opp teller for å ha oversikt over Y kordinat
        int y = 0;
        rader = Integer.parseInt(stoerrelse[0]);
        kolonner = Integer.parseInt(stoerrelse[1]);
        labyrint = new Rute[rader][kolonner];
        // setter opp teller for linjenummer
        int linje_nummer = 1;
        while (input.hasNextLine()) {
            String[] linje = input.nextLine().strip().split("");
            for (int i = 0; i < linje.length; i++) {
                Rute rute = null;
                // sjekker forste og siste linje for aapninger
                if (linje_nummer == 1 || linje_nummer == rader + 1) {
                    if (linje[i].equals(".")) rute = new Aapning(i, y, this);
                    else if (linje[i].equals("#")) rute = new SortRute(i, y, this);
                }

                else {
                    if (linje[i].equals(".") && (i == linje.length - 1 || i == 0)) rute = new Aapning(i, y, this);
                    else if (linje[i].equals(".")) rute = new HvitRute(i, y, this);
                    else if (linje[i].equals("#")) rute = new SortRute(i, y, this);
                }

                labyrint[y][i] = rute;
            }
            linje_nummer++;
            y++;
        }

        // finner naboer til alle ruter
        for (int i = 0; i < rader; i++) {
            for (int j = 0; j < kolonner; j++) {
                Rute nord = null;
                Rute ost = null;
                Rute sor = null;
                Rute vest = null;

                // sjekker nabo nord for ruten
                if (i - 1 >= 0) {
                    nord = labyrint[i - 1][j];
                }

                // sjekker nabo ost for ruten
                if (j + 1 <= kolonner - 1) {
                    ost = labyrint[i][j + 1];
                }

                // sjekker nabo sor for ruten
                if (i + 1 <= rader - 1) {
                    sor = labyrint[i + 1][j];
                }

                // sjekker nabo vest for ruten
                if (j - 1 >= 0) {
                    vest = labyrint[i][j - 1];
                }

                labyrint[i][j].fyllInnNaboer(nord, ost, sor, vest);
            }
        }
    }

    public void finnUtveiFra(int rad, int kol) {
        if (labyrint[rad][kol] instanceof SortRute) {
            System.out.println("Kan ikke starte i sort rute.");
            return;
        }
        labyrint[rad][kol].finn(null);
    }

    public Rute hentRute(int y, int x) {
        return labyrint[y][x];
    }

    @Override
    public String toString() {
        String returString = "";
        for (int i = 0; i < rader; i++) {
            for (int j = 0; j < kolonner; j++) {
                char representasjon = labyrint[i][j].tilTegn();
                returString += Character.toString(representasjon);
            }
            if (i < rader - 1) returString += "\n";
        }

        return returString;
    }
}
