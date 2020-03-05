package signaux;

import matrice.Matrice;

public class Signal {
    private Integer numEmetteurRecepteurSignal;
    private String orientationSignal;
    private Integer directionSignal;
    private Position positionSignal;



    public Signal(Integer numEmetteurRecepteurSignal, String orientationSignal, Integer directionSignal){
        this.numEmetteurRecepteurSignal = numEmetteurRecepteurSignal;
        this.orientationSignal = orientationSignal;
        this.directionSignal = directionSignal;

        if (numEmetteurRecepteurSignal <= 9){
            this.positionSignal = new Position(0, numEmetteurRecepteurSignal);
        } else if(numEmetteurRecepteurSignal <= 19){
            this.positionSignal = new Position((numEmetteurRecepteurSignal-10), 9);
        } else if(numEmetteurRecepteurSignal <= 29){
            this.positionSignal = new Position(9,(29-numEmetteurRecepteurSignal));
        } else {
            this.positionSignal = new Position((39-numEmetteurRecepteurSignal), 0);
        }
    }

    public void deplacerSignal(Miroir miroir){
        this.positionSignal = miroir.getPositionMiroir();
    }

    public Integer getNumEmetteurRecpteurSignal() {
        return numEmetteurRecepteurSignal;
    }

    public void setNumEmetteurRecpteurSignal() {
        if (this.getPositionSignal().getLigne() == 0){
            this.numEmetteurRecepteurSignal = this.positionSignal.getColonne();
        }

        if(this.getPositionSignal().getLigne() == 9){
            this.numEmetteurRecepteurSignal = 29-this.getPositionSignal().getColonne();
        }

        if(this.getPositionSignal().getColonne() == 0){
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
        if(miroir.getOrientationMiroir() != this.getOrientationSignal()){
                // 8 orientations possibles des miroirs A,N,SAT,SAD, SATA, SATN, SADA, SADN
                switch (this.getOrientationSignal()){
                    case "N":
                        if (miroir.getOrientationMiroir().equals("A")){
                            this.setDirectionSignal();
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

                        }


                        break;

                    case "SAT":
                        break;
                    case "SAD":
                        break;
                    case "SATA":
                        break;

                    case "SATN":
                        break;

                    case "SADA":
                }



        }
   }
}
