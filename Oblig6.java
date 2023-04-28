import java.util.Scanner;
import java.io.FileNotFoundException;

public class Oblig6 {

    public static void main(String[] args) throws FileNotFoundException {
        String mappe = "labyrinter/";
        String filnavn = args[0];
        Labyrint labyrint = new Labyrint(mappe+filnavn);

        System.out.println(labyrint);
        Scanner sc = new Scanner(System.in);
        boolean gaa = true;

        while(gaa){
            System.out.println("Skriv inn labyrintens koordinater <rad> <kolonne> ('-1' for aa avslutte).");
            String valg = sc.nextLine();

            switch (valg){
              case "-1":
                   gaa = false;
                   break;
               default:
                   String[] koordinater = valg.split(" ");
                   System.out.println("Aapninger:\n");
                   labyrint.finnUtveiFra(Integer.parseInt(koordinater[0]), Integer.parseInt(koordinater[1]));
                   break;
            }
        }
    }
}
