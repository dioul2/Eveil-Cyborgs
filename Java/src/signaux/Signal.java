package signaux;

import matrice.Matrice;

public class Signal {
    private Integer idSignal;
    private Integer emrcSignal;
    private Integer directionSignal;
    private Integer sensSignal;
    private Position positionSignal;

    public Signal(Integer idSignal, Integer emrcSignal, Integer directionSignal, Integer sensSignal) {
        this.idSignal = idSignal;
        this.emrcSignal = emrcSignal;
        this.directionSignal = directionSignal;
        this.sensSignal = sensSignal;
    }

    public Integer getIdSignal() {
        return idSignal;
    }

    public void setIdSignal(Integer idSignal) {
        this.idSignal = idSignal;
    }

    public Integer getEmrcSignal() {
        return emrcSignal;
    }

    public void setEmrcSignal(Integer emrcSignal) {
        this.emrcSignal = emrcSignal;
    }

    public Integer getDirectionSignal() {
        return directionSignal;
    }

    public void setDirectionSignal(Integer directionSignal) {
        this.directionSignal = directionSignal;
    }

    public Integer getSensSignal() {
        return sensSignal;
    }

    public void setSensSignal(Integer sensSignal) {
        this.sensSignal = sensSignal;
    }

    public Position getPositionSignal() {
        return positionSignal;
    }

    public void setPositionSignal(Position positionSignal) {
        this.positionSignal = positionSignal;
    }

    public void initialisePositionSiginal(Integer emrc) {

        if(emrc <= 9) {
            this.positionSignal.setLigne(0);
            this.positionSignal.setColonne(emrc);
        } else if(emrc <= 19){
            this.positionSignal.setLigne(emrc-10);
            this.positionSignal.setColonne(9);
        } else if(emrc <= 29){
            this.positionSignal.setLigne(9);
            this.positionSignal.setColonne(29-emrc);
        } else {
            this.positionSignal.setLigne(39-emrc);
            this.positionSignal.setColonne(0);
        }
    }

    public void avancerSignal(Signal signal, Matrice matrice){
        while( matrice.getMatrice()[signal.positionSignal.getLigne()][signal.positionSignal.getColonne()] == 0
                && this.positionSignal.getLigne() >= 0
                && this.positionSignal.getColonne() >= 0
                && this.positionSignal.getLigne() <= 9
                && this.positionSignal.getColonne() <=9){


        }

    }
}
