import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by RAPHAEL on 02/11/2018.
 */
public class Main {
    public static void main(String[] args){
        Trigram triDico = new Trigram();
        triDico.lectureDico();
        Trigram triMot = new Trigram();

        //System.out.println("Taper mot a chercher :");
        //Scanner input = new Scanner(System.in);
        String billy = "mouton";
       // String mot = input.nextLine();

        triMot.lectureMot(billy);

        ArrayList<String> motsProches = new ArrayList<>(5);
        Comparator comparator = new Comparator(triDico, triMot, billy);
        motsProches = comparator.Compare();

        System.out.println(motsProches);

        LevenshteinDistance LID = new LevenshteinDistance();
        for(String m_mot : motsProches) {
            System.out.println("calc");
            System.out.println(LID.calculation(billy, m_mot));
        }
    }
}
