import java.util.List;

/**
 * Created by RAPHAEL on 02/11/2018.
 */
public class LevenshteinDistance {

    public LevenshteinDistance() {
    }

    public int calculation(String falseString, String trueString) {
        int distance[][] = new int[falseString.length()+1][trueString.length()+1];
        int costSub;
        for (int i= 0 ; i <= falseString.length();++i){
            distance[i][0] = i;
        }
        for(int j=0; j <= trueString.length();++j){
            distance[0][j] = j;
        }

        for (int i = 1 ; i <= falseString.length();++i){
            for(int j= 1 ; j<=trueString.length();++j){
                if(falseString.charAt(i-1) == trueString.charAt(j-1)){
                    costSub = 0;
                } else {
                    costSub = 1;
                }

                int min1= Math.min(distance[i-1][j]+1,distance[i][j-1]+1);
                int min2 = Math.min(min1,distance[i-1][j-1]+costSub);
                distance[i][j] = min2;



            }
        }
        return distance[falseString.length()][trueString.length()];

    }
//
//    public String insert(String falseString, String trueString){
//        for(int i = 0; i < falseString.length();++i) {
//            for (int j = 0; j < trueString.length(); ++j) {
//                if(falseString.charAt(i) != trueString.charAt(j)){
//                    falseString = trueString.charAt(j) + falseString;
//                    i = 0;
//                    j=0;
//                    return  falseString;
//                }
//            }
//        }
//        return  falseString;
//
//    }
//
//    public String suppr(String falseString, String trueString){
//        for(int i = 0; i < falseString.length();++i) {
//            for (int j = 0; j < trueString.length(); ++j) {
//                if(falseString.charAt(i) != trueString.charAt(j)){
//                    falseString ;
//                    i = 0;
//                    j=0;
//                    return  falseString;
//                }
//            }
//        }
//        return falseString;
//    }

}
