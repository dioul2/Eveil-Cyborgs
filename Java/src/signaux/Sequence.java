package signaux;

import java.util.ArrayList;
import java.util.List;

public class Sequence {
    private Integer idSequence;
    private ArrayList<Signal> listSignal = new ArrayList<Signal>();
    private ArrayList<Miroir> raisonnance = new ArrayList<Miroir>();

    public Sequence(Integer idSequence){
        this.idSequence = idSequence;
    }
    public Integer getIdSequence(){
        return this.idSequence;
    }


    public void addMiroir(Miroir miroir){
        this.raisonnance.add(miroir);
    }

    public void addSignal(Signal signal){
        this.listSignal.add(signal);
    }

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

    public void afficheSignalSequence(){
        String signalSequence = "";

        for (Signal signal: this.listSignal
        ) {
            signalSequence +="/"+signal.getNumEmetteurRecpteurSignal()+""+signal.getOrientationSignal()+""+signal.getDirectionSignal()+""+signal.getOrdreLancement();
        }
        System.out.println(signalSequence);
    }

}


