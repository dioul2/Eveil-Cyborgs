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


    public void addMiroir(Miroir miroir){
        this.raisonnance.add(miroir);
    }

    public  String afficheRaisonnance(){
        String messageRaisonnace = "";
        for (Miroir miroir: raisonnance
             ) {
            messageRaisonnace += miroir.getOrientationMiroir()+"-";

        }
        return messageRaisonnace;
    }

}
