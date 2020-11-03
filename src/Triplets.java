import java.util.Arrays;
import java.util.List;

public class Triplets {

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {

        int countA = 0;
        int countB = 0;
//        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < a.size(); i++){
//            while (a.get(i) != b.get(i)){
                if (a.get(i) > b.get(i)){
                    countA++;
                }
                else{
                    countB++;
                }
            }

//        result.add(countA);
//        result.add(countB);
//
//        return result;

        return Arrays.asList(countA, countB);
    }
}
