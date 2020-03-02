package signaux;

public class Position {
    private Integer ligne;
    private Integer colonne;

    public Position(Integer ligne, Integer colonne){
        this.ligne=ligne;
        this.colonne=colonne;
    }

    public Integer getLigne() {
        return ligne;
    }

    public void setLigne(Integer ligne) {
        this.ligne = ligne;
    }

    public Integer getColonne() {
        return colonne;
    }

    public void setColonne(Integer colonne) {
        this.colonne = colonne;
    }
}
