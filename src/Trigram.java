import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.text.Normalizer;
import java.util.regex.Pattern;

/**
 * Created by RAPHAEL on 02/11/2018.
 */
public class Trigram {

    public HashMap<String,  ArrayList<String>> trigrammesDesMots = new HashMap<>();
    public HashMap<String, ArrayList<String>> motsDesTrigrammes = new HashMap<>();
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
        ArrayList<String> listeTri = new ArrayList<>();
        /*String temp = Normalizer.normalize(mot, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        mot = pattern.matcher(temp).replaceAll("");*/
        String motChevron = "<" + mot + ">";
        String trigramme = "" ;
       // char[] trigramme = new char[3];
        //trigramme.substring(0,3);
        //System.out.println(trigramme.toCharArray());
        for(int i = 0; i <= motChevron.length() - 3; ++i){
           // motChevron.getChars(i, i + 3, trigramme.toCharArray() , 0);
            trigramme = motChevron.substring(i, i+3);
            listeTri.add(trigramme);
            if(!motsDesTrigrammes.containsKey(trigramme)){
                ArrayList<String> listeMot = new ArrayList<>();
                listeMot.add(mot);
                motsDesTrigrammes.put(trigramme, listeMot);
            } else {
                ArrayList<String> listeTmp = motsDesTrigrammes.get(trigramme);
                listeTmp.add(mot);
                motsDesTrigrammes.put(trigramme, listeTmp);
                //System.out.println(motsDesTrigrammes);
            }
        }
        trigrammesDesMots.put(mot, listeTri);
        //System.out.println(trigrammesDesMots);
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
