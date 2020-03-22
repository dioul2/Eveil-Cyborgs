package matrice;

import signaux.ListSequence;
import signaux.Miroir;
import signaux.Signal;

import java.io.IOException;
import java.util.ArrayList;

public abstract class Matrice {
    protected Miroir[][] matrice = new Miroir[10][10];
    protected ArrayList<Miroir> listMiroir = new ArrayList<Miroir>();
    protected static final ArrayList<Signal> mesureEntree = new ArrayList<Signal>();
    protected ArrayList<Signal> mesureSortie = new ArrayList<Signal>();
    protected ArrayList<Signal> listSignauxEncourDeTraitement = new ArrayList<Signal>();
    protected ListSequence listSequence= new ListSequence(1);

    protected abstract void initialiseMatriceAvecMiroir(ArrayList<Miroir> listMiroir) throws IOException;
    public abstract void avancerSignal();


    // Affiche la mesure d'entrée
    public void afficheMesureEntre(){

        String mesureEntre = "";
        for (Signal signal: mesureEntree
        ) {
            String directionSignal = "";
            if (signal.getDirectionSignal()<0){
                directionSignal = "-";
            }else {
                directionSignal = "+";
            }
            String ordrelancement ="";
             if(signal.getOrdreLancement() > 0) {
                 ordrelancement = String.valueOf(signal.getOrdreLancement());
             }
            mesureEntre +="/"+signal.getNumEmetteurRecpteurSignal()+signal.getOrientationSignal()+directionSignal+ordrelancement;
        }
        String s = mesureEntre.substring(1);
        System.out.println("Mesure d'entrée: "+s);
    }

    // Affiche la mesure de sortie
    public void afficheMesureSortie(){
        //Collections.sort(mesureSortie);
        String mesureS = "";
        for (Signal signal: mesureSortie
        ) {
            signal.setNumEmetteurRecpteurSignal();
            String directionSignal = "";
            if (signal.getDirectionSignal()<0){
                directionSignal = "-";
            }else {
                directionSignal = "+";
            }

            String ordrelancement ="";
            if(signal.getOrdreLancement() > 0) {
                ordrelancement = String.valueOf(signal.getOrdreLancement());
            }
            mesureS += "/"+ signal.getNumEmetteurRecpteurSignal()+signal.getOrientationSignal()+directionSignal + ordrelancement;
        }
        String s = mesureS.substring(1);
        System.out.println("Mesure de sortie: "+s);
    }

    // Permet d'ajouter un miroir dans la matrice en fonction de sa position
    public void addMiroirDansMatrice(Miroir miroir){
        this.matrice[miroir.getPositionMiroir().getLigne()][miroir.getPositionMiroir().getColonne()] = miroir;
    }

    public Miroir[][] getMatrice(){
        return this.matrice;
    }

    public Miroir getMiroir(int ligne, int colonne){
        return getMatrice()[ligne][colonne];
    }

    // Affiche la matrice
    public void afficheMatrice(){
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                if(getMatrice()[i][j] == null){
                    System.out.print("|  "+0);
                }else{
                    if (this.getMiroir(i,j).getOrientationMiroir().length()>1){
                        System.out.print(" |"+this.getMiroir(i,j).getOrientationMiroir());
                    }else {
                        System.out.print("|  "+this.getMiroir(i,j).getOrientationMiroir());
                    }

                }
            }
            System.out.println("\n");
        }
    }

    // supprime tous les signaux de la mesureEntree et mesureSortie
    protected void nettoyer(){
        if (!mesureEntree.isEmpty()) {
            mesureEntree.removeAll(mesureEntree);
        }

        if (!mesureSortie.isEmpty()) {
            mesureSortie.removeAll(mesureSortie);
        }

        if (!listSignauxEncourDeTraitement.isEmpty()) {
            listSignauxEncourDeTraitement.removeAll(listSignauxEncourDeTraitement);
        }

        if (!listMiroir.isEmpty()){
            listMiroir.removeAll(listMiroir);
        }
    }

    // remplis la matrice des miroirs null
    protected void initialiserMatriceANull(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.matrice[i][j] = null;
            }
        }
    }

    // remplis la matrice d'une liste de miroir en en positionnant chaque miroir sur sur sa position dans la matrice
    protected void ajouteMiroirSurMatrice(ArrayList<Miroir> listMiroir){
        for (Miroir miroir: listMiroir
             ) {
            this.addMiroirDansMatrice(miroir);
        }

        /*for( Miroir miroir: listMiroir) {
            for (int i=0; i<10; i++){
                for( int j=0; j<10; j++){
                    if (i == miroir.getPositionMiroir().getLigne() && j == miroir.getPositionMiroir().getColonne()){
                        this.addMiroirDansMatriceAlpha(miroir);
                    }
                }
            }
        }*/
    }

    // Retournz la liste de la sequence pour nous permettre d'afficher la raisonnance de chaque sequence
    public ListSequence getListSequence(){
        return this.listSequence;

    }

    // Permet de convertir une sequence de type string en liste de signals
    public ArrayList<Signal> convertSequenceEnListSignaux(String sequence){
        ArrayList<Signal> listSignaux = new ArrayList<Signal>();
        Integer numEmetteurRecepteur, directionSignal, ordreLancement;
        String orientationSignal;
        String sequences[] = sequence.split("/");
        for (String s: sequences
        ) {
            ordreLancement = Integer.parseInt(String.valueOf(s.charAt(s.length()-1)));
            s = s.substring(0, s.length()-1);
            String numberOnly= s.replaceAll("[^0-9]", "");
            numEmetteurRecepteur = Integer.parseInt(numberOnly);
            if (s.charAt(s.length()-1) == '-'){
                directionSignal = -1;
            }else{
                directionSignal = 1;
            }
            if(numEmetteurRecepteur < 10){
                s = s.substring(1, s.length()-1);
            } else {
                s = s.substring(2, s.length()-1);
            }

            orientationSignal = s;
            listSignaux.add(new Signal(numEmetteurRecepteur,orientationSignal,directionSignal,ordreLancement));

        }
        return listSignaux;
    }

    protected Integer recupereMaxOrdreLancement( ArrayList<Signal> listSignal){
        Integer max = 0;
        for (Signal signal: listSignal
        ) {
            if (signal.getOrdreLancement() > max){
                max =signal.getOrdreLancement();
            }
        }
        return max;
    }

    public void lance(){
        System.out.println(" Affichage matrice protocole : ");
        this.afficheMatrice();
        this.avancerSignal();
        System.out.println(" Resultats: ");
        this.getListSequence().afficheResonnanceSequence();
        this.afficheMesureEntre();
        this.afficheMesureSortie();
    }


}
