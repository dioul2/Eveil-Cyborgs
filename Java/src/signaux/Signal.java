package signaux;

import matrice.Matrice;

public class Signal implements Comparable<Signal> {
    private Integer numEmetteurRecepteurSignal;
    private String orientationSignal;
    private Integer directionSignal;
    private Position positionSignal;
    private Position positionCaseSuivante;
    private Boolean afrapperMiror = false;
    private Integer ordreLancement;



    public Signal(Integer numEmetteurRecepteurSignal, String orientationSignal, Integer directionSignal){
        this.numEmetteurRecepteurSignal = numEmetteurRecepteurSignal;
        this.orientationSignal = orientationSignal;
        this.directionSignal = directionSignal;
        this.ordreLancement = 0;

        if (numEmetteurRecepteurSignal <= 9){
            this.positionSignal = new Position(0, numEmetteurRecepteurSignal);
        } else if(numEmetteurRecepteurSignal <= 19){
            this.positionSignal = new Position((numEmetteurRecepteurSignal-10), 9);
        } else if(numEmetteurRecepteurSignal <= 29){
            this.positionSignal = new Position(9,(29-numEmetteurRecepteurSignal));
        } else {
            this.positionSignal = new Position((39-numEmetteurRecepteurSignal), 0);
        }

        this.positionCaseSuivante = this.positionSignal;
    }

    public Signal(Integer numEmetteurRecepteurSignal, String orientationSignal, Integer directionSignal, Integer ordreLancement){
        this.numEmetteurRecepteurSignal = numEmetteurRecepteurSignal;
        this.orientationSignal = orientationSignal;
        this.directionSignal = directionSignal;
        this.ordreLancement = ordreLancement;

        if (numEmetteurRecepteurSignal <= 9){
            this.positionSignal = new Position(0, numEmetteurRecepteurSignal);
        } else if(numEmetteurRecepteurSignal <= 19){
            this.positionSignal = new Position((numEmetteurRecepteurSignal-10), 9);
        } else if(numEmetteurRecepteurSignal <= 29){
            this.positionSignal = new Position(9,(29-numEmetteurRecepteurSignal));
        } else {
            this.positionSignal = new Position((39-numEmetteurRecepteurSignal), 0);
        }

        this.positionCaseSuivante = this.positionSignal;
    }

    public Integer getOrdreLancement(){ return this.ordreLancement;}
    public void setOrdreLancement(Integer ordreLancement){this.ordreLancement = ordreLancement;}
    public void deplacerSignal(Miroir miroir){
        this.positionSignal = miroir.getPositionMiroir();
    }
    public void setAfrapperMiror(Boolean b){
        this.afrapperMiror = b;
    }

    public Boolean getAfrapperMiror(){
        return this.afrapperMiror;
    }

    public Integer getNumEmetteurRecpteurSignal() {
        return numEmetteurRecepteurSignal;
    }

    public void setNumEmetteurRecpteurSignal() {
        if(this.getOrientationSignal().equals("N")){
            if(this.getDirectionSignal() < 0){
                this.numEmetteurRecepteurSignal = 30 - this.getPositionSignal().getLigne();
            }else {
                this.numEmetteurRecepteurSignal = 10 + this.getPositionSignal().getLigne();
            }
        }

        if(this.getOrientationSignal().equals("A")){
            if(this.getDirectionSignal() < 0){
                this.numEmetteurRecepteurSignal = 29 - this.getPositionSignal().getColonne();
            }else {
                this.numEmetteurRecepteurSignal = this.getPositionSignal().getColonne();
            }
        }

        if(this.getPositionSignal().getLigne() == 9){
            if (this.getOrientationSignal().equals("N")){
                if(this.getDirectionSignal() < 0){
                    this.numEmetteurRecepteurSignal = 30;
                } else {
                    this.numEmetteurRecepteurSignal = 19;
                }
            }
            this.numEmetteurRecepteurSignal = 29-this.getPositionSignal().getColonne();
        }

        if(this.getPositionSignal().getColonne() == 0){
            if(this.getOrientationSignal().equals("A")){
                if (this.getDirectionSignal() < 0){
                    this.numEmetteurRecepteurSignal = 0;
                } else {
                    this.numEmetteurRecepteurSignal = 29;
                }
            }
            this.numEmetteurRecepteurSignal = 39-this.getPositionSignal().getLigne();
        }
        if(this.getPositionSignal().getColonne() == 9){
            this.numEmetteurRecepteurSignal = this.getPositionSignal().getLigne()-10;
        }
    }

