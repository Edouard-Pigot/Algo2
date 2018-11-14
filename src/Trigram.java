import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by RAPHAEL on 02/11/2018.
 */
public class Trigram {

    public HashMap<String,  HashSet<char[]>> trigrammesDesMots = new HashMap<>();
    public HashMap<char[], HashSet<String>> motsDesTrigrammes = new HashMap<>();
    //public List<String> dictionnaire = new ArrayList<>();

    public Trigram(){}

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
            motChevron.getChars(i, i + 3, trigramme, 0);
            listeTri.add(trigramme);
            if(!motsDesTrigrammes.containsKey(trigramme)){
                HashSet<String> listeMot = new HashSet<>();
                listeMot.add(mot);
                motsDesTrigrammes.put(trigramme, listeMot);
            } else {
                HashSet<String> listeTmp = motsDesTrigrammes.get(trigramme);
                listeTmp.add(mot);
                motsDesTrigrammes.put(trigramme, listeTmp);
            }
        }
        trigrammesDesMots.put(mot, listeTri);

    }

   /* "<coucou>"
    "<co"
    "cou"
    "ouc"
    "uco"
    "ou>"
    "<co" "coucou" "content"
    "courge" "<co" "cou" "our" "rge" "ge>"

    "coucou / salut / concours / con / cailloux"
    "coucou" "<co" "cou" "ouc" "uco" "ou>"
    "salut"  "<sa" "sal" "alu" "lut" "ut>"
    "concours" "<co" "con" "onc" "nco" "cou" "our" "urs" "rs>"
    "con" "<co" "con" "co>"
    "cailloux" "<ca" "cai" "ail" "ill" "llo" "lou" "oux" "ux>"

    "<co" "coucou" "concours" "con"

    "coucou" "concours" "con"
    2         3         1*/

}
