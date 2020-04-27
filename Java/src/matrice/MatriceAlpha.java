package matrice;

import signaux.Miroir;
import signaux.Position;
import signaux.Sequence;
import signaux.Signal;

import java.util.ArrayList;
import java.util.Collections;

/***
 * Classe qui permet de créer les matrices des protocoles 1, 2, 3 et 4.
 * @author dioulde
 * @author victor
 * @author lucas
 */

final class MatriceAlpha extends Matrice {


    /**
     * Permet de creer une matrice en fonction de l'id du protocol
     *
     * @param idprotocol id du protocol courant
     * @throws RuntimeException lance unec exception si l'idProtocol n'est pas compris entre 0 à 8.
     */
    public MatriceAlpha(Integer idprotocol) {
        try {
            if (idprotocol < 0 || idprotocol > 8) {
                throw new RuntimeException("L'id du protocol doit etre compris entre 1 et 8");
            }
            this.setIdProtocol(idprotocol);
            this.initialiseMatriceAvecMiroir(this.listMiroir);
        } catch (SecurityException e) {
            e.getMessage();
        }
    }


    /**
     * Initialise la matriceAlphaProtocol1 c'est à dire en ajoutant les miroirs correspondants et mettant null aux
     * autres cases de la matrice mais aussi en lançant les signaux dans la matrice c'est à dire remplir la mesure
     * d'entree mais aussi la listSignauxEncoursDeTraitement.
     *
     * @param listMiroir list miroirs à ajouter.
     */
    private void initialiseMatriceAlphaProtocol1(ArrayList<Miroir> listMiroir) {
        try {
            this.nettoyer();

            Miroir miroir1 = new Miroir(new Position(0, 1), "SAT");
            Miroir miroir2 = new Miroir(new Position(0, 4), "SAD");
            Miroir miroir3 = new Miroir(new Position(1, 3), "SAT");
            Miroir miroir4 = new Miroir(new Position(2, 1), "A");
            Miroir miroir5 = new Miroir(new Position(3, 4), "SAT");
            Miroir miroir6 = new Miroir(new Position(4, 1), "SAT");

            listMiroir.add(miroir1);
            listMiroir.add(miroir2);
            listMiroir.add(miroir3);
            listMiroir.add(miroir4);
            listMiroir.add(miroir5);
            listMiroir.add(miroir6);

            this.initialiserMatriceANull();
            super.ajouteMiroirSurMatrice(listMiroir);

            Signal signal1 = new Signal(3, "A", -1);
            Signal signal2 = new Signal(35, "N", 1);
            Signal signal3 = new Signal(37, "N", 1);
            this.mesureEntree.add(signal1);
            this.mesureEntree.add(signal2);
            this.mesureEntree.add(signal3);

            this.listSignauxEncourDeTraitement.add(new Signal(3, "A", -1));
            this.listSignauxEncourDeTraitement.add(new Signal(35, "N", 1));
            this.listSignauxEncourDeTraitement.add(new Signal(37, "N", 1));
        } catch (SecurityException e) {
            e.getMessage();
        }
    }


    /**
     * Initialise la matriceAlphaProtocol2 c'est à dire en ajoutant les miroirs correspondants et mettant null aux
     * autres cases de la matrice mais aussi en lançant les signaux dans la matrice c'est à dire remplir la museure
     * * de sortie mais aussi la listSeSignauxEncoursDeTraitement.
     *
     * @param listMiroir list miroirs à ajouter.
     */
    private void initialiseMatriceAlphaProtocol2(ArrayList<Miroir> listMiroir) {
        try {
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
        } catch (SecurityException e) {
            e.getMessage();
        }

    }

    /**
     * Initialise la matriceAlphaProtocol3 c'est à dire en ajoutant les miroirs correspondants et mettant null aux
     * autres cases de la matrice mais aussi en lançant les signaux dans la matrice c'est à dire remplir la museure
     * * de sortie mais aussi la listSeSignauxEncoursDeTraitement.
     *
     * @param listMiroir list miroirs à ajouter.
     */
    private void initialiseMatriceAlphaProtocol3(ArrayList<Miroir> listMiroir) {
        try {
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


            String sequence = "3A-1/7A-1/5SAD+2/35N+2/37N+3/34SAD+4";
            ArrayList<Signal> listSignal = this.convertSequenceEnListSignaux(sequence);
            for (Signal signal : listSignal
            ) {
                this.mesureEntree.add(signal);
                this.listSignauxEncourDeTraitement.add(new Signal(signal.getNumEmetteurRecpteurSignal(), signal.getOrientationSignal(), signal.getDirectionSignal(), signal.getOrdreLancement()));
            }
        } catch (SecurityException e) {
            e.getMessage();
        }

    }