    public String getOrientationSignal() {
        return orientationSignal;
    }

    public void setOrientationSignal(String orientationSignal) {
        this.orientationSignal = orientationSignal;
    }

    public Position getPositionCaseSuivante(){
        return this.positionCaseSuivante;
    }

    public void setPositionCaseSuivante(){
        Integer i = this.getPositionSignal().getLigne();
        Integer j = this.getPositionSignal().getColonne();
        switch (this.getOrientationSignal()){
            case "N":
                if ((j + this.getDirectionSignal()) < 0){
                    j = 0;
                } else if((j + this.getDirectionSignal()) <= 9){
                    j = j + this.getDirectionSignal();
                } else {
                    j = 9;
                }
                i = this.getPositionSignal().getLigne();
                break;

            case "A":
                if ((i - this.getDirectionSignal()) < 0){
                    i = 0;
                } else if((i - this.getDirectionSignal()) <= 9){
                    i = i - this.getDirectionSignal();
                } else {
                    i = 9;
                }
                j = this.getPositionSignal().getColonne();
                break;

            case "SAT":
                if ((i - this.getDirectionSignal()) < 0){
                    i = 0;
                } else if((i - this.getDirectionSignal()) <= 9){
                    i = i - this.getDirectionSignal();
                } else {
                    i = 9;
                }

                if ((j + this.getDirectionSignal()) < 0){
                    i = 0;
                } else if((j + this.getDirectionSignal()) <= 9){
                    j = i + this.getDirectionSignal();
                } else {
                    j = 9;
                }
                break;

            case "SAD":
                if ((i + this.getDirectionSignal()) < 0){
                    i = 0;
                } else if((i + this.getDirectionSignal()) <= 9){
                    i = i + this.getDirectionSignal();
                } else {
                    i = 9;
                }

                if ((j + this.getDirectionSignal()) < 0){
                    i = 0;
                } else if((j + this.getDirectionSignal()) <= 9){
                    j = i + this.getDirectionSignal();
                } else {
                    j = 9;
                }
                break;
        }

        this.positionCaseSuivante = new Position(i, j);

    }

    public Integer getDirectionSignal() {
        return directionSignal;
    }

    public void setDirectionSignal() {
        this.directionSignal *= -1;
    }

    public Position getPositionSignal(){
        return this.positionSignal;
    }

    public void setPositionSignal(Position position){
        this.positionSignal = position;
    }

