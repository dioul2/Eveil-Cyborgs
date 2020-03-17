package signaux;

import java.util.ArrayList;
import java.util.List;

public class ListSequence {
    private Integer idListSequence;
    private ArrayList<Sequence> listSquence = new ArrayList<Sequence>();
   

    public ListSequence(Integer idListSequence){
        this.idListSequence = idListSequence;
    }

    public void addSequence(Sequence sequence){
        this.listSquence.add(sequence);
    }

    public void afficheResonnanceSequence(){
        for (Sequence sequence: this.listSquence
             ) {
            System.out.println("Sequence #"+sequence.getIdSequence());
             sequence.afficheRaisonnance();
        }

    }

    public void afficheSignalSequence(){
        for (Sequence sequence: this.listSquence
             ) {
            sequence.afficheSignalSequence();
        }
    }


}