    /**
     * Permet de faire avancer chaque signal des protocoles 1 et 2 selon son orientation et sa direction  jusqu'à ce
     * qu'il frappe un miroir ou il sort de la matrice.
     */
    private void avancerSignalProtocol1_2() {
        try {
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
                Collections.sort(mesureSortie);
                for (Signal signal : mesureSortie
                ) {
                    listSignauxEncourDeTraitement.remove(signal);

                }
            }
        } catch (SecurityException e) {
            e.getMessage();
        }
    }

    /**
     * Permet de faire avancer chaque signal du protocolse 3 en mode asynchrone selon son orientation sa direction
     * mais aussi son ordre de lancement jusqu'à ce qu'il frappe un miroir ou il sort de la matrice.
     * Pour cela à chaque itération on deplacera que les signaux de listSignauxEncourTraitement qui ont l'odre de
     * lancement correspondant a la sequence.
     * Par expemple si on a les signaux "3A-1/7A-1/5SAD+2/35N+2/37N+3/34SAD+4" on traitera d'abord les signaux 3A-1/7A-1
     * s'ils sorte de la matrice à cette sequence tant mieux sinon on changera leur ordre de lancement pour qu'on puisse
     * les déplacer lors de la prochaines sequence.
     */
    private void avancerSignalProtocol3() {
        try {
            Integer i = 0;
            Integer j = 0;
            Integer idSeqence = 0;
            Integer ordreSequence = 1;
            Integer maxOrdreSequence = this.recupereMaxOrdreLancement(this.listSignauxEncourDeTraitement);

            while (!this.listSignauxEncourDeTraitement.isEmpty()) {
                Sequence sequenceEnCours = new Sequence(++idSeqence);
                for (Signal signal : this.listSignauxEncourDeTraitement
                ) {
                    if (ordreSequence == signal.getOrdreLancement()) {
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
                if (ordreSequence >= maxOrdreSequence) {
                    ordreSequence = maxOrdreSequence;
                }
                for (Signal signal : listSignauxEncourDeTraitement
                ) {
                    if (signal.getOrdreLancement() <= ordreSequence) {
                        signal.setOrdreLancement(ordreSequence);
                    }

                }
            }
        } catch (SecurityException e) {
            e.getMessage();
        }
    }

    /**
     * Permet de faire avancer chaque signal du protocolse 4 en mode asynchrone comme dans le protocol3 selon son
     * orientation sa direction mais aussi son ordre de lancement jusqu'à ce qu'il frappe un miroir ayant un effet de
     * raisonnance à "true" ou il sort de la matrice.
     * Dans ce protocol chaque miroir a un attribut boolean effetRaisonnance qui determine si le miroir va
     * déclencher l'effet de raisonnace ou pas pour cela au debut on l'initialise à true pour tout les miroirs et
     * à chaque fois qu'un signal va frapper un miroir on met l'effetRaisonnance à false pour desactiver son effet de
     * raisonnance comme ça les signaux qui viendront après lors de cette sequence vont traverser le miroir sans qu'il
     * n'y ai de changement de direction donc un miroir avec un effetRaisonncance = false equivaut à un miroir null.
     */
    private void avancerSignalProtocol4() {
        try {
            Integer i = 0;
            Integer j = 0;
            Integer idSeqence = 0;
            Integer ordreSequence = 1;
            Integer maxOrdreSequence = this.recupereMaxOrdreLancement(this.listSignauxEncourDeTraitement);
            Integer k = 1;
            while (!this.listSignauxEncourDeTraitement.isEmpty()) {
                Sequence sequenceEnCours = new Sequence(++idSeqence);
                for (Signal signal : this.listSignauxEncourDeTraitement
                ) {
                    if (ordreSequence == signal.getOrdreLancement()) {
                        i = signal.getPositionCaseSuivante().getLigne();
                        j = signal.getPositionCaseSuivante().getColonne();

                        while (((((i >= 0) && (i <= 9)) && ((j >= 0) && (j <= 9)))
                                && (this.getMatrice()[i][j] == null || this.getMatrice()[i][j].getOrientationMiroir().equals(signal.getOrientationSignal())))
                                || ((((i >= 0) && (i <= 9)) && ((j >= 0) && (j <= 9))) && ((this.getMatrice()[i][j] != null)
                                && (!this.getMatrice()[i][j].getEffetRaisonnance())))) {
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
                if (ordreSequence >= maxOrdreSequence) {
                    ordreSequence = maxOrdreSequence;
                }
                for (Signal signal : listSignauxEncourDeTraitement
                ) {
                    if (signal.getOrdreLancement() <= ordreSequence) {
                        signal.setOrdreLancement(ordreSequence);
                    }

                }
            }
        } catch (SecurityException e) {
            e.getMessage();
        }
    }


    /**
     * Permet d'initialiser la matrice avec la bonne methode en fonction de l'id du protocol
     * c'est à dire: si l'idProtocol = 1  on appelle la methode initialiseMatriceAlphaProtocol1().
     * si l'idProtocol = 1  on appelle la methode initialiseMatriceAlphaProtocol2().
     * si l'idProtocol = 3 ou 4  on appelle la methode initialiseMatriceAlphaProtocol3().
     */
    @Override
    protected void initialiseMatriceAvecMiroir(ArrayList<Miroir> listMiroir) {
        try {
            if (this.getIdProtocol() <= 1) {
                this.initialiseMatriceAlphaProtocol1(this.listMiroir);
            } else if (this.getIdProtocol() <= 2) {
                this.initialiseMatriceAlphaProtocol2(listMiroir);
            } else {
                this.initialiseMatriceAlphaProtocol3(this.listMiroir);
            }
        } catch (SecurityException e) {
            e.getMessage();
        }

    }

    /**
     * Permet de lancer la bonne methode AvancerSignal() en fonction de l'id du protocol
     * c'est à dire: si l'idProtocol = 1 ou 2  on appelle la methode avancerSgnalProtocol1_2().
     * si l'idProtocol = 3  on appelle la methode avancerSgnalProtocol3().
     * si l'idProtocol = 4 on appelle la methode avancerSgnalProtocol4().
     */
    @Override
    protected void avancerSignal() {
        try {
            if (this.getIdProtocol() <= 2) {
                this.avancerSignalProtocol1_2();
            } else if (this.getIdProtocol() <= 3) {
                this.avancerSignalProtocol3();
            } else {
                this.avancerSignalProtocol4();
            }
        } catch (SecurityException e) {
            e.getMessage();
        }
    }
}
