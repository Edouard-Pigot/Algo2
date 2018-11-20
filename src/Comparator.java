import java.util.ArrayList;
import java.util.HashMap;



public class Comparator {
    public Trigram triDico;
    public Trigram triMot;
    public String mot;
    public HashMap<String, Integer> occurenceMot = new HashMap<>();
    public ArrayList<String> motsProches = new ArrayList<>(5);
    public ArrayList<Integer> motsProchesNb = new ArrayList<>(5);

    public Comparator(Trigram triDico, Trigram triMot, String mot){
        this.triDico = triDico;
        this.triMot = triMot;
        //this.mot = "<" + mot + ">";
        this.mot =  mot ;
    }

    public ArrayList<String> Compare(){
        /*System.out.println(triMot.trigrammesDesMots);
        System.out.println(triMot.trigrammesDesMots.get(mot));*/
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
            for (HashMap.Entry<String, Integer> entry : occurenceMot.entrySet()) {
                if (motsProches.isEmpty()) {
                    motsProches.add(0, entry.getKey());
                    motsProchesNb.add(0, entry.getValue());
                } else {
                    for (String mot : motsProches) {
                        if (entry.getValue() > occurenceMot.get(mot)) {
                            if(motsProches.size() >= 5) {
                                motsProches.remove(0);
                                motsProchesNb.remove(0);
                            }
                            motsProches.add(entry.getKey());
                            motsProchesNb.add(entry.getValue());
                            for(int i = motsProches.size() - 1; i <= motsProches.size() - 1; i--){
                                boolean trier = true;
                                for(int j = 0; j <= i - 1; j++){
                                    if(occurenceMot.get(motsProches.get(j+1)) < occurenceMot.get(motsProches.get(j))){
                                        String tmp = motsProches.get(j+1);
                                        motsProches.set(j+1, motsProches.get(j));
                                        motsProches.set(j, tmp);
                                        int tmpNb = motsProchesNb.get(j+1);
                                        motsProchesNb.set(j+1, motsProchesNb.get(j));
                                        motsProchesNb.set(j, tmpNb);
                                        trier = false;
                                    }
                                }
                                if(trier){
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }
            }

        }
        /*System.out.println(motsProches);
        System.out.println(motsProchesNb);*/
        return motsProches;
    }
}
