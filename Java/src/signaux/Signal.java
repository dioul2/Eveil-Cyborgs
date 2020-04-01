package signaux;

/***
 * Cette classe permet de creer un signal
 * @author dioulde
 * @author victor
 * @author lucas
 */

import java.util.ArrayList;

public class Signal implements Comparable<Signal> {
    /**
     * Numéro Em/Rec il se calcul en fonction de la position du signal
     */
    private Integer numEmetteurRecepteurSignal;

    /**
     * Orientation du signan qui peut etre: N, A, SAT, SATN, SATA, SAD, SADN, SADA
     */
    private String orientationSignal;

    /**
     * Direction du signal qui peut etre soit -1 ou 1
     */
    private Integer directionSignal;

    /**
     * Position du signal c'est à dire la postion de la case de la matrice dans laquelle se trouve le signal
     */
    private Position positionSignal;

    /**
     * Position suivante du signal au debut elle est egale à la position du signal et après à chaque que le signal va
     * frapper un miroir selon la nouvelle orientation du signal il va changer par exemple:
     * Si l'orientation signal est "A+"  la position de la case suivante va etre: x = x - direction, y ne chage pas.
     * Si l'orientation signal est "A-"  la position de la case suivante va etre: x = x + direction, y ne chage pas.
     * Si l'orientation signal est "N+"  la position de la case suivante va etre: y = y+direction, x ne chage pas.
     * Si l'orientation signal est "N-"  la position de la case suivante va etre: y = y-direction, x ne chage pas.
     */
    private Position positionCaseSuivante;

    /**
     * Ordre de lancement du signal c'es lui qui determine l'ordre de lancement du signal c'est à dire à quelle moment
     * il faut lancé tel signal.
     */
    private Integer ordreLancement;

    /**
     *Construit un signal sans preciser son ordre de lancement
     * @param numEmetteurRecepteurSignal numéro de l'émetteur/recepteur du signal il nous permet de calculer la
     * position du signal par exemple: si numEmRec <= 9 alors ligne = 0, colonne = numEmRec,
     *                                   sinon si numEmRec <= 19 alors ligne = numEmRec-10, colonne = 9
     *                                   sinon si numEmRec <= 29 alors ligne = 9, colonne = 29 - numEmRec
     *                                   sinon  ligne = 39 - numEmRec, colonne = 0.
     *
     * @param orientationSignal Orientation du signal
     * @param directionSignal Direction du signal qui peut etre soit -1 ou 1.
     */
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

    /**
     *Construit un signal sans preciser en précisant l'ordre de lancement.
     * @param numEmetteurRecepteurSignal numéro de l'émetteur/recepteur du signal il nous permet de calculer la
     * position du signal par exemple: si numEmRec <= 9 alors ligne = 0, colonne = numEmRec.
     *                                   sinon si numEmRec <= 19 alors ligne = numEmRec-10, colonne = 9
     *                                   sinon si numEmRec <= 29 alors ligne = 9, colonne = 29 - numEmRec
     *                                   sinon  ligne = 39 - numEmRec, colonne = 0.
     *
     * @param orientationSignal Orientation du signal
     * @param directionSignal Direction du signal qui peut etre soit -1 ou 1.
     * @param ordreLancement Determine l'ordre de lancement du signal
     */
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

    /**
     * Permet de retourner l'ordre de lancement du signal c'est à dire à quelle sequence le signal sera lancé
     */
    public Integer getOrdreLancement(){ return this.ordreLancement;}

    /**
     * Permet de modifier l'ordre de lancement du signal c'est à dire à quelle sequence le signal sera lancé
     * @param ordreLancement ordre de lancement du signal
     */
    public void setOrdreLancement(Integer ordreLancement){this.ordreLancement = ordreLancement;}

    /**
     * Retourne le numero de Em/Rec du signal en cours en fonction de la position du signal
     */
    public Integer getNumEmetteurRecpteurSignal() {
        return numEmetteurRecepteurSignal;
    }

