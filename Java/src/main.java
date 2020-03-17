import matrice.Matrice;
import matrice.MatriceAlpha;

public class main {
    public static void main(String[] args) {
        /*MatriceAlpha matrice=new MatriceAlpha();
        matrice.afficheMatrice();
        matrice.avancerSignal();
        matrice.getListSequence().afficheResonnanceSequence();
        matrice.afficheMesureEntre();
        matrice.afficheMesureSortie();*/

        MatriceAlpha matriceAlpha = new MatriceAlpha(3);
        matriceAlpha.afficheMatrice();
        matriceAlpha.avancerSignalProtol3();
        matriceAlpha.getListSequence().afficheResonnanceSequence();
        matriceAlpha.afficheMesureEntre();
        matriceAlpha.afficheMesureSortie();

        /*MatriceAlpha matriceAlpha1 = new MatriceAlpha(3);
        matriceAlpha1.afficheMatrice();
        matriceAlpha1.avancerSignalProtol3();
        matriceAlpha1.getListSequence().afficheResonnanceSequence();
        matriceAlpha1.getListSequence().afficheSignalSequence();
        matriceAlpha1.afficheMesureEntre();
        matriceAlpha1.afficheMesureSortie();*/
    }
}
