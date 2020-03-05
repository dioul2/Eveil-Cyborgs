package matrice;

import signaux.*;

import java.util.ArrayList;

public class MatriceAlpha {
    private Miroir[][] matriceAlpha = new Miroir[10][10];
    private ArrayList<Signal> mesureEntree = new ArrayList<Signal>();
    private ArrayList<Signal> mesureSortie = new ArrayList<Signal>();
    private ListSequence listSequence= new ListSequence(1);


    public MatriceAlpha() {
        ArrayList<Miroir> listMiroir = new ArrayList<Miroir>();

        Miroir miroir1 = new Miroir(1,this, new Position(0,1), "SAT");
        Miroir miroir2 = new Miroir(2,this, new Position(0,4), "SAD");
        Miroir miroir3 = new Miroir(3,this, new Position(1,3), "SAT");
        Miroir miroir4 = new Miroir(4,this, new Position(2,1), "A");
        Miroir miroir5 = new Miroir(5,this, new Position(3,4), "SAT");
        Miroir miroir6 = new Miroir(6,this, new Position(4,1), "SAT");

        listMiroir.add(miroir1);
        listMiroir.add(miroir2);
        listMiroir.add(miroir3);
        listMiroir.add(miroir4);
        listMiroir.add(miroir5);
        listMiroir.add(miroir6);

        for (int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                this.matriceAlpha[i][j]=null;
            }
        }

        for( Miroir miroir: listMiroir) {
            for (int i=0; i<10; i++){
                for( int j=0; j<10; j++){
                    if (i == miroir.getPositionMiroir().getLigne() && j == miroir.getPositionMiroir().getColonne()){
                        this.addMiroirDansMatriceAlpha(miroir);
                    }
                }
            }
        }

        Signal signal1 = new Signal(3,"A", -1);
        Signal signal2 = new Signal(35,"N", 1);
        Signal signal3 = new Signal(37,"N", 1);
        this.mesureEntree.add(signal1);
        this.mesureEntree.add(signal2);
        this.mesureEntree.add(signal3);


    }



    public void avancerSignal(){
        Integer i = 0;
        Integer j = 0;
        int k=0;
        Integer idSeqence = 1;
        for (Signal signal: mesureEntree
             ) {
            i = signal.getPositionSignal().getLigne();
            j = signal.getPositionSignal().getColonne();

            switch (signal.getOrientationSignal()){
                case "A": while(this.getMatriceAlpha()[i][j] == null && (i >= 0) && (i <= 9)){
                    i = i-signal.getDirectionSignal();
                }

                if((i >= 0) && (i <= 9) ){
                    Sequence sequence = new Sequence(idSeqence);
                    sequence.addMiroir(this.getMatriceAlpha()[i][j]);
                    idSeqence++;
                    this.listSequence.addSequence(sequence);
                    signal.frappeMiroir(this.getMatriceAlpha()[i][j]);
                } else{
                    if(i < 0){
                        signal.getPositionSignal().setLigne(0);
                    }else {
                        signal.getPositionSignal().setLigne(9);
                    }
                }
                break;

                case "N": while(this.getMatriceAlpha()[i][j] == null && (j >= 0) && (j <= 9)){
                    j = j+signal.getDirectionSignal();
                }
                if((j >= 0) && (j <= 9)){
                    Sequence sequence = new Sequence(idSeqence);
                    sequence.addMiroir(this.getMatriceAlpha()[i][j]);
                    idSeqence++;
                    this.listSequence.addSequence(sequence);
                    signal.frappeMiroir(this.getMatriceAlpha()[i][j]);
                }else {
                    if(j < 0){
                        signal.getPositionSignal().setColonne(0);
                    }else {
                        signal.getPositionSignal().setColonne(9);
                    }
                }

            }


        }
    }

    public ListSequence getListSequence(){
        return this.listSequence;
    }

    public void afficheMessureEntre(){
        String mesureEntre = "";
        for (Signal signal: mesureEntree
             ) {
                String directionSignal = "";
                if (signal.getDirectionSignal()<0){
                    directionSignal = "-";
                }else {
                    directionSignal = "+";
                }
            mesureEntre += signal.getNumEmetteurRecpteurSignal()+signal.getOrientationSignal()+directionSignal+"/";
        }

        System.out.println(mesureEntre);
    }

    public Miroir[][] getMatriceAlpha(){
        return this.matriceAlpha;
    }


    public void addMiroirDansMatriceAlpha(Miroir miroir){
        this.matriceAlpha[miroir.getPositionMiroir().getLigne()][miroir.getPositionMiroir().getColonne()] = miroir;
    }
    public Miroir getMiroir(int ligne, int colonne){
        return getMatriceAlpha()[ligne][colonne];
    }

    public void afficheMatrice(){
       for (int i=0; i<9; i++){
           for (int j=0; j<9; j++){
               if(getMatriceAlpha()[i][j] == null){
                   System.out.print("|  "+0);
               }else{
                   if (this.getMiroir(i,j).getOrientationMiroir().length()>1){
                       System.out.print(" |"+this.getMiroir(i,j).getOrientationMiroir());
                   }else {
                       System.out.print("|  "+this.getMiroir(i,j).getOrientationMiroir());
                   }

               }
           }
           System.out.println("\n");
       }
    }


}
