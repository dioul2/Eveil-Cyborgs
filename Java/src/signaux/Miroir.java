package signaux;

import matrice.MatriceAlpha;

import java.util.ArrayList;
import java.util.List;

public class Miroir {
    private Integer idMiroir;
    private Position positionMiroir;
    private String  orientationMiroir;



    public Miroir(Integer idMiroir,MatriceAlpha matriceAlpha, Position position, String orientationMiroir) {
        this.idMiroir = idMiroir;
        this.positionMiroir = position;
        this.orientationMiroir = orientationMiroir;
        matriceAlpha.addMiroirDansMatriceAlpha(this);

    }

    public Integer getIdMiroir() {
        return idMiroir;
    }

    public void setIdMiroir(Integer idMiroir) {
        this.idMiroir = idMiroir;
    }

    public Position getPositionMiroir(){
        return this.positionMiroir;
    }

    public String getOrientationMiroir() {
        return orientationMiroir;
    }
}
