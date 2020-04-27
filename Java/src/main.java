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
     * Nous avons 8 protocoles et chaque protocole a son traitement.
     * Il suffira de changer l'id du protocole pour avancer.
     * @param args the input arguments
     * @throws IOException the io exception
     */
    public static void main(String[] args) throws IOException {


        Matrice matrice = FactoryMatrice.getMatrice(1);
        matrice.lance();

    }


}
