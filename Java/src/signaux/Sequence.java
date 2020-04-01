package signaux;

import java.util.ArrayList;

/***
 * Cette classe permet de recuperer la liste des miroirs frappés lors de la sequence pour ensuite pouvoir afficher la
 * sa raisonnace
 * @author dioulde
 * @author victor
 * @author lucas
 */

public class Sequence {
    private Integer idSequence;
    /**
     * Represente la liste des miroirs frappés par les signaux lors de cette sequence.
     */
    private ArrayList<Miroir> raisonnance = new ArrayList<Miroir>();

    /**
     * Construit une sequence avec son id
     * @param idSequence l'id de la sequence
     */
    public Sequence(Integer idSequence){
        this.idSequence = idSequence;
    }

    /**
     * Retourn l'id de la sequence
     */
    public Integer getIdSequence(){
        return this.idSequence;
    }

    /**
     * Permet d'ajouter un miroir à la @raisonnance
     * @param miroir miroir qui va etre ajouté
     */
    public void addMiroir(Miroir miroir){
        this.raisonnance.add(miroir);
    }

    /***
     * Methode qui affiche la raisonnance d'une sequence c'est à dire l'orientation de tous les miroirs frappés par le
     * signal aucours de cette séquence.
     */
    public  void afficheRaisonnance(){
        String messageRaisonnace = "";
        for (Miroir miroir: this.raisonnance
             ) {
            messageRaisonnace += "-"+miroir.getOrientationMiroir();

        }
        if (messageRaisonnace.isEmpty()){
            messageRaisonnace = " Aucune raisonnance";
        }
        String s =messageRaisonnace.substring(1);
        System.out.println("Raisonnance: "+s);
    }

}


