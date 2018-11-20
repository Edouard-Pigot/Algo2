import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by RAPHAEL on 02/11/2018.
 */
public class Main {
    public static void main(String[] args){
        long tempsDepart = System.nanoTime();
        Trigram triDico = new Trigram();
        triDico.lectureDico();
        //System.out.println("Taper mot a chercher :");
        //Scanner input = new Scanner(System.in);
       // String mot = input.nextLine();

        try{
            Scanner sc = new Scanner(new File("src/fautes.txt"));
            while (sc.hasNext()) {
                String mot = sc.next();
                Trigram triMot = new Trigram();
                triMot.lectureMot(mot);
                ArrayList<String> motsProches = new ArrayList<>(5);
                Comparator comparator = new Comparator(triDico, triMot, mot);
                motsProches = comparator.Compare();
                LevenshteinDistance LID = new LevenshteinDistance();
                System.out.println("Pour le mot " + mot + ", les correspondances sont :");
                String str = "";
                for(String m_mot : motsProches) {
                    str += m_mot + ",";
                }
                System.out.println(str);
                String dst = "";
                for(String m_mot : motsProches) {
                    dst += LID.calculation(mot, m_mot) + ",";
                }
                System.out.println(dst);
                System.out.println("\n");
            }
        } catch (FileNotFoundException e){
            System.out.println(e);
        } catch (NoSuchElementException e) {
            System.out.println(e);
        }
        long tempsEcoule = System.nanoTime() - tempsDepart;
        double seconds = (double)tempsEcoule / 1_000_000_000.0;
        System.out.println(seconds);
    }
}