    /**
     * Permet de modifier le numero de Em/Rec  du signal en cours en fonction de la position du signal.
     * pour un signal "N-" numEmRec = 39 - ligne.
     * pour un signal "N+" numEmRec = 10 + ligne.
     * pour un signal "A-" numEmRec = 29 - colonne.
     * pour un signal "A+" numEmRec = colonne.
     */
    public void setNumEmetteurRecpteurSignal() {
        if(this.getOrientationSignal().equals("N")){
            if(this.getDirectionSignal() < 0){
                this.numEmetteurRecepteurSignal = 39 - this.getPositionSignal().getLigne();
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
    }

    /**
     * Retourne l'orientation du signal.
     * @return un string qui reprensente l'orientation du signal.
     */
    public String getOrientationSignal() {
        return orientationSignal;
    }

    /**
     * Modifie l'orientation  du signal
     * @param orientationSignal nouvelle orientation du signal
     */
    public void setOrientationSignal(String orientationSignal) {
        this.orientationSignal = orientationSignal;
    }

    /**
     * Retourne la position de la case suivante
     * @return
     */
    public Position getPositionCaseSuivante(){
        return this.positionCaseSuivante;
    }

    /**
     * Modifie la position de la case suivante selon l'orientation du signal mais aussi de sa position
     */
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
                    j = 0;
                } else if((j + this.getDirectionSignal()) <= 9){
                    j = j + this.getDirectionSignal();
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
                    j = 0;
                } else if((j + this.getDirectionSignal()) <= 9){
                    j = j + this.getDirectionSignal();
                } else {
                    j = 9;
                }
                break;
        }

        this.positionCaseSuivante = new Position(i, j);

    }

    /**
     * Permet de retourner la direction du signal.
     * @return
     */
    public Integer getDirectionSignal() {
        return directionSignal;
    }

    /**
     * Permet de modifier la direction du signal
     */
    public void setDirectionSignal() {
        this.directionSignal *= -1;
    }

    /**
     * Permet de retourner la position du signal.
     * @return
     */
    public Position getPositionSignal(){
        return this.positionSignal;
    }

    /**
     * Permet de modifier la posiotion du signal
     * @param position nouvelle position du signal
     */
    public void setPositionSignal(Position position){
        this.positionSignal = position;
    }

    /**
     * Permet de frapper le miroir rencontrer c'est à dire prendre sa posittion et changer d'orientation selon la position
     * et l'orientation du miroir et ensuite calculer la positionSuivante du signal.
     * @param miroir miroir frappé par le signal.
     */
   public void frappeMiroir(Miroir miroir){

        this.setPositionSignal(miroir.getPositionMiroir());
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

    /**
     * Permet de frapper un Em/Rec lorsque le signal qui le frappe doit etre rejeté.
     * @param miroir Em/Rec considerer comme miroir.
     */
    public void frappeEmetteurRecepteur(Miroir miroir){

        this.setPositionSignal(miroir.getPositionMiroir());
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

    /**
     * Permet de determiner si signal reçu par l'Em/Rec doit etre rejeter ou pas.
     * @return
     */
   public boolean rejeteSignal() {
        boolean resultat = true;
        String direction ="";
        if(this.getDirectionSignal() < 0) {
            direction ="-";
        } else {
            direction = "+";
        }
        String signal = this.orientationSignal+ direction;
       ArrayList<String> signauxDeSortiePossibleList0_9 = new ArrayList<>();
       ArrayList<String> signauxDeSortiePossibleList10_19 = new ArrayList<>();
       ArrayList<String> signauxDeSortiePossibleList20_29 = new ArrayList<>();
       ArrayList<String> signauxDeSortiePossibleList30_39 = new ArrayList<>();
       signauxDeSortiePossibleList0_9.add("A+");
       signauxDeSortiePossibleList0_9.add("SAT+");
       signauxDeSortiePossibleList0_9.add("SAD-");

       signauxDeSortiePossibleList10_19.add("N+");
       signauxDeSortiePossibleList10_19.add("SAT+");
       signauxDeSortiePossibleList10_19.add("SAD+");

       signauxDeSortiePossibleList20_29.add("A-");
       signauxDeSortiePossibleList20_29.add("SAT-");
       signauxDeSortiePossibleList20_29.add("SAD+");

       signauxDeSortiePossibleList30_39.add("N-");
       signauxDeSortiePossibleList30_39.add("SAT-");
       signauxDeSortiePossibleList30_39.add("SAD-");

       if (this.getNumEmetteurRecpteurSignal() <= 9) {
           resultat = !signauxDeSortiePossibleList0_9.contains(signal);
       } else if(this.getNumEmetteurRecpteurSignal() <= 19) {
           resultat = !signauxDeSortiePossibleList10_19.contains(signal);
       } else if(this.getNumEmetteurRecpteurSignal() <= 29) {
           resultat = !signauxDeSortiePossibleList20_29.contains(signal);
       } else {
           resultat = !signauxDeSortiePossibleList30_39.contains(signal);
       }
       return resultat;
   }

    @Override
    public int compareTo(Signal comparesignal) {
        return (this.numEmetteurRecepteurSignal - comparesignal.getNumEmetteurRecpteurSignal());
    }
}
