import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinMixSum {

//    public static void miniMaxSum(int[] arr) {
//
//        int minSum = 0;
//        int maxSum = 0;
//
//        sort(arr);
//        System.out.println(Arrays.toString(arr));
//
//        for (int i = 0; i < arr.length - 1; i++){
//            minSum += arr[i];
//        }
//        for (int j = 1; j < arr.length; j++){
//            maxSum += arr[j];
//        }
//        System.out.printf("%d %d", minSum, maxSum);
//    }
//
//    public static void sort(int arr[])
//    {
//        int n = arr.length;
//
//        for (int i = 0; i < n-1; i++)
//        {
//            // Find the minimum element in unsorted array
//            int min_idx = i;
//            for (int j = i+1; j < n; j++)
//                if (arr[j] < arr[min_idx])
//                    min_idx = j;
//
//            int temp = arr[min_idx];
//            arr[min_idx] = arr[i];
//            arr[i] = temp;
//        }
//    }
//
//    public static void main(String[] args) {
//
//        int[] array = { 7, 6, 3, 4, 5 };
//        miniMaxSum(array);
//    }

    static void miniMaxSum(int[] arr) {

        Arrays.sort(arr);
        long min = 0, max = 0;
        for(int i = 0, j = arr.length - 1; i < arr.length - 1; i++, j--){
            max = max + arr[j];
            min = min + arr[i];
        }
        System.out.println(min + " " + max);
    }

    public static void sumArray(int[] arr){
        Arrays.sort(arr);

        long min = 0, max = 0;
        for (int i = 0, j = arr.length -1; i < arr.length - 1; i++, j--){
            max = max + arr[j];
            min = min + arr[i];
        }
        System.out.println(min + " " + max);
    }
}
