package signaux;

/***
 * Cette classe permet de creer un position.
 * @author dioulde
 * @author victor
 * @author lucas
 */

public class Position {
    private Integer ligne;
    private Integer colonne;

    /**
     * Construit la position d'une case  de la matrice
     * @param ligne ligne de la matrice
     * @param colonne colonne de la matrice
     */
    public Position(Integer ligne, Integer colonne){
        this.ligne=ligne;
        this.colonne=colonne;
    }

    /**
     * Retourne  la ligne de la position
     * @return
     */
    public Integer getLigne() {
        return ligne;
    }

    /**
     * Permet de modifier la ligne de la position
     * @param ligne ligne
     */
    public void setLigne(Integer ligne) {
        this.ligne = ligne;
    }

    /**
     * Retourne la  colonne de la position
     * @return
     */
    public Integer getColonne() {
        return colonne;
    }

}
