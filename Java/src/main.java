import matrice.Matrice;
import matrice.MatriceAlpha;

public class main {
    public static void main(String[] args) {
        MatriceAlpha matrice=new MatriceAlpha();
        matrice.afficheMatrice();
        matrice.avancerSignal();
        matrice.getListSequence().afficheResonnanceSequence();
        matrice.afficheMessureEntre();
    }
}
