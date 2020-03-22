package matrice;

import signaux.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class MatriceAlpha {
    private Miroir[][] matriceAlpha = new Miroir[10][10];
    private static final ArrayList<Signal> mesureEntree = new ArrayList<Signal>();
    private ArrayList<Signal> mesureSortie = new ArrayList<Signal>();
    private ArrayList<Signal> listSignauxEncourDeTraitement = new ArrayList<Signal>();
    private ListSequence listSequence= new ListSequence(1);


    public MatriceAlpha(Integer idProtocole) {
        ArrayList<Miroir> listMiroir = new ArrayList<Miroir>();
        if(idProtocole <= 1){
            this.initialiseMatriceAlphaProtocol1(listMiroir);
        } else if(idProtocole <= 2){
            this.initialiseMatriceAlphaProtocol2(listMiroir);
        } else {
            this.initialiseMatriceAlphaProtocol3(listMiroir);
        }



    }

     /*public MatriceAlpha() {
        ArrayList<Miroir> listMiroir = new ArrayList<Miroir>();

        Miroir miroir1 = new Miroir(1, this, new Position(0, 1), "SAT");
        Miroir miroir2 = new Miroir(2, this, new Position(0, 4), "SAD");
        Miroir miroir3 = new Miroir(3, this, new Position(1, 3), "SAT");
        Miroir miroir4 = new Miroir(4, this, new Position(1, 6), "SADA");
        Miroir miroir5 = new Miroir(5, this, new Position(2, 1), "A");
        Miroir miroir6 = new Miroir(6, this, new Position(3, 4), "SAT");
        Miroir miroir7 = new Miroir(7, this, new Position(4, 1), "SAT");
        Miroir miroir8 = new Miroir(8, this, new Position(4, 6), "SAT");
        Miroir miroir9 = new Miroir(9, this, new Position(5, 3), "N");
        Miroir miroir10 = new Miroir(10, this, new Position(5, 7), "SATA");
        Miroir miroir11 = new Miroir(11, this, new Position(7, 1), "SATN");
        Miroir miroir12 = new Miroir(12, this, new Position(7, 2), "SATN");
        Miroir miroir13 = new Miroir(13, this, new Position(7, 5), "N");

        this.nettoyer();

        listMiroir.add(miroir1);
        listMiroir.add(miroir2);
        listMiroir.add(miroir3);
        listMiroir.add(miroir4);
        listMiroir.add(miroir5);
        listMiroir.add(miroir6);
        listMiroir.add(miroir7);
        listMiroir.add(miroir8);
        listMiroir.add(miroir9);
        listMiroir.add(miroir10);
        listMiroir.add(miroir11);
        listMiroir.add(miroir12);
        listMiroir.add(miroir13);

        this.initialiserMatriceANull();

        this.ajouteMiroirSurMatrice(listMiroir);


        if (idMatrice >= 3) {
            Signal signal1 = new Signal(3, "A", -1, 1);
            Signal signal2 = new Signal(5, "SAD", 1,2);
            Signal signal3 = new Signal(7, "A", -1,1);
            Signal signal4 = new Signal(34, "SAD", 1,4);
            Signal signal5 = new Signal(35, "N", 1,2);
            Signal signal6 = new Signal(37, "N", 1,3);

            this.nettoyer();


            mesureEntree.add(signal1);
            mesureEntree.add(signal2);
            mesureEntree.add(signal3);
            mesureEntree.add(signal4);
            mesureEntree.add(signal5);
            mesureEntree.add(signal6);

            listSignauxEncourDeTraitement.add(new Signal(3, "A", -1,1));
            listSignauxEncourDeTraitement.add(new Signal(5, "SAD", 1,2));
            listSignauxEncourDeTraitement.add(new Signal(7, "A", -1,1));
            listSignauxEncourDeTraitement.add(new Signal(34, "SAD", 1,4));
            listSignauxEncourDeTraitement.add(new Signal(35, "N", 1,2));
            listSignauxEncourDeTraitement.add(new Signal(37, "N", 1,3));

        } else {

        Signal signal1 = new Signal(3, "A", -1);
        Signal signal2 = new Signal(5, "SAD", 1);
        Signal signal3 = new Signal(7, "A", -1);
        Signal signal4 = new Signal(34, "SAD", 1);
        Signal signal5 = new Signal(35, "N", 1);
        Signal signal6 = new Signal(37, "N", 1);

        this.nettoyer();

        mesureEntree.add(new Signal(3, "A", -1));
        mesureEntree.add(new Signal(5, "SAD", 1));
        mesureEntree.add(new Signal(7, "A", -1));
        mesureEntree.add(new Signal(34, "SAD", 1));
        mesureEntree.add(new Signal(35, "N", 1));
        mesureEntree.add(new Signal(37, "N", 1));

        listSignauxEncourDeTraitement.add(signal1);
        listSignauxEncourDeTraitement.add(signal2);
        listSignauxEncourDeTraitement.add(signal3);
        listSignauxEncourDeTraitement.add(signal4);
        listSignauxEncourDeTraitement.add(signal5);
        listSignauxEncourDeTraitement.add(signal6);

    }

    } */


    public Integer choixModuleSynchrone( ArrayList<Signal> listSignal){
        Integer max = 0;
        for (Signal signal: listSignal
             ) {
            if (signal.getOrdreLancement() > max){
               max =signal.getOrdreLancement();
            }
        }
        return max;
    }


    public void avancerSignal() {
        Integer i = 0;
        Integer j = 0;
        Integer idSeqence = 0;
        while (!listSignauxEncourDeTraitement.isEmpty()) {
            Sequence sequenceEnCours = new Sequence(++idSeqence);

            for (Signal signal : listSignauxEncourDeTraitement
            ) {
                i = signal.getPositionCaseSuivante().getLigne();
                j = signal.getPositionCaseSuivante().getColonne();


                while ((((i >= 0) && (i <= 9)) && ((j >= 0) && (j <= 9)))
                        && (this.getMatriceAlpha()[i][j] == null || this.getMatriceAlpha()[i][j].getOrientationMiroir().equals(signal.getOrientationSignal()))) {
                    switch (signal.getOrientationSignal()) {
                        case "A":
                            i = i - signal.getDirectionSignal();
                            break;

                        case "N":
                            j = j + signal.getDirectionSignal();

                            break;

                        case "SAT":
                            i = i - signal.getDirectionSignal();
                            j = j + signal.getDirectionSignal();

                            break;

                        case "SAD":
                            i = i + signal.getDirectionSignal();
                            j = j + signal.getDirectionSignal();
                            break;
                    }

                }

                if ((((i >= 0) && (i <= 9)) && ((j >= 0) && (j <= 9)))) {
                    sequenceEnCours.addMiroir(this.getMatriceAlpha()[i][j]);
                    signal.frappeMiroir(this.getMatriceAlpha()[i][j]);
                } else {
                    if ((i < 0) || (i > 9)) {
                        if (i < 0) {
                            i = 0;
                        } else {
                            i = 9;
                        }
                    }

                    if ((j < 0) || (j > 9)) {
                        if (j < 0) {
                            j = 0;
                        } else {
                            j = 9;
                        }
                    }
                    signal.setPositionSignal(new Position(i, j));
                    mesureSortie.add(signal);

                }
            }

            this.listSequence.addSequence(sequenceEnCours);

            for (Signal signal : mesureSortie
            ) {
                listSignauxEncourDeTraitement.remove(signal);

            }
        }
    }


    public void avancerSignalProtocol3(){
        Integer i = 0;
        Integer j = 0;
        Integer idSeqence = 0;
        Integer ordreSequence = 1;
        Integer maxOrdreSequence = choixModuleSynchrone(this.listSignauxEncourDeTraitement);
        Integer k = 1;

        while(! this.listSignauxEncourDeTraitement.isEmpty()){
            Sequence sequenceEnCours = new Sequence(++idSeqence);
            for (Signal signal: this.listSignauxEncourDeTraitement
                 ) {
                if(ordreSequence == signal.getOrdreLancement()){
                    i = signal.getPositionCaseSuivante().getLigne();
                    j = signal.getPositionCaseSuivante().getColonne();

                    while ((((i >= 0) && (i <= 9)) && ((j >= 0) && (j <= 9)))
                            && (this.getMatriceAlpha()[i][j] == null || this.getMatriceAlpha()[i][j].getOrientationMiroir().equals(signal.getOrientationSignal()))) {
                            switch (signal.getOrientationSignal()) {
                                case "A":
                                    i = i - signal.getDirectionSignal();
                                    break;

                                case "N":
                                    j = j + signal.getDirectionSignal();

                                    break;

                                case "SAT":
                                    i = i - signal.getDirectionSignal();
                                    j = j + signal.getDirectionSignal();

                                    break;

                                case "SAD":
                                    i = i + signal.getDirectionSignal();
                                    j = j + signal.getDirectionSignal();
                                    break;
                            }


                    }
                    if ((((i >= 0) && (i <= 9)) && ((j >= 0) && (j <= 9)))) {
                        sequenceEnCours.addMiroir(this.getMatriceAlpha()[i][j]);
                        signal.setOrdreLancement(ordreSequence);
                        this.getMatriceAlpha()[i][j].setEffetRaisonnance(false);
                        signal.frappeMiroir(this.getMatriceAlpha()[i][j]);
                    } else {
                        if ((i < 0) || (i > 9)) {
                            if (i < 0) {
                                i = 0;
                            } else {
                                i = 9;
                            }
                        }

                        if ((j < 0) || (j > 9)) {
                            if (j < 0) {
                                j = 0;
                            } else {
                                j = 9;
                            }
                        }
                        signal.setPositionSignal(new Position(i, j));
                        mesureSortie.add(signal);

                    }

                }
            }
            this.listSequence.addSequence(sequenceEnCours);

            for (Signal signal : mesureSortie
            ) {
                listSignauxEncourDeTraitement.remove(signal);

            }
            ordreSequence++;
            if( ordreSequence >= maxOrdreSequence){
                ordreSequence = maxOrdreSequence;
            }
            for (Signal signal: listSignauxEncourDeTraitement
                 ) {
                if(signal.getOrdreLancement() <= ordreSequence){
                    signal.setOrdreLancement(ordreSequence);
                }

            }
        k++;
        }
    k++;
    }

    public void avancerSignalProtocol4(){
        Integer i = 0;
        Integer j = 0;
        Integer idSeqence = 0;
        Integer ordreSequence = 1;
        Integer maxOrdreSequence = choixModuleSynchrone(this.listSignauxEncourDeTraitement);
        Integer k = 1;
        while( !this.listSignauxEncourDeTraitement.isEmpty()){
            Sequence sequenceEnCours = new Sequence(++idSeqence);
            for (Signal signal: this.listSignauxEncourDeTraitement
            ) {
                if(ordreSequence == signal.getOrdreLancement()){
                    i = signal.getPositionCaseSuivante().getLigne();
                    j = signal.getPositionCaseSuivante().getColonne();

                    while ( ((((i >= 0) && (i <= 9)) && ((j >= 0) && (j <= 9)))
                            && (this.getMatriceAlpha()[i][j] == null || this.getMatriceAlpha()[i][j].getOrientationMiroir().equals(signal.getOrientationSignal())) )
                            || ( (((i >= 0) && (i <= 9)) && ((j >= 0) && (j <= 9))) && ( (this.getMatriceAlpha()[i][j] != null)
                                                                                         && (!this.getMatriceAlpha()[i][j].getEffetRaisonnance()))) ){
                        switch (signal.getOrientationSignal()) {
                            case "A":
                                i = i - signal.getDirectionSignal();
                                break;

                            case "N":
                                j = j + signal.getDirectionSignal();

                                break;

                            case "SAT":
                                i = i - signal.getDirectionSignal();
                                j = j + signal.getDirectionSignal();

                                break;

                            case "SAD":
                                i = i + signal.getDirectionSignal();
                                j = j + signal.getDirectionSignal();
                                break;
                        }

                    }
                    if ((((i >= 0) && (i <= 9)) && ((j >= 0) && (j <= 9)))) {
                        sequenceEnCours.addMiroir(this.getMatriceAlpha()[i][j]);
                        signal.setOrdreLancement(ordreSequence);
                        signal.frappeMiroir(this.getMatriceAlpha()[i][j]);
                        this.getMatriceAlpha()[i][j].setEffetRaisonnance(false);
                    } else {
                        if ((i < 0) || (i > 9)) {
                            if (i < 0) {
                                i = 0;
                            } else {
                                i = 9;
                            }
                        }

                        if ((j < 0) || (j > 9)) {
                            if (j < 0) {
                                j = 0;
                            } else {
                                j = 9;
                            }
                        }
                        signal.setPositionSignal(new Position(i, j));
                        mesureSortie.add(signal);

                    }

                }
            }
            this.listSequence.addSequence(sequenceEnCours);

            for (Signal signal : mesureSortie
            ) {
                listSignauxEncourDeTraitement.remove(signal);

            }
            ordreSequence++;
            if( ordreSequence >= maxOrdreSequence){
                ordreSequence = maxOrdreSequence;
            }
            for (Signal signal: listSignauxEncourDeTraitement
            ) {
                if(signal.getOrdreLancement() <= ordreSequence){
                    signal.setOrdreLancement(ordreSequence);
                }

            }
            k++;
        }
        k++;
    }

    public ListSequence getListSequence(){
        return this.listSequence;

    }

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
            mesureEntre +="/"+signal.getNumEmetteurRecpteurSignal()+signal.getOrientationSignal()+directionSignal;
        }
        String s = mesureEntre.substring(1);
        System.out.println("Mesure d'entrée: "+s);
    }




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
            mesureS += "/"+ signal.getNumEmetteurRecpteurSignal()+signal.getOrientationSignal()+directionSignal;
        }
        String s = mesureS.substring(1);
        System.out.println("Mesure de sortie: "+s);
    }

    public Miroir[][] getMatriceAlpha(){
        return this.matriceAlpha;
    }


    public void addMiroirDansMatriceAlpha(Miroir miroir){
        this.matriceAlpha[miroir.getPositionMiroir().getLigne()][miroir.getPositionMiroir().getColonne()] = miroir;
    }
    public Miroir getMiroir(int ligne, int colonne){
        return getMatriceAlpha()[ligne][colonne];
    }

    public void afficheMatrice(){
       for (int i=0; i<9; i++){
           for (int j=0; j<9; j++){
               if(getMatriceAlpha()[i][j] == null){
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

    private void setPositionFinal(Integer i){
        if ((i < 0) || (i > 9)) {
            if (i < 0) {
                i = 0;
            } else {
                i = 9;
            }
        }
    }

    private void nettoyer(){
        if (!mesureEntree.isEmpty()) {
            mesureEntree.removeAll(mesureEntree);
        }

        if (!mesureSortie.isEmpty()) {
            mesureSortie.removeAll(mesureSortie);
        }

        if (!listSignauxEncourDeTraitement.isEmpty()) {
            listSignauxEncourDeTraitement.removeAll(listSignauxEncourDeTraitement);
        }
    }

    private void initialiserMatriceANull(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.matriceAlpha[i][j] = null;
            }
        }
    }

    private void ajouteMiroirSurMatrice(ArrayList<Miroir> listMiroir){
        for( Miroir miroir: listMiroir) {
            for (int i=0; i<10; i++){
                for( int j=0; j<10; j++){
                    if (i == miroir.getPositionMiroir().getLigne() && j == miroir.getPositionMiroir().getColonne()){
                        this.addMiroirDansMatriceAlpha(miroir);
                    }
                }
            }
        }
    }


    private void initialiseMatriceAlphaProtocol1(ArrayList<Miroir> listMiroir){
        if(!listMiroir.isEmpty()){
            listMiroir.removeAll(listMiroir);
        }
        Miroir miroir1 = new Miroir(1,this, new Position(0,1), "SAT");
        Miroir miroir2 = new Miroir(2,this, new Position(0,4), "SAD");
        Miroir miroir3 = new Miroir(3,this, new Position(1,3), "SAT");
        Miroir miroir4 = new Miroir(4,this, new Position(2,1), "A");
        Miroir miroir5 = new Miroir(5,this, new Position(3,4), "SAT");
        Miroir miroir6 = new Miroir(6,this, new Position(4,1), "SAT");

        listMiroir.add(miroir1);
        listMiroir.add(miroir2);
        listMiroir.add(miroir3);
        listMiroir.add(miroir4);
        listMiroir.add(miroir5);
        listMiroir.add(miroir6);

        this.initialiserMatriceANull();
        this.ajouteMiroirSurMatrice(listMiroir);

        /*for( Miroir miroir: listMiroir) {
            for (int i=0; i<10; i++){
                for( int j=0; j<10; j++){
                    if (i == miroir.getPositionMiroir().getLigne() && j == miroir.getPositionMiroir().getColonne()){
                        this.addMiroirDansMatriceAlpha(miroir);
                    }
                }
            }
        }*/

        Signal signal1 = new Signal(3,"A", -1);
        Signal signal2 = new Signal(35,"N", 1);
        Signal signal3 = new Signal(37,"N", 1);
        this.mesureEntree.add(signal1);
        this.mesureEntree.add(signal2);
        this.mesureEntree.add(signal3);

        this.listSignauxEncourDeTraitement.add(new Signal(3,"A", -1));
        this.listSignauxEncourDeTraitement.add(new Signal(35,"N", 1));
        this.listSignauxEncourDeTraitement.add(new Signal(37,"N", 1));
    }

    private void initialiseMatriceAlphaProtocol2(ArrayList<Miroir> listMiroir){
        if(!listMiroir.isEmpty()){
            listMiroir.removeAll(listMiroir);
        }
        Miroir miroir1 = new Miroir(1, this, new Position(0, 1), "SAT");
        Miroir miroir2 = new Miroir(2, this, new Position(0, 4), "SAD");
        Miroir miroir3 = new Miroir(3, this, new Position(1, 3), "SAT");
        Miroir miroir4 = new Miroir(4, this, new Position(1, 6), "SADA");
        Miroir miroir5 = new Miroir(5, this, new Position(2, 1), "A");
        Miroir miroir6 = new Miroir(6, this, new Position(3, 4), "SAT");
        Miroir miroir7 = new Miroir(7, this, new Position(4, 1), "SAT");
        Miroir miroir8 = new Miroir(8, this, new Position(4, 6), "SAT");
        Miroir miroir9 = new Miroir(9, this, new Position(5, 3), "N");
        Miroir miroir10 = new Miroir(10, this, new Position(5, 7), "SATA");
        Miroir miroir11 = new Miroir(11, this, new Position(7, 1), "SATN");
        Miroir miroir12 = new Miroir(12, this, new Position(7, 2), "SATN");
        Miroir miroir13 = new Miroir(13, this, new Position(7, 5), "N");

        this.nettoyer();

        listMiroir.add(miroir1);
        listMiroir.add(miroir2);
        listMiroir.add(miroir3);
        listMiroir.add(miroir4);
        listMiroir.add(miroir5);
        listMiroir.add(miroir6);
        listMiroir.add(miroir7);
        listMiroir.add(miroir8);
        listMiroir.add(miroir9);
        listMiroir.add(miroir10);
        listMiroir.add(miroir11);
        listMiroir.add(miroir12);
        listMiroir.add(miroir13);

        this.initialiserMatriceANull();

        this.ajouteMiroirSurMatrice(listMiroir);

        Signal signal1 = new Signal(3, "A", -1);
        Signal signal2 = new Signal(5, "SAD", 1);
        Signal signal3 = new Signal(7, "A", -1);
        Signal signal4 = new Signal(34, "SAD", 1);
        Signal signal5 = new Signal(35, "N", 1);
        Signal signal6 = new Signal(37, "N", 1);

        //this.nettoyer();

        mesureEntree.add(new Signal(3, "A", -1));
        mesureEntree.add(new Signal(5, "SAD", 1));
        mesureEntree.add(new Signal(7, "A", -1));
        mesureEntree.add(new Signal(34, "SAD", 1));
        mesureEntree.add(new Signal(35, "N", 1));
        mesureEntree.add(new Signal(37, "N", 1));

        listSignauxEncourDeTraitement.add(signal1);
        listSignauxEncourDeTraitement.add(signal2);
        listSignauxEncourDeTraitement.add(signal3);
        listSignauxEncourDeTraitement.add(signal4);
        listSignauxEncourDeTraitement.add(signal5);
        listSignauxEncourDeTraitement.add(signal6);

    }

    private void initialiseMatriceAlphaProtocol3(ArrayList<Miroir> listMiroir){
        if(!listMiroir.isEmpty()){
            listMiroir.removeAll(listMiroir);
        }
        Miroir miroir1 = new Miroir(1, this, new Position(0, 1), "SAT");
        Miroir miroir2 = new Miroir(2, this, new Position(0, 4), "SAD");
        Miroir miroir3 = new Miroir(3, this, new Position(1, 3), "SAT");
        Miroir miroir4 = new Miroir(4, this, new Position(1, 6), "SADA");
        Miroir miroir5 = new Miroir(5, this, new Position(2, 1), "A");
        Miroir miroir6 = new Miroir(6, this, new Position(3, 4), "SAT");
        Miroir miroir7 = new Miroir(7, this, new Position(4, 1), "SAT");
        Miroir miroir8 = new Miroir(8, this, new Position(4, 6), "SAT");
        Miroir miroir9 = new Miroir(9, this, new Position(5, 3), "N");
        Miroir miroir10 = new Miroir(10, this, new Position(5, 7), "SATA");
        Miroir miroir11 = new Miroir(11, this, new Position(7, 1), "SATN");
        Miroir miroir12 = new Miroir(12, this, new Position(7, 2), "SATN");
        Miroir miroir13 = new Miroir(13, this, new Position(7, 5), "N");

        this.nettoyer();

        listMiroir.add(miroir1);
        listMiroir.add(miroir2);
        listMiroir.add(miroir3);
        listMiroir.add(miroir4);
        listMiroir.add(miroir5);
        listMiroir.add(miroir6);
        listMiroir.add(miroir7);
        listMiroir.add(miroir8);
        listMiroir.add(miroir9);
        listMiroir.add(miroir10);
        listMiroir.add(miroir11);
        listMiroir.add(miroir12);
        listMiroir.add(miroir13);

        this.initialiserMatriceANull();

        this.ajouteMiroirSurMatrice(listMiroir);


        Signal signal1 = new Signal(3, "A", -1, 1);
        Signal signal2 = new Signal(5, "SAD", 1,2);
        Signal signal3 = new Signal(7, "A", -1,1);
        Signal signal4 = new Signal(34, "SAD", 1,4);
        Signal signal5 = new Signal(35, "N", 1,2);
        Signal signal6 = new Signal(37, "N", 1,3);

        this.nettoyer();


        mesureEntree.add(signal1);
        mesureEntree.add(signal2);
        mesureEntree.add(signal3);
        mesureEntree.add(signal4);
        mesureEntree.add(signal5);
        mesureEntree.add(signal6);

        listSignauxEncourDeTraitement.add(new Signal(3, "A", -1,1));
        listSignauxEncourDeTraitement.add(new Signal(5, "SAD", 1,2));
        listSignauxEncourDeTraitement.add(new Signal(7, "A", -1,1));
        listSignauxEncourDeTraitement.add(new Signal(34, "SAD", 1,4));
        listSignauxEncourDeTraitement.add(new Signal(35, "N", 1,2));
        listSignauxEncourDeTraitement.add(new Signal(37, "N", 1,3));


    }

    public MatriceAlpha (String sequence){
        ArrayList<Miroir> listMiroir = new ArrayList<Miroir>();
        this.initialiseMatriceAlphaProtocol4(listMiroir, sequence);


    }

    public MatriceAlpha (String miroirFile, String mesureFile) throws IOException {
        ArrayList<Miroir> listMiroir = new ArrayList<Miroir>();
        this.nettoyer();
        this.initialiseMatriceOmega(miroirFile, mesureFile, listMiroir);


    }

    private void initialiseMatriceAlphaProtocol4(ArrayList<Miroir> listMiroir, String sequence){
        if(!listMiroir.isEmpty()){
            listMiroir.removeAll(listMiroir);
        }
        Miroir miroir1 = new Miroir(1, this, new Position(0, 1), "SAT");
        Miroir miroir2 = new Miroir(2, this, new Position(0, 4), "SAD");
        Miroir miroir3 = new Miroir(3, this, new Position(1, 3), "SAT");
        Miroir miroir4 = new Miroir(4, this, new Position(1, 6), "SADA");
        Miroir miroir5 = new Miroir(5, this, new Position(2, 1), "A");
        Miroir miroir6 = new Miroir(6, this, new Position(3, 4), "SAT");
        Miroir miroir7 = new Miroir(7, this, new Position(4, 1), "SAT");
        Miroir miroir8 = new Miroir(8, this, new Position(4, 6), "SAT");
        Miroir miroir9 = new Miroir(9, this, new Position(5, 3), "N");
        Miroir miroir10 = new Miroir(10, this, new Position(5, 7), "SATA");
        Miroir miroir11 = new Miroir(11, this, new Position(7, 1), "SATN");
        Miroir miroir12 = new Miroir(12, this, new Position(7, 2), "SATN");
        Miroir miroir13 = new Miroir(13, this, new Position(7, 5), "N");

        this.nettoyer();

        listMiroir.add(miroir1);
        listMiroir.add(miroir2);
        listMiroir.add(miroir3);
        listMiroir.add(miroir4);
        listMiroir.add(miroir5);
        listMiroir.add(miroir6);
        listMiroir.add(miroir7);
        listMiroir.add(miroir8);
        listMiroir.add(miroir9);
        listMiroir.add(miroir10);
        listMiroir.add(miroir11);
        listMiroir.add(miroir12);
        listMiroir.add(miroir13);

        this.initialiserMatriceANull();

        this.ajouteMiroirSurMatrice(listMiroir);


       /* Signal signal1 = new Signal(3, "A", -1, 1);
        Signal signal2 = new Signal(7, "A", -1,1);
        Signal signal3 = new Signal(32, "N", 1,1);
        Signal signal4 = new Signal(5, "SAD", 1,2);
        Signal signal5 = new Signal(32, "N", 1,2);
        Signal signal6 = new Signal(35, "N", 1,2);
        Signal signal7 = new Signal(7, "A", -1,3);
        Signal signal8 = new Signal(37, "N", 1,3);
        Signal signal9 = new Signal(34, "SAD", 1,4);*/



        this.nettoyer();

        ArrayList<Signal> listSignal = this.convertSequenceEnListSignaux(sequence);
        for (Signal s: listSignal
             ) {
            mesureEntree.add(s);
            this.listSignauxEncourDeTraitement.add(new Signal(s.getNumEmetteurRecpteurSignal(), s.getOrientationSignal(), s.getDirectionSignal(), s.getOrdreLancement()));
        }

        /*mesureEntree.add(signal1);
        mesureEntree.add(signal2);
        mesureEntree.add(signal3);
        mesureEntree.add(signal4);
        mesureEntree.add(signal5);
        mesureEntree.add(signal6);
        mesureEntree.add(signal7);
        mesureEntree.add(signal8);
        mesureEntree.add(signal9);
        listSignauxEncourDeTraitement.add(new Signal(3, "A", -1, 1));
        listSignauxEncourDeTraitement.add(new Signal(7, "A", -1,1));
        listSignauxEncourDeTraitement.add(new Signal(32, "N", 1,1));
        listSignauxEncourDeTraitement.add(new Signal(5, "SAD", 1,2));
        listSignauxEncourDeTraitement.add(new Signal(32, "N", 1,2));
        listSignauxEncourDeTraitement.add(new Signal(35, "N", 1,2));
        listSignauxEncourDeTraitement.add(new Signal(7, "A", -1,3));
        listSignauxEncourDeTraitement.add(new Signal(37, "N", 1,3));
        listSignauxEncourDeTraitement.add(new Signal(34, "SAD", 1,4));*/

    }

    private void initialiseMatriceOmega(String miroirFile, String mesureFile,  ArrayList<Miroir> listMiroir) throws IOException {
        ArrayList<String> listStringMiroir = new ArrayList<String>();
        ArrayList<String> listStringSignaux = new ArrayList<String>();
        ArrayList<Signal> listSignal = new ArrayList<Signal>();

        listStringMiroir = this.recuperelistStringMiroir(miroirFile);
        listStringSignaux = this.recuperelistStringSignaux(mesureFile);

        listMiroir = this.convertListStringMiroirEnListMiroir(listStringMiroir);
        listSignal = this.convertSequenceEnListSignaux(listStringSignaux.get(0));

        this.initialiserMatriceANull();

        this.ajouteMiroirSurMatrice(listMiroir);

        for (Signal s: listSignal
        ) {
            mesureEntree.add(s);
            this.listSignauxEncourDeTraitement.add(new Signal(s.getNumEmetteurRecpteurSignal(), s.getOrientationSignal(), s.getDirectionSignal(), s.getOrdreLancement()));
        }

    }


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


    public ArrayList<String> recuperelistStringMiroir(String cheminFichier) throws IOException {
        ArrayList<String> listStringMiroir = new ArrayList<String>();
        BufferedReader bufferedReader = null;
        File file = new File(cheminFichier);

        bufferedReader = new BufferedReader(new FileReader(file));

        String miroir = null;

        while ((miroir = bufferedReader.readLine()) != null){
            listStringMiroir.add(miroir);
        }
        return listStringMiroir;
    }

    private ArrayList<String> recuperelistStringSignaux(String cheminFichier) throws IOException {
        ArrayList<String> listStringSignaux = new ArrayList<String>();
        BufferedReader bufferedReader = null;
        File file = new File(cheminFichier);

        bufferedReader = new BufferedReader(new FileReader(file));

        String miroir = null;

        while ((miroir = bufferedReader.readLine()) != null){
            listStringSignaux.add(miroir);
        }
        return listStringSignaux;

    }

    public ArrayList<Miroir> convertListStringMiroirEnListMiroir(ArrayList<String> listStringMiroir) {
        ArrayList<Miroir> listMiroir = new ArrayList<Miroir>();
        Integer i = 1;
        Miroir miroir = null;
        for (String s: listStringMiroir
             ) {
            miroir = this.convertStringEnMiroir(s);
            miroir.setIdMiroir(i);
            listMiroir.add(miroir);
        }
        return listMiroir;
    }

    private Miroir convertStringEnMiroir(String stringMiroir) {
        String orientation;
        String numberOnly= stringMiroir.replaceAll("[^0-9]", "");
        Integer colonne = Integer.parseInt(numberOnly.substring(0,2));
        Integer ligne = 39-Integer.parseInt(numberOnly.substring(2,4));
        stringMiroir = stringMiroir.substring(stringMiroir.length()-3, stringMiroir.length()-1);
        orientation = stringMiroir;
        return new Miroir( new Position(ligne,colonne), orientation);
    }


}
