package matrice;

import java.io.IOException;

public class FactoryMatrice {
    public static Matrice getMatrice(Integer idprotocole) throws IOException {
        Matrice matrice = null;
        if(idprotocole <= 4) {
            matrice = new MatriceA(idprotocole);
        } else {
            matrice = new MatriceOmega();
        }
        return matrice;
    }

}
