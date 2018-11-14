import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by RAPHAEL on 02/11/2018.
 */
public class Trigram {

    public HashMap<String, HashSet<char[]>> triParMot = new HashMap<>();
    public HashMap<char[], HashSet<String>> motParTri = new HashMap<>();
    //public List<String> dictionnaire = new ArrayList<>();

    public Trigram(){
        lectureDico();
    }

    public void tri(String mot){
        decompositionTri(mot);
        //dictionnaire.add(mot);
    }

    public void lectureDico(){
        try{
            Scanner sc = new Scanner(new File("src/dico.txt"));
            while (sc.hasNext()) {
                tri(sc.next());
            }
        } catch (FileNotFoundException e){
            System.out.println(e);
        } catch (NoSuchElementException e) {
            System.out.println(e);
        }
    }

    public void lectureMot(String mot){
        tri(mot);
    }

    public void decompositionTri(String mot){
        HashSet<char[]> listeTri = new HashSet<>();
        String motChevron = "<" + mot + ">";
        char[] trigramme =  new char[3];
        for(int i = 0; i <= motChevron.length() - 3; i++){
            motChevron.getChars(i, i + 2, trigramme, 0);
            listeTri.add(trigramme);
            if(!motParTri.containsKey(trigramme)){
                HashSet<String> listeMot = new HashSet<>();
                listeMot.add(mot);
                motParTri.put(trigramme, listeMot);
            } else {
                HashSet<String> listeTmp = motParTri.get(trigramme);
                listeTmp.add(mot);
                motParTri.put(trigramme, listeTmp);
            }
        }
        triParMot.put(mot, listeTri);
    }
}
