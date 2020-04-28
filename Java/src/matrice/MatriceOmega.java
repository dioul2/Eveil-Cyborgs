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
import java.util.Collections;

/***
 * Classe qui permet de créer les matrices des protocoles 5, 6, 7 et X.
 * @author dioulde
 * @author victor
 * @author lucas
 */

final class MatriceOmega extends Matrice {

    /**
     * Permet de creer une matrice en fonction de l'id du protocol
     *
     * @param idProtocol id du protocol courant
     * @throws RuntimeException lance unec exception si l'idProtocol n'est pas compris entre 0 à 8.
     */
    public MatriceOmega(Integer idProtocol) throws IOException {
        if (idProtocol < 0 || idProtocol > 8) {
            throw new RuntimeException("L'id du protocol doit etre compris entre 1 et 8");
        }
        this.setIdProtocol(idProtocol);
        this.initialiseMatriceAvecMiroir(this.listMiroir);
        //k++;

    }

    /**
     * Initialise la matrice omegaProtocol6 en remplissant la liste des miroirs par les strings contenu dans le fichier
     * miroirFile, les signaux dans le fichier mesureFile et ensuite ajouter les miroirs dans la matrice et mettre null
     * dans les autres cases mais aussi en lançant les signaux dans la matrice c'est à dire remplir la mesure
     * d'entree mais aussi la listSignauxEncoursDeTraitement.
     *
     * @param miroirFile string qui contient le chemin d'accès du fichier miroirFile.txt
     * @param mesureFile string qui contient le chemin d'accès du fichier mesureFile.txt
     * @param listMiroir listMiroir dans laquelle on a ajouter les miroirs qu'on va trouver dans le fichier miroirFile.txt.
     * @throws IOException Lance une exception lors de la lecture des données  dans les fichiers miroirFile.txt et mesureFile.txt.
     */
    private void initialiseMatriceOmegaProtocol6(String miroirFile, String mesureFile, ArrayList<Miroir> listMiroir) throws IOException {
        /**
         * List des strings trouvés dans le fichier miroirFile.txt.
         */
        ArrayList<String> listStringMiroir = new ArrayList<String>();
        /**
         * List des strings trouvés dans le fichier mesureFile.txt
         */
        ArrayList<String> listStringSignaux = new ArrayList<String>();

        /**
         * List des signaux recuperer à partir de la ListStringSignaux.
         */
        ArrayList<Signal> listSignal = new ArrayList<Signal>();

        listStringMiroir = this.recuperelistStringMiroir(miroirFile);
        listStringSignaux = this.recuperelistStringSignaux(mesureFile);

        listMiroir = this.convertListStringMiroirEnListMiroir(listStringMiroir);
        listSignal = this.convertSequenceEnListSignaux(listStringSignaux.get(0));

        this.initialiserMatriceANull();

        this.ajouteMiroirSurMatrice(listMiroir);

        for (Signal s : listSignal
        ) {
            mesureEntree.add(s);
            this.listSignauxEncourDeTraitement.add(new Signal(s.getNumEmetteurRecpteurSignal(), s.getOrientationSignal(), s.getDirectionSignal(), s.getOrdreLancement()));
        }

    }


