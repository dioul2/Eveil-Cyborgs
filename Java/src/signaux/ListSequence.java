package signaux;

import java.util.List;

public class ListSequence {
    private Integer idListSequence;
    private List<Sequence> listSquence;

    public ListSequence(Integer idListSequence){
        this.idListSequence = idListSequence;
        Sequence sequence=new Sequence(1);
        this.listSquence.add(sequence);
    }


}
