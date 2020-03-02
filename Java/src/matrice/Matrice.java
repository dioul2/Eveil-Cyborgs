package matrice;

public class Matrice {

    private Integer valeurCase;
    private  Integer[][] matrice = new Integer[10][10];

    public Matrice(){

        for (int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                this.matrice[i][j]=0;
            }
        }
        matrice[0][1]=3;
        matrice[0][4]=4;
        matrice[1][3]=3;
        matrice[2][1]=1;
        matrice[3][4]=3;
        matrice[4][1]=3;
    }

    public Integer[][] getMatrice(){
        return this.matrice;
    }

    public Integer getValeurCase(Integer ligne, Integer colonne){

        return this.getMatrice()[ligne][colonne];
    }

    public void afficherMatrice(){
        for (int i=0; i<10; i++){
            for (int j=0; j<10; j++){
                System.out.print(this.matrice[i][j]+"  ");
            }
            System.out.println("\n");
        }
    }




}