   public void frappeMiroir(Miroir miroir){

        this.setPositionSignal(miroir.getPositionMiroir());
                // 8 orientations possibles des miroirs A,N,SAT,SAD, SATA, SATN, SADA, SADN
                switch (this.getOrientationSignal()){
                    case "N":
                        if (miroir.getOrientationMiroir().equals("A")){
                            this.setDirectionSignal();

                            this.positionCaseSuivante.setLigne(this.getPositionSignal().getLigne() + this.getDirectionSignal());
                        }

                        if(miroir.getOrientationMiroir().equals("SAT") ){
                            this.setOrientationSignal("A");

                        }

                        if (miroir.getOrientationMiroir().equals("SAD")){
                        this.setOrientationSignal("A");
                        this.setDirectionSignal();

                        }

                        if(this.getOrientationSignal().equals("SATA")){
                            this.setOrientationSignal("SAD");
                            this.setDirectionSignal();
                        }

                        if(this.getOrientationSignal().equals("SADA")){
                            this.setOrientationSignal("SAT");
                            this.setDirectionSignal();
                        }

                        if(this.getOrientationSignal().equals("SATN")){
                            this.setOrientationSignal("SAT");
                        }
                        if (this.getOrientationSignal().equals("SADN")){
                            this.setOrientationSignal("SAD");
                        }


                    break;

                    case "A" :
                        if(miroir.getOrientationMiroir().equals("N")){
                            this.setDirectionSignal();
                        }

                        if(miroir.getOrientationMiroir().equals("SAT")){
                            this.setOrientationSignal("N");
                        }

                        if(miroir.getOrientationMiroir().equals("SAD")){
                            this.setOrientationSignal("N");
                            this.setDirectionSignal();
                        }

                        if(miroir.getOrientationMiroir().equals("SATA")){
                            this.setOrientationSignal("SAT");
                        }

                        if (miroir.getOrientationMiroir().equals("SADA")){
                            this.setOrientationSignal("SAD");
                            this.setDirectionSignal();
                        }

                        if(miroir.getOrientationMiroir().equals("SATN")){
                            this.setOrientationSignal("SAD");
                        }

                        if(miroir.getOrientationMiroir().equals("SADN")){
                            this.setOrientationSignal("SATA");
                            this.setDirectionSignal();
                        }


                        break;

                    case "SAT":
                        if(miroir.getOrientationMiroir().equals("N")){
                            this.setOrientationSignal("SAD");
                        }

                        if (miroir.getOrientationMiroir().equals("A")){
                            this.setOrientationSignal("SAD");
                            this.setDirectionSignal();
                        }

                        if(miroir.getOrientationMiroir().equals("SAD")){
                            this.setOrientationSignal("SAT");
                            this.setDirectionSignal();
                        }

                        if(miroir.getOrientationMiroir().equals("SATA")){
                            this.setOrientationSignal("A");
                        }

                        if(miroir.getOrientationMiroir().equals("SADA")){
                            this.setOrientationSignal("N");
                            this.setDirectionSignal();
                        }

                        if(miroir.getOrientationMiroir().equals("SATN")){
                            this.setOrientationSignal("N");
                        }

                        if (miroir.getOrientationMiroir().equals("SADN")){
                            this.setOrientationSignal("A");
                            this.setDirectionSignal();
                        }
                        break;
                    case "SAD":

                        if(miroir.getOrientationMiroir().equals("N")){
                            this.setOrientationSignal("SAT");
                        }

                        if(miroir.getOrientationMiroir().equals("A")){
                            this.setOrientationSignal("SAT");
                            this.setDirectionSignal();
                        }

                        if(miroir.getOrientationMiroir().equals("SAT")){
                            this.setDirectionSignal();
                        }

                        if (miroir.getOrientationMiroir().equals("SATA")){
                            this.setOrientationSignal("N");
                            this.setDirectionSignal();

                        }

                        if(miroir.getOrientationMiroir().equals("SADA")){
                            this.setOrientationSignal("A");
                            this.setDirectionSignal();
                        }

                        if (miroir.getOrientationMiroir().equals("SATN")){
                            this.setOrientationSignal("SAT");
                            this.setDirectionSignal();

                        }

                        if (miroir.getOrientationMiroir().equals("SADN")){
                            this.setOrientationSignal("N");
                            this.setDirectionSignal();
                        }
                        break;
                }

                this.setPositionCaseSuivante();


   }

    @Override
    public int compareTo(Signal comparesignal) {
        int comparenumEmtteurRecepteur = ((Signal) comparesignal).getNumEmetteurRecpteurSignal();
        return (this.numEmetteurRecepteurSignal - comparenumEmtteurRecepteur);
    }
}
