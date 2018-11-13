import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by RAPHAEL on 02/11/2018.
 */
public class Main {
    public static void main(String[] args){
        try{
            List<String> dictionnaire = new ArrayList<>(500000);
            Scanner sc = new Scanner(new File("src/dico.txt"));
            while (sc.hasNext()) {
                dictionnaire.add(sc.next());
            }
            LevenshteinDistance LID = new LevenshteinDistance();
            System.out.println(LID.calculation("coucou", "salut"));
        } catch (FileNotFoundException e){
            System.out.println(e);
        } catch (NoSuchElementException e){
            System.out.println(e);
        }
    }
}