    /**
     * Initialise la matrice omegaProtocol7 en remplissant la liste des miroirs par les strings contenu dans le fichier
     * miroirFile, les signaux sont initialisés automatiquemement par la méthode initialiseSignauxString() et ensuite
     * ajouter les miroirs dans la matrice et mettre null dans les autres cases mais aussi en lançant les signaux
     * dans la matrice c'est à dire remplir la mesure d'entree mais aussi la listSignauxEncoursDeTraitement.
     *
     * @param miroirFile string qui contient le chemin d'accès du fichier miroirFile.txt
     * @param listMiroir listMiroir dans laquelle on a ajouter les miroirs qu'on va trouver dans le fichier miroirFile.txt.
     * @throws IOException Lance une exception lors de la lecture des données  dans les fichiers miroirFile.txt et mesureFile.txt.
     */
    private void initialiseMatriceOmegaProtocol7(String miroirFile, ArrayList<Miroir> listMiroir) throws IOException {

        /**
         * List des strings trouvés dans le fichier miroirFile.txt.
         */
        ArrayList<String> listStringMiroir = new ArrayList<String>();

        /**
         * List des recuperés par la methode initialiseSignauxString().
         */
        ArrayList<String> listStringSignaux = new ArrayList<String>();

        /**
         * List signaux d'une sequence donnée.
         */
        ArrayList<Signal> listSignalIntermediaire = new ArrayList<Signal>();

        /**
         * List des signaux recupérés à partire de listStringSignaux.
         */
        ArrayList<Signal> listSignal = new ArrayList<Signal>();


        listStringMiroir = this.recuperelistStringMiroir(miroirFile);
        listStringSignaux = this.initialiseSignauxString();

        listMiroir = this.convertListStringMiroirEnListMiroir(listStringMiroir);

        for (String stringSignal : listStringSignaux
        ) {
            listSignalIntermediaire = this.convertSequenceEnListSignaux(stringSignal);
            listSignal.addAll(listSignalIntermediaire);
        }

        this.initialiserMatriceANull();

        this.ajouteMiroirSurMatrice(listMiroir);

        for (Signal s : listSignal
        ) {
            mesureEntree.add(s);
            this.listSignauxEncourDeTraitement.add(new Signal(s.getNumEmetteurRecpteurSignal(), s.getOrientationSignal(), s.getDirectionSignal(), s.getOrdreLancement()));
        }

    }


    /**
     * Méthode qui retourne une liste de string qui contient tous les string contenu dans le fichier miroirFile.txt.
     * Pour cela on a utilisé la classe BufferedReader avec la methode readLine().
     *
     * @param cheminFichier chemin d'accès du fichier miroirFile.txt.
     * @return
     * @throws IOException Lance une exception lors de la lecture des données  dans les fichiers miroirFile.txt.
     */
    private ArrayList<String> recuperelistStringMiroir(String cheminFichier) throws IOException {
        try {
            ArrayList<String> listStringMiroir = new ArrayList<String>();
            BufferedReader bufferedReader = null;
            File file = new File(cheminFichier);

            bufferedReader = new BufferedReader(new FileReader(file));

            String miroir = null;

            while ((miroir = bufferedReader.readLine()) != null) {
                listStringMiroir.add(miroir);
            }
            return listStringMiroir;
        } catch (SecurityException e) {
            e.getMessage();
            return null;
        }
    }


    /**
     * Méthode qui retourne une liste de string qui contient tous les string contenu dans le fichier mesureFile.txt.
     * Pour cela on a utilisé la classe BufferedReader avec la methode readLine().
     *
     * @param cheminFichier chemin d'accès du fichier mesureFile.txt.
     * @return
     * @throws IOException Lance une exception lors de la lecture des données  dans les fichiers miroirFile.txt.
     */
    private ArrayList<String> recuperelistStringSignaux(String cheminFichier) throws IOException {
        try {
            ArrayList<String> listStringSignaux = new ArrayList<String>();
            BufferedReader bufferedReader = null;
            File file = new File(cheminFichier);

            bufferedReader = new BufferedReader(new FileReader(file));

            String miroir = null;

            while ((miroir = bufferedReader.readLine()) != null) {
                listStringSignaux.add(miroir);
            }
            return listStringSignaux;
        } catch (SecurityException e) {
            e.getMessage();
            return null;
        }
    }


    /**
     * Methode qui convertie une list de string en list de miroirs.
     *
     * @param listStringMiroir list de string qu'on doit convertir en list de miroir.
     * @return retourne une liste de miroir.
     */
    private ArrayList<Miroir> convertListStringMiroirEnListMiroir(ArrayList<String> listStringMiroir) {
        try {
            ArrayList<Miroir> listMiroir = new ArrayList<Miroir>();
            Integer i = 1;
            Miroir miroir = null;
            for (String s : listStringMiroir
            ) {
                miroir = this.convertStringEnMiroir(s);
                miroir.setIdMiroir(i);
                listMiroir.add(miroir);
            }
            return listMiroir;
        } catch (SecurityException e) {
            e.getMessage();
            return null;
        }
    }


