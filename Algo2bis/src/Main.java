import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try
        {
            File f = new File ("Algo2/Algo2bis/src/dico.txt");
            FileReader fr = new FileReader (f);
            BufferedReader br = new BufferedReader (fr);

            try
            {
                String line = br.readLine();

                while (line != null)
                {
                    System.out.println (line);
                    line = br.readLine();
                }

                br.close();
                fr.close();
            }
            catch (IOException exception)
            {
                System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
            }
        }
        catch (FileNotFoundException exception)
        {
            System.out.println ("Le fichier n'a pas été trouvé");
        }
    }
}
