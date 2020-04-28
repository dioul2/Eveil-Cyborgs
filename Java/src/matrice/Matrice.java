package matrice;

import signaux.ListSequence;
import signaux.Miroir;
import signaux.Signal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/***
 * Classe abstraite qui définie les methodes globales de toutes les matrices et declare les methodes abstraites qui
 * devraient etre implementées par les classes héritières.
 * @author dioulde
 * @author victor
 * @author lucas
 */

public abstract class Matrice {
    /**
     * Identifiant du protocol qui est compris entre 0 à 8.
     */
    protected Integer idProtocol;

    /**
     * Matrice de miroirs qui doit contenir les miroirs
     */
    protected Miroir[][] matrice = new Miroir[10][10];

    /**
     * List de miroirs à ajouter dans la matrice
     */
    protected ArrayList<Miroir> listMiroir = new ArrayList<Miroir>();

    /**
     * Liste des signaux d'entrés c'et à dire des signaux qu'on lance dans la matrice
     */
    protected static final ArrayList<Signal> mesureEntree = new ArrayList<Signal>();

    /**
     * Liste des signaux de sortie c'est à dire des signaux qui sorte de la matrice
     */
    protected List<Signal> mesureSortie = new ArrayList<Signal>();

    /**
     * Liste des signnaux en cours de traitement au debut elle est egale à la mesure d'entrée mais elle se modifie
     * au fur et à mesure de l'exécution du programme
     */
    protected ArrayList<Signal> listSignauxEncourDeTraitement = new ArrayList<Signal>();

    /**
     * Liste des sequences d'un protocol
     */
    protected ListSequence listSequence = new ListSequence(1);

    /**
     * Methode abstraite qui permet d'initialiser la matrice avec les miroirs c'est à dire placer chaque miroir à la case correspondante à sa
     * position dans la matrice et mettre "null" dans les autres cases de la matrice.
     * Donc elle doit etre rédefinie dans chacune des classes héritières.
     *
     * @param listMiroir liste des miroirs à ajouter dans la matrice.
     * @throws IOException
     */
    protected abstract void initialiseMatriceAvecMiroir(ArrayList<Miroir> listMiroir) throws IOException;

    /**
     * Methode abstraite qui permet de faire avancer les signaux dans la matrice
     * Donc elle doit etre rédefinie dans chacune des classes héritières.
     */
    protected abstract void avancerSignal();

    /**
     * Permet d'afficher la liste des signaux d'entrés par ordre croissant des numeros d'EmRec.
     */
    protected final void afficheMesureEntre() {
        try {
            Collections.sort(mesureEntree);
            String mesureEntre = "";
            for (Signal signal : mesureEntree
            ) {
                String directionSignal = "";
                if (signal.getDirectionSignal() < 0) {
                    directionSignal = "-";
                } else {
                    directionSignal = "+";
                }
                String ordrelancement = "";
                if (signal.getOrdreLancement() > 0) {
                    ordrelancement = String.valueOf(signal.getOrdreLancement());
                }
                mesureEntre += "/" + signal.getNumEmetteurRecpteurSignal() + signal.getOrientationSignal() + directionSignal + ordrelancement;
            }
            String s = mesureEntre.substring(1);
            System.out.println("Mesure d'entrée: " + s);
        } catch (SecurityException e) {
            e.getMessage();
        }
    }

    /**
     * Permet d'afficher la liste des signaux de sorties par ordre croissant des numeros d'EmRec.
     */
    protected final void afficheMesureSortie() {
        try {

            Collections.sort(this.mesureSortie);
            String mesureS = "";

            for (Signal signal: this.mesureSortie
                 ) {
                signal.setNumEmetteurRecpteurSignal();
            }
            Collections.sort(this.mesureSortie);
            for (Signal signal : this.mesureSortie
            ) {
                //signal.setNumEmetteurRecpteurSignal();
                String directionSignal = "";
                if (signal.getDirectionSignal() < 0) {
                    directionSignal = "-";
                } else {
                    directionSignal = "+";
                }

                String ordrelancement = "";
                if (signal.getOrdreLancement() > 0) {
                    ordrelancement = String.valueOf(signal.getOrdreLancement());
                }
                mesureS += "/" + signal.getNumEmetteurRecpteurSignal() + signal.getOrientationSignal() + directionSignal + ordrelancement;
            }
            String s = mesureS.substring(1);
            System.out.println("Mesure de sortie: " + s);
        } catch (SecurityException e) {
            e.getMessage();
        }
    }

    /**
     * Permet d'ajouter un miroir dans la matrice en fonction de sa position
     *
     * @param miroir miroir à ajouter
     */
    protected final void addMiroirDansMatrice(Miroir miroir) {
        try {

            this.matrice[miroir.getPositionMiroir().getLigne()][miroir.getPositionMiroir().getColonne()] = miroir;
        } catch (SecurityException e) {
            e.getMessage();
        }
    }

    protected final Miroir[][] getMatrice() {
        try {
            return this.matrice;
        } catch (SecurityException e) {
            e.getMessage();
            return null;
        }
    }

    protected Integer getIdProtocol() {
        return idProtocol;
    }


    protected final void setIdProtocol(Integer idProtocol) {
        this.idProtocol = idProtocol;
    }


