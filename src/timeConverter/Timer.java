package timeConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Timer{

    public  static String quickSort(int[] arr){

        List<Integer> left = new ArrayList<>();
        List<Integer> equaler = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        int pivot = 0;

        for (int i = 0; i < arr.length; i++){
            pivot = arr[0];

            if (arr[i] == pivot){
                equaler.add(arr[i]);
            }
            else if(arr[i] < pivot){
                left.add(arr[i]);
            }
            else if (arr[i] > pivot) {
                right.add(arr[i]);
            }
        }

        result.addAll(left);
        result.addAll(equaler);
        result.addAll(right);

        Collections.sort(result);

        Integer[] resultArray = new Integer[result.size()];
        resultArray = result.toArray(resultArray);

        return Arrays.toString(resultArray);
    }

    public static void main(String[] args) {

        int[] arr = { 5, 4, 5, 6, 7, 5, 9, 5, 3, 10, 4, 7, 2 };

        System.out.println(quickSort(arr));
    }
}