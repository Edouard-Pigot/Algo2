import java.util.ArrayList;
import java.util.HashMap;



public class Comparator {
    public Trigram triDico;
    public Trigram triMot;
    public String mot;
    public HashMap<String, Integer> occurenceMot = new HashMap<>();
    public ArrayList<String> motsProches = new ArrayList<>(5);

    public Comparator(Trigram triDico, Trigram triMot, String mot){
        this.triDico = triDico;
        this.triMot = triMot;
        //this.mot = "<" + mot + ">";
        this.mot =  mot ;
    }

    public ArrayList<String> Compare(){
        System.out.println(triMot.trigrammesDesMots);
        System.out.println(triMot.trigrammesDesMots.get(mot));
        //System.out.println(triMot.trigrammesDesMots.keySet().contains(mot));
        if(triMot.trigrammesDesMots.keySet().contains(mot)) {

            for (String tri : triMot.trigrammesDesMots.get(mot)) {

                //System.out.println(tri);
                if (!triDico.motsDesTrigrammes.containsKey(tri)) continue;
                for (String mot : triDico.motsDesTrigrammes.get(tri)) {
                    // System.out.println(tri);
                    if (!occurenceMot.containsKey(mot)) {
                        occurenceMot.put(mot, 1);
                    } else {
                        occurenceMot.put(mot, occurenceMot.get(mot) + 1);
                    }
                }
            }
            int i = 0;
            for (HashMap.Entry<String, Integer> entry : occurenceMot.entrySet()) {
                boolean getOut = false;
                System.out.println(motsProches);
                System.out.println(motsProches.get(0));
                if (motsProches.get(0) == "") {
                    motsProches.add(0, entry.getKey());
                } else {
                    for (String mot : motsProches) {
                        if (entry.getValue() > occurenceMot.get(mot)) {
                            motsProches.add(i, entry.getKey());
                            getOut = true;
                        }
                        if (getOut) {
                            break;
                        }
                        i++;
                    }
                }
            }

        }
        return motsProches;
    }
}
