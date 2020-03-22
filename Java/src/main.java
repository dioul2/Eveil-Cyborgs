import matrice.*;
import signaux.Signal;

import java.io.*;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) throws IOException {
        /*MatriceAlpha matrice=new MatriceAlpha();
        matrice.afficheMatrice();
        matrice.avancerSignal();
        matrice.getListSequence().afficheResonnanceSequence();
        matrice.afficheMesureEntre();
        matrice.afficheMesureSortie();*/
        String sequence = "3A-1/7A-1/32N+1/5SAD+2/32N+2/35N+2/7A-3/37N+3/34SAD+4";
        String miroirFile = "/home/dioulde/IdeaProjects/Eveil-Cyborgs/Java/src/omega_miroir.txt";
        String mesureFile = "/home/dioulde/IdeaProjects/Eveil-Cyborgs/Java/src/omega_mesure.txt";



         MatriceAlpha matriceAlpha = new MatriceAlpha(miroirFile, mesureFile);
        /*matriceAlpha.afficheMatrice();
        matriceAlpha.avancerSignalProtocol4();
        matriceAlpha.getListSequence().afficheResonnanceSequence();
        matriceAlpha.afficheMesureEntre();
        matriceAlpha.afficheMesureSortie();*/

        /*MatriceOmega matriceA= new MatriceOmega();
        matriceA.afficheMatrice();
        matriceA.avancerSignal();
        matriceA.getListSequence().afficheResonnanceSequence();
        matriceA.afficheMesureEntre();
        matriceA.afficheMesureSortie();*/

        Matrice matriceAphaProtocol1 = FactoryMatrice.getMatrice(1);
        matriceAphaProtocol1.lance();
        Matrice matriceAlphaProtocol2 = FactoryMatrice.getMatrice(2);
        matriceAlphaProtocol2.lance();
        Matrice matriceAlphaProtocol3 = FactoryMatrice.getMatrice(3);
        matriceAlphaProtocol3.lance();
        Matrice matriceAlphaProtocol4 = FactoryMatrice.getMatrice(4);
        matriceAlphaProtocol4.lance();
        Matrice matriceProtoProtocol5 = FactoryMatrice.getMatrice(5);
        matriceProtoProtocol5.lance();

        /*MatriceAlpha matriceAlpha1 = new MatriceAlpha(3);
        matriceAlpha1.afficheMatrice();
        matriceAlpha1.avancerSignalProtol3();
        matriceAlpha1.getListSequence().afficheResonnanceSequence();
        matriceAlpha1.getListSequence().afficheSignalSequence();
        matriceAlpha1.afficheMesureEntre();
        matriceAlpha1.afficheMesureSortie();*/


    }


}
