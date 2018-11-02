import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by RAPHAEL on 02/11/2018.
 */
public class Main {
    public static void main(String[] args){
        try{
            Scanner sc = new Scanner(new File("src/dico.txt"));
            while (sc.hasNext()) {
                System.out.println(sc.next());
            }
        } catch (FileNotFoundException e){
            System.out.println(e);
        }


        System.out.println("Ca marche ?");

    }


}
