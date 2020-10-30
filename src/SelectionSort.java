
import java.util.Arrays;

public class SelectionSort {

    public static String doSort(int[] a) {
        int temp = 0;

        for (int i = 0; i < a.length; i++) {
            int min = i;

            for (int j = i + 1; j < a.length; j++) {
                if(a[min] > a[j]) {
                    min = j;
                }
            }

            temp = a[min];
            a[min] = a[i];
            a[i] = temp;
        }

        return Arrays.toString(a);
    }

    public static void main(String[] args) {

        double start = System.currentTimeMillis();
        int[] a = { 64, 25, 12, 22, 11, 88, 9, 5, 43, 0, 4, 14, 23 };

        System.out.println(doSort(a));

        double end = System.currentTimeMillis();
        System.out.printf("%n%.5f", (end - start)/1000);

    }
}
