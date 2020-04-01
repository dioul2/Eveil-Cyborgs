/**
 * Package qui contient toutes les classes matrices c'est à dire: FactoryMatrice, Matrice, MatriceA, MatriceOmega.
 */
package matrice;

import java.io.IOException;

/***
 * Factory qui permet de creer une matrice en fonction de l'id du protocole.
 * @author dioulde
 * @author victor
 * @author lucas
 */
public class FactoryMatrice {

    /**
     * Retourne la matrice créer en fonction de l'idProtocol.
     * @param idprotocole idProtocol.
     * @return retourne une matrice remplis avec ces miroirs....
     * @throws IOException Lance une exception lors de la lecture ou l'écriture des données  dans les fichiers
     * miroirFile.txt ou mesureFile.txt.
     */
    public static Matrice getMatrice(Integer idprotocole) throws IOException {
        Matrice matrice = null;
        if(idprotocole <= 4) {
            matrice = new MatriceA(idprotocole);
        } else {
            matrice = new MatriceOmega(idprotocole);
        }
        return matrice;
    }

}
