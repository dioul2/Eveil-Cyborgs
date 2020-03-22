package matrice;

import signaux.Miroir;
import signaux.Position;
import signaux.Sequence;
import signaux.Signal;

import java.util.ArrayList;

public class MatriceA extends Matrice {
    Integer idProtocol;

    public MatriceA(Integer idprotocol) {
        this.setIdProtocol(idprotocol);
        this.initialiseMatriceAvecMiroir(this.listMiroir);
    }



    private Integer getIdProtocol() {
        return idProtocol;
    }

    private void setIdProtocol(Integer idProtocol) {
        this.idProtocol = idProtocol;
    }

    public void initialiseMatriceAlphaProtocol1(ArrayList<Miroir> listMiroir) {
        this.nettoyer();

        Miroir miroir1 = new Miroir(new Position(0,1), "SAT");
        Miroir miroir2 = new Miroir(new Position(0,4), "SAD");
        Miroir miroir3 = new Miroir(new Position(1,3), "SAT");
        Miroir miroir4 = new Miroir(new Position(2,1), "A");
        Miroir miroir5 = new Miroir(new Position(3,4), "SAT");
        Miroir miroir6 = new Miroir(new Position(4,1), "SAT");

        listMiroir.add(miroir1);
        listMiroir.add(miroir2);
        listMiroir.add(miroir3);
        listMiroir.add(miroir4);
        listMiroir.add(miroir5);
        listMiroir.add(miroir6);

        this.initialiserMatriceANull();
        super.ajouteMiroirSurMatrice(listMiroir);

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
        this.nettoyer();

        Miroir miroir1 = new Miroir(new Position(0, 1), "SAT");
        Miroir miroir2 = new Miroir(new Position(0, 4), "SAD");
        Miroir miroir3 = new Miroir(new Position(1, 3), "SAT");
        Miroir miroir4 = new Miroir(new Position(1, 6), "SADA");
        Miroir miroir5 = new Miroir(new Position(2, 1), "A");
        Miroir miroir6 = new Miroir(new Position(3, 4), "SAT");
        Miroir miroir7 = new Miroir(new Position(4, 1), "SAT");
        Miroir miroir8 = new Miroir(new Position(4, 6), "SAT");
        Miroir miroir9 = new Miroir(new Position(5, 3), "N");
        Miroir miroir10 = new Miroir(new Position(5, 7), "SATA");
        Miroir miroir11 = new Miroir(new Position(7, 1), "SATN");
        Miroir miroir12 = new Miroir(new Position(7, 2), "SATN");
        Miroir miroir13 = new Miroir(new Position(7, 5), "N");


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


        this.mesureEntree.add(new Signal(3, "A", -1));
        this.mesureEntree.add(new Signal(5, "SAD", 1));
        this.mesureEntree.add(new Signal(7, "A", -1));
        this.mesureEntree.add(new Signal(34, "SAD", 1));
        this.mesureEntree.add(new Signal(35, "N", 1));
        this.mesureEntree.add(new Signal(37, "N", 1));

        this.listSignauxEncourDeTraitement.add(signal1);
        this.listSignauxEncourDeTraitement.add(signal2);
        this.listSignauxEncourDeTraitement.add(signal3);
        this.listSignauxEncourDeTraitement.add(signal4);
        this.listSignauxEncourDeTraitement.add(signal5);
        this.listSignauxEncourDeTraitement.add(signal6);

    }

    private void initialiseMatriceAlphaProtocol3(ArrayList<Miroir> listMiroir){
        this.nettoyer();
        Miroir miroir1 = new Miroir(new Position(0, 1), "SAT");
        Miroir miroir2 = new Miroir(new Position(0, 4), "SAD");
        Miroir miroir3 = new Miroir(new Position(1, 3), "SAT");
        Miroir miroir4 = new Miroir(new Position(1, 6), "SADA");
        Miroir miroir5 = new Miroir(new Position(2, 1), "A");
        Miroir miroir6 = new Miroir(new Position(3, 4), "SAT");
        Miroir miroir7 = new Miroir(new Position(4, 1), "SAT");
        Miroir miroir8 = new Miroir(new Position(4, 6), "SAT");
        Miroir miroir9 = new Miroir( new Position(5, 3), "N");
        Miroir miroir10 = new Miroir(new Position(5, 7), "SATA");
        Miroir miroir11 = new Miroir(new Position(7, 1), "SATN");
        Miroir miroir12 = new Miroir(new Position(7, 2), "SATN");
        Miroir miroir13 = new Miroir(new Position(7, 5), "N");

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


        String sequence = "3A-1/7A-1/5SAD+2/35N+2/37N+3/34SAD+4";
        ArrayList<Signal> listSignal = this.convertSequenceEnListSignaux(sequence);
        for (Signal signal: listSignal
             ) {
            this.mesureEntree.add(signal);
            this.listSignauxEncourDeTraitement.add(new Signal(signal.getNumEmetteurRecpteurSignal(),signal.getOrientationSignal(), signal.getDirectionSignal(), signal.getOrdreLancement()));
        }

    }

    public void avancerSignalProtocol1_2() {
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
                        && (this.getMatrice()[i][j] == null || this.getMatrice()[i][j].getOrientationMiroir().equals(signal.getOrientationSignal()))) {
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
                    signal.frappeMiroir(this.getMatrice()[i][j]);
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
        Integer maxOrdreSequence = this.recupereMaxOrdreLancement(this.listSignauxEncourDeTraitement);

        while(! this.listSignauxEncourDeTraitement.isEmpty()){
            Sequence sequenceEnCours = new Sequence(++idSeqence);
            for (Signal signal: this.listSignauxEncourDeTraitement
            ) {
                if(ordreSequence == signal.getOrdreLancement()){
                    i = signal.getPositionCaseSuivante().getLigne();
                    j = signal.getPositionCaseSuivante().getColonne();

                    while ((((i >= 0) && (i <= 9)) && ((j >= 0) && (j <= 9)))
                            && (this.getMatrice()[i][j] == null || this.getMatrice()[i][j].getOrientationMiroir().equals(signal.getOrientationSignal()))) {
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
                        this.getMatrice()[i][j].setEffetRaisonnance(false);
                        signal.frappeMiroir(this.getMatrice()[i][j]);
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

    public void avancerSignalProtocol4(){
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


    @Override
    protected void initialiseMatriceAvecMiroir(ArrayList<Miroir> listMiroir) {
        if(this.getIdProtocol() <=1) {
            this.initialiseMatriceAlphaProtocol1(this.listMiroir);
        } else if(this.getIdProtocol() <=2) {
            this.initialiseMatriceAlphaProtocol2(listMiroir);
        } else {
            this.initialiseMatriceAlphaProtocol3(this.listMiroir);
        }

    }

    @Override
    public void avancerSignal() {
        if(this.getIdProtocol() <= 2){
            this.avancerSignalProtocol1_2();
        } else if(this.getIdProtocol() <=3){
            this.avancerSignalProtocol3();
        } else {
            this.avancerSignalProtocol4();
        }
    }
}