    /**
     * Methode qui convertie un string en miroir.
     *
     * @param stringMiroir string à convertir en miroir.
     * @return retourne un miroir.
     */
    private Miroir convertStringEnMiroir(String stringMiroir) {
        try {
            String chiffres = stringMiroir.replaceAll("[^0-9]", "");
            stringMiroir = stringMiroir.replace(chiffres, "");
            String ligneString = chiffres.substring(chiffres.length() - 2);
            chiffres = chiffres.replace(ligneString, "");
            Integer colonne = Integer.parseInt(chiffres);
            Integer ligne = 39 - Integer.parseInt(ligneString);
            String orientation = stringMiroir;

            return new Miroir(new Position(ligne, colonne), orientation);
        } catch (SecurityException e) {
            e.getMessage();
            return null;
        }
    }


    /**
     * Methode qui initialise de façon automatique tous les strings des signaux des protocoles 7 et X selon l'ordre
     * suivante:
     * Séquence #1 : 0SAT-1/0A-1/0SAD+1.
     * Séquence #2 : 1SAT-2/1A-2/1SAD+2.
     * ...
     * Séquence #39 : 39SAT-40/0A-40/0SAD+40
     *
     * @return retourne une liste de string contenant tous les strings de signaux crées.
     */
    private ArrayList<String> initialiseSignauxString() {
        try {
            ArrayList<String> listStringSignal = new ArrayList<String>();
            String orientationSignal1 = "";
            String orientationSignal2 = "";
            String orientationSignal3 = "";
            String signalString = "";

            for (int i = 0; i < 40; i++) {
                if (i <= 9) {
                    orientationSignal1 = "SAT-";
                    orientationSignal2 = "A-";
                    orientationSignal3 = "SAD+";
                } else if (i < 20) {
                    orientationSignal1 = "SAD-";
                    orientationSignal2 = "N-";
                    orientationSignal3 = "SAT-";
                } else if (i < 30) {
                    orientationSignal1 = "SAD-";
                    orientationSignal2 = "A+";
                    orientationSignal3 = "SAT+";
                } else {
                    orientationSignal1 = "SAT+";
                    orientationSignal2 = "N+";
                    orientationSignal3 = "SAD+";
                }
                signalString = i + orientationSignal1 + (i + 1) + "/" + i + orientationSignal2 + (i + 1) + "/" + i + orientationSignal3 + (i + 1);
                listStringSignal.add(signalString);
                signalString = "";
            }

            return listStringSignal;
        } catch (SecurityException e) {
            e.getMessage();
            return null;
        }
    }


