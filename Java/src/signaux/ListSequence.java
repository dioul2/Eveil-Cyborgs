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
        String messageRaisonnance = "";
        Integer idSequence=1;
        for (Sequence sequence: listSquence
             ) {
            messageRaisonnance += sequence.afficheRaisonnance();
        }
        System.out.println("Sequence #"+idSequence);
        System.out.println(messageRaisonnance);
    }


}