    protected Miroir getMiroir(int ligne, int colonne) {
        return getMatrice()[ligne][colonne];
    }

    /**
     * Affiche la matrice avec les miroirs
     */
    protected final void afficheMatrice() {
        try {
            for (int i = 0; i <= 9; i++) {
                for (int j = 0; j <= 9; j++) {
                    if (getMatrice()[i][j] == null) {
                        System.out.print("|  " + 0);
                    } else {
                        if (this.getMiroir(i, j).getOrientationMiroir().length() > 1) {
                            System.out.print(" |" + this.getMiroir(i, j).getOrientationMiroir());
                        } else {
                            System.out.print("|  " + this.getMiroir(i, j).getOrientationMiroir());
                        }

                    }
                }
                System.out.println("\n");
            }
        } catch (SecurityException e) {
            e.getMessage();
        }
    }

    /**
     * supprime tous les signaux de la mesureEntree, mesureSortie mais aussi de la listeDesSignauxEncoursDuTraitement.
     */
    protected final void nettoyer() {
        try {

            if (!mesureEntree.isEmpty()) {
                mesureEntree.removeAll(mesureEntree);
            }

            if (!mesureSortie.isEmpty()) {
                mesureSortie.removeAll(mesureSortie);
            }

            if (!listSignauxEncourDeTraitement.isEmpty()) {
                listSignauxEncourDeTraitement.removeAll(listSignauxEncourDeTraitement);
            }

            if (!listMiroir.isEmpty()) {
                listMiroir.removeAll(listMiroir);
            }
        } catch (SecurityException e) {
            e.getMessage();
        }
    }

    /**
     * remplis la matrice avec des miroirs "null"
     */
    protected final void initialiserMatriceANull() {
        try {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    this.matrice[i][j] = null;
                }
            }
        } catch (SecurityException e) {
            e.getMessage();
        }
    }

    /**
     * remplis la matrice d'une liste de miroir en positionnant chaque miroir sur sa position dans la matrice
     *
     * @param listMiroir list miroir qui contient les miroirs à ajouter dans la matrice
     */
    protected final void ajouteMiroirSurMatrice(ArrayList<Miroir> listMiroir) {
        try {
            for (Miroir miroir : listMiroir
            ) {
                this.addMiroirDansMatrice(miroir);
            }
        } catch (SecurityException e) {
            e.getMessage();
        }

    }

    /**
     * Retourne la liste de la sequence pour nous permettre d'afficher la raisonnance de chaque sequence
     *
     * @return
     */
    protected final ListSequence getListSequence() {
        return this.listSequence;

    }

    /**
     * Permet de convertir une sequence de type string en liste de signals pour cela on utilise les methodes split()
     * qui permet de diviser une string selon un caractère appeler regex qui dans notre cas est "/" et
     * replaceAll("[^0-9]", "") pour recuperer les chiffres et ensuite parseInt pour convertir des string en Integer
     *
     * @param sequence sequence string qu'on convertie en liste signaux.
     * @return
     */
    protected final ArrayList<Signal> convertSequenceEnListSignaux(String sequence) {
        try {
            ArrayList<Signal> listSignaux = new ArrayList<Signal>();
            Integer numEmetteurRecepteur, directionSignal, ordreLancement;
            String orientationSignal = "";
            String direction = "";
            String sequences[] = sequence.split("/");
            for (String s : sequences
            ) {
                if (s.contains("+")) {
                    directionSignal = 1;
                    s = s.replace('+', '-');
                } else {
                    directionSignal = -1;
                }
                String partitionSignal[] = s.split("-");
                ordreLancement = Integer.parseInt(partitionSignal[1]);
                String recupereChiffre = partitionSignal[0].replaceAll("[^0-9]", "");
                numEmetteurRecepteur = Integer.parseInt(recupereChiffre);
                partitionSignal[0] = partitionSignal[0].replaceAll(recupereChiffre, "");
                orientationSignal = partitionSignal[0];
                listSignaux.add(new Signal(numEmetteurRecepteur, orientationSignal, directionSignal, ordreLancement));

            }
            return listSignaux;
        } catch (SecurityException e) {
            e.getMessage();
            return null;
        }
    }

    /**
     * Retourne l'ordre de lancement le plus élèvé.
     *
     * @param listSignal list des signaux.
     * @return
     */
    protected final Integer recupereMaxOrdreLancement(ArrayList<Signal> listSignal) {
        try {
            Integer max = 0;
            for (Signal signal : listSignal
            ) {
                if (signal.getOrdreLancement() > max) {
                    max = signal.getOrdreLancement();
                }
            }
            return max;
        } catch (SecurityException e) {
            e.getMessage();
            return null;
        }

    }

    /**
     * Permet de lancer le programme dans le main c'est à dire appeler les methodes  afficheMatrice(), avancerSignal(),
     *  afficheResonnanceSequence(), afficheMesureEntre(), afficheMesureSortie()
     */
    public final void lance() {
        try {
            System.out.println(" Affichage matrice protocole : ");
            this.afficheMatrice();
            this.avancerSignal();
            System.out.println(" Resultats: ");
            this.getListSequence().afficheResonnanceSequence();
            this.afficheMesureEntre();
            this.afficheMesureSortie();
        } catch (SecurityException e) {
            e.getMessage();
        }
    }


}
