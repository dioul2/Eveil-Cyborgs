package signaux;

import java.util.ArrayList;
/***
 * Cette classe permet de recuperer la liste des sequences d'un protocol pour ensuite
 * pouvoir afficher la  raisonnace de chacune des séquences
 * @author dioulde
 * @author victor
 * @author lucas
 */

public class ListSequence {
    private Integer idListSequence;
    private ArrayList<Sequence> listSquence = new ArrayList<Sequence>();

    /**
     * Construit un objet contenant une liste de sequence.
     * @param idListSequence l'id de la liste de sequence.
     */
    public ListSequence(Integer idListSequence){
        this.idListSequence = idListSequence;
    }

    /**
     * Permet d'ajouter une sequence à la liste de sequence.
     * @param sequence sequence qui doit etre ajoutée.
     */
    public void addSequence(Sequence sequence){
        this.listSquence.add(sequence);
    }

    /**
     * Permet d'afficher la raisonance de chacune des sequences en utilisant la methode
     * afficheRaisance de la class sequence.
     */
    public void afficheResonnanceSequence(){
        for (Sequence sequence: this.listSquence
             ) {
            System.out.println("Sequence #"+sequence.getIdSequence());
             sequence.afficheRaisonnance();
        }

    }


}
