package signaux;

import matrice.MatriceAlpha;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Miroir {
    private Integer idMiroir;
    private Position positionMiroir;
    private String  orientationMiroir;
    private Boolean effetRaisonnance;
    private static final AtomicInteger compteurId= new AtomicInteger(0);



    public Miroir(Integer idMiroir,MatriceAlpha matriceAlpha, Position position, String orientationMiroir) {
        this.idMiroir = idMiroir;
        this.positionMiroir = position;
        this.orientationMiroir = orientationMiroir;
        this.effetRaisonnance = true;
        matriceAlpha.addMiroirDansMatriceAlpha(this);

    }
    public Miroir( Position position, String orientationMiroir) {
        this.idMiroir = compteurId.incrementAndGet();
        this.positionMiroir = position;
        this.orientationMiroir = orientationMiroir;
        this.effetRaisonnance = true;

    }

    public Integer getIdMiroir() {
        return idMiroir;
    }

    public void setIdMiroir(Integer idMiroir) {
        this.idMiroir = idMiroir;
    }

    public Boolean getEffetRaisonnance(){return this.effetRaisonnance;}
    public void setEffetRaisonnance(Boolean effetRaisonnance) {this.effetRaisonnance = effetRaisonnance;}
    public Position getPositionMiroir(){
        return this.positionMiroir;
    }

    public String getOrientationMiroir() {
        return orientationMiroir;
    }
}
