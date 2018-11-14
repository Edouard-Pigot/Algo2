import java.util.HashMap;

public class Comparator {
    public Trigram triDico;
    public Trigram triMot;
    public String mot;
    public HashMap<String, Integer> occurenceMot = new HashMap<>();

    public Comparator(Trigram triDico, Trigram triMot, String mot){
        this.triDico = triDico;
        this.triMot = triMot;
        this.mot = mot;
    }

    public void Compare(){
        for(char[] tri : triMot.triParMot.get(mot)){
            for(String mot : triDico.motParTri.get(tri)){
                if(!occurenceMot.containsKey(mot)){
                    occurenceMot.put(mot, 1);
                } else {
                    occurenceMot.put(mot, occurenceMot.get(mot) + 1);
                }
            }
        }
    }
}
