import java.util.List;

public class LargeSums {

    static long aVeryBigSum(long[] ar) {

        long sum = 0;

        for (int i = 0; i < ar.length; i++){
            sum += ar[i];
        }

        return sum;
    }
}