    /**
     * Permet de faire avancer chaque signal du protocolse 7 en mode asynchrone comme dans le protocol6 selon son
     * orientation, sa direction mais aussi son ordre de lancement jusqu'à ce qu'il frappe un miroir ayant un effet de
     * raisonnance à "true" ou il sort de la matrice.
     * Pour cela sur chaque Em/Rec on va lancer chacun des trois signaux et ensuite avant de faire sortir un signal
     * vers un Em/Rec on vérifie d'abord si le signal va  etre accepté par l' Em/Rec si oui on le fait sortir de la
     * matrice sinon on le rejette en faisant passer l'Em/Rec comme un miroir
     */
    private void avancerSignalProtocol7() {
        try {
            Integer i = 0;
            Integer j = 0;
            Integer idSeqence = 0;
            Integer ordreSequence = 1;
            Integer maxOrdreSequence = this.recupereMaxOrdreLancement(this.listSignauxEncourDeTraitement);
            while (!listSignauxEncourDeTraitement.isEmpty()) {
                Sequence sequenceEnCours = new Sequence(++idSeqence);
                for (Signal signal : this.listSignauxEncourDeTraitement
                ) {
                    if (ordreSequence == signal.getOrdreLancement()) {
                        i = signal.getPositionCaseSuivante().getLigne();
                        j = signal.getPositionCaseSuivante().getColonne();

                        while (((((i >= 0) && (i <= 9)) && ((j >= 0) && (j <= 9)))
                                && (this.getMatrice()[i][j] == null || this.getMatrice()[i][j].getOrientationMiroir().equals(signal.getOrientationSignal())))
                                || ((((i >= 0) && (i <= 9)) && ((j >= 0) && (j <= 9))) && ((this.getMatrice()[i][j] != null)
                                && (this.getMatrice()[i][j].getEffetRaisonnance())))) {
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

                            if (signal.rejeteSignal1(new Position(i, j))) {
                                Miroir miroir = null;
                                if (j == 0 || j == 9) {
                                    miroir = new Miroir(new Position(i, j), "A");
                                    signal.frappeEmetteurRecepteur(miroir);
                                }
                                if (i == 0 || i == 9) {
                                    miroir = new Miroir(new Position(i, j), "N");
                                    signal.frappeEmetteurRecepteur(miroir);
                                }

                                sequenceEnCours.addMiroir(miroir);
                                signal.setOrdreLancement(ordreSequence);
                            } else {
                                signal.setNumEmetteurRecpteurSignal();
                                this.mesureSortie.add(signal);
                            }
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
     * Permet de faire avancer chaque signal du protocolse X en mode asynchrone comme dans le protocol7 selon son
     * orientation, sa direction mais aussi son ordre de lancement jusqu'à ce qu'il frappe un miroir ayant un effet de
     * raisonnance à "true" ou il sort de la matrice.
     * Pour cela sur chaque Em/Rec on va lancer chacun des trois signaux et ensuite avant de faire sortir un signal
     * vers un Em/Rec on vérifie d'abord si le signal va  etre accepté par l' Em/Rec si oui on le fait sortir de la
     * matrice sinon on le rejette en faisant passer l'Em/Rec comme un miroir.
     * En plus dans ce protocol à  chaque fois qu'un miroir sera fràppé, il changera d'orientation d'une rotation
     * vers la droite (Par exemple : Un miroir SATA se transforme en miroir SAT).
     */
    private void avancerSignalProtocolX() {
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
                            this.getMatrice()[i][j].setOrientationMiroir();
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
     * c'est à dire: si l'idProtocol = 6 on appelle la methode initialiseMatriceOmegaProtocol6().
     * si l'idProtocol = 7  on appelle la methode initialiseMatriceOmegaProtocol7().
     */
    @Override
    protected void initialiseMatriceAvecMiroir(ArrayList<Miroir> listMiroir) throws IOException {
        try {
            String miroirFile = "/home/dioulde/IdeaProjects/Eveil-Cyborgs/Java/fichiertxt/omega_miroir.txt";
            String mesureFile = "/home/dioulde/IdeaProjects/Eveil-Cyborgs/Java/fichiertxt/omega_mesure.txt";
            if (this.getIdProtocol() == 6) {
                this.initialiseMatriceOmegaProtocol6(miroirFile, mesureFile, this.listMiroir);
            } else {
                this.initialiseMatriceOmegaProtocol7(miroirFile, this.listMiroir);
            }
        } catch (SecurityException e) {
            e.getMessage();
        }
    }

    /**
     * Permet de lancer la bonne methode AvancerSignal() en fonction de l'id du protocol
     * c'est à dire: si l'idProtocol = 7 ou 2 on appelle la methode avancerSgnalProtocol().
     * si l'idProtocol = 8 on appelle la methode avancerSgnalProtocolX().
     */
    @Override
    protected void avancerSignal() {
        try {
            Collections.sort(mesureSortie);
            if (idProtocol == 7) {
                this.avancerSignalProtocol7();
            } else {
                this.avancerSignalProtocolX();
            }
        } catch (SecurityException e) {
            e.getMessage();
        }
    }
}
