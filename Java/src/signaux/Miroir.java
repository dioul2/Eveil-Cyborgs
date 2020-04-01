/**
 * Package qui contient toutes les classes fortements liées aux signaux notamment les classes: Miroir, Signal, Position,
 * Sequence, ListSequence.
 */
package signaux;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/***
 * Classe qui permet de créer des miroirs.
 * @author dioulde
 * @author victor
 * @author lucas
 */

public class Miroir {
    /**
     * id du miroir qui va s'autoincrementer de façon automatique.
     */
    private Integer idMiroir;

    /**
     * Reprensente la position du miroir dans la matrice c'est à dire position de la case de la matrice ou doit se placer le miroir.
     */
    private Position positionMiroir;

    /**
     * Réprensente l'orientation du miroir qui peut etre : N, SATN, SAT, SATA, A, SADA, SAD, SADN
     */
    private String  orientationMiroir;

    /**
     * Represente l'effet de raisonnance du miroir s'il est à true le miroir chage l'orientation des signaux qui le
     * frapperont s'il est à false alors le miroir ne changera pas l'effet de raisonnance des signaux qui l frapperont.
     */
    private Boolean effetRaisonnance;

    /**
     * Reprenente le numero du miroir c'est en fonction de ce numero qu'on fera la rotation du miroir.
     */
    private Integer numeroMiroir;

    /**
     * Representante la valeur incrementatle de l'id du miroir.
     */
    private static final AtomicInteger compteurId= new AtomicInteger(0);


    /**
     * Construit un miroir
     * @param position position du miroir
     * @param orientationMiroir orientatation du miroir.
     */
    public Miroir( Position position, String orientationMiroir) {
        this.idMiroir = compteurId.incrementAndGet();
        this.positionMiroir = position;
        this.orientationMiroir = orientationMiroir;
        this.setNumMiroir(this.orientationMiroir);
        this.effetRaisonnance = true;

    }

    /**
     * affecte le bon numero du miroir en fonction de l'orientation du signal par exemple si l'orientation
     * est "N"  numeroMiroir = 0.
     * @param orientationMiroir orientation du miroir.
     */
    public void setNumMiroir(String orientationMiroir) {
        switch (orientationMiroir){
            case "N": this.numeroMiroir = 0; break;
            case "SATN": this.numeroMiroir = 1; break;
            case "SAT": this.numeroMiroir = 2; break;
            case "SATA": this.numeroMiroir = 3; break;
            case "A": this.numeroMiroir = 4; break;
            case "SADA": this.numeroMiroir = 5; break;
            case "SAD": this.numeroMiroir = 6; break;
            case "SADN": this.numeroMiroir = 7; break;
            default: break;
        }
    }

    /**
     * Permet de faire une rotation de l'orientation du miroir vers la droite.
     */
    public void setOrientationMiroir() {
        this.numeroMiroir -= 1;
        if(this.numeroMiroir < 0) { this.numeroMiroir += 8;}

        switch (this.numeroMiroir){
            case 0: this.orientationMiroir = "N"; break;
            case 1: this.orientationMiroir = "SATN"; break;
            case 2: this.orientationMiroir = "SAT"; break;
            case 3: this.orientationMiroir = "SATA"; break;
            case 4: this.orientationMiroir = "A"; break;
            case 5: this.orientationMiroir = "SADA"; break;
            case 6: this.orientationMiroir = "SAD"; break;
            case 7: this.orientationMiroir = "SADN"; break;
            default: break;
        }
    }


    /**
     * Permet de modifier l'id du miroir
     * @param idMiroir id miroir
     */
    public void setIdMiroir(Integer idMiroir) {
        this.idMiroir = idMiroir;
    }

    /**
     * Determine si le signal  qui frappe l'Em/Rec va sortir de la matrice ou pas.
     * @return retourne "true" si le signal peut sortir de la matrice et false sinon.
     */
    public Boolean getEffetRaisonnance(){return this.effetRaisonnance;}
    public void setEffetRaisonnance(Boolean effetRaisonnance) {this.effetRaisonnance = effetRaisonnance;}
    public Position getPositionMiroir(){
        return this.positionMiroir;
    }

    /**
     * Permet de recuperer l'orientation du signal.
     * @return un string qui represente l'orientation du signal.
     */
    public String getOrientationMiroir() {
        return orientationMiroir;
    }
}
