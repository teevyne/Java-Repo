public class QuickSort {

    public static void quickSort(int[] anArray){
        for (int i = 0; i < anArray.length; i++){
            int pivot = anArray[0];

            for (int j = i + 1; j < anArray.length; j++){

            }
        }
    }

    public static void swap(int[] anArray, int i, int j) {
        int temp = anArray[i];
        anArray[i] = anArray[j];
        anArray[j] = temp;
    }

    public static void printArray(int[] anArray) {
        for (int num : anArray){
            System.out.println(num + " ");
        }
        System.out.println();
    }
}
