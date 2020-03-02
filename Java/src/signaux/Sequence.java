package signaux;

import java.util.List;

public class Sequence {
    private Integer idSequence;
    private List<Signal> listSignal;

    public Sequence(Integer idSequence){
        this.idSequence=idSequence;
        Signal s1=new Signal(1,3,1,-1);
        Signal s2=new Signal(2,37,2,1);
        Signal s3=new Signal(3,35,2,1);

        this.listSignal.add(s1);
        this.listSignal.add(s2);
        this.listSignal.add(s3);

    }

}
