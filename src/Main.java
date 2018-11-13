import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by RAPHAEL on 02/11/2018.
 */
public class Main {
    public static void main(String[] args){
        try{
            List<String> dictionnaire = new ArrayList<>();
            Scanner sc = new Scanner(new File("src/dico.txt"));
            while (sc.hasNext()) {
                dictionnaire.add(sc.next());

                //System.out.println(sc.next());
            }
            System.out.println(dictionnaire);
        } catch (FileNotFoundException e){
            System.out.println(e);
        }


        System.out.println("Ca marche ?");

    }


}
