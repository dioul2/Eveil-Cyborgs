package matrice;

import signaux.Miroir;
import signaux.Position;
import signaux.Sequence;
import signaux.Signal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MatriceOmega extends Matrice{

    public MatriceOmega() throws IOException {
        this.initialiseMatriceAvecMiroir(this.listMiroir);

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



    @Override
    protected void initialiseMatriceAvecMiroir(ArrayList<Miroir> listMiroir) throws IOException {
        String miroirFile = "/home/dioulde/IdeaProjects/Eveil-Cyborgs/Java/fichiertxt/omega_miroir.txt";
        String mesureFile = "/home/dioulde/IdeaProjects/Eveil-Cyborgs/Java/fichiertxt/omega_mesure.txt";
        this.initialiseMatriceOmega(miroirFile,mesureFile, this.listMiroir);
    }

    @Override
    public void avancerSignal() {

        Integer i = 0;
        Integer j = 0;
        Integer idSeqence = 0;
        Integer ordreSequence = 1;
        Integer maxOrdreSequence = this.recupereMaxOrdreLancement(this.listSignauxEncourDeTraitement);
        Integer k = 1;
        while( !this.listSignauxEncourDeTraitement.isEmpty()){
            Sequence sequenceEnCours = new Sequence(++idSeqence);
            for (Signal signal: this.listSignauxEncourDeTraitement
            ) {
                if(ordreSequence == signal.getOrdreLancement()){
                    i = signal.getPositionCaseSuivante().getLigne();
                    j = signal.getPositionCaseSuivante().getColonne();

                    while ( ((((i >= 0) && (i <= 9)) && ((j >= 0) && (j <= 9)))
                            && (this.getMatrice()[i][j] == null || this.getMatrice()[i][j].getOrientationMiroir().equals(signal.getOrientationSignal())) )
                            || ( (((i >= 0) && (i <= 9)) && ((j >= 0) && (j <= 9))) && ( (this.getMatrice()[i][j] != null)
                            && (!this.getMatrice()[i][j].getEffetRaisonnance()))) ){
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
                        sequenceEnCours.addMiroir(this.getMatrice()[i][j]);
                        signal.setOrdreLancement(ordreSequence);
                        signal.frappeMiroir(this.getMatrice()[i][j]);
                        this.getMatrice()[i][j].setEffetRaisonnance(false);
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
        }
    }
}
