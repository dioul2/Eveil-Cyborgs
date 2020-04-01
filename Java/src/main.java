import matrice.*;
import signaux.Signal;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * The type Main.
 */
public class main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws IOException the io exception
     */
    public static void main(String[] args) throws IOException {

        String sequence = "3A-1/7A-1/32N+1/5SAD+2/32N+2/35N+2/7A-3/37N+3/34SAD+4";
        String miroirFile = "/home/dioulde/IdeaProjects/Eveil-Cyborgs/Java/src/omega_miroir.txt";
        String mesureFile = "/home/dioulde/IdeaProjects/Eveil-Cyborgs/Java/src/omega_mesure.txt";

        Matrice matrice = FactoryMatrice.getMatrice(6);
        matrice.lance();

        /*ArrayList<String> signauxDeSortiePossibleList0_9 = new ArrayList<>();
        signauxDeSortiePossibleList0_9.add("A+");
        signauxDeSortiePossibleList0_9.add("SAT+");
        signauxDeSortiePossibleList0_9.add("SAD-");
        System.out.println(signauxDeSortiePossibleList0_9.contains("A+"));*/




    }


}
