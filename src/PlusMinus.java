public class PlusMinus {

    public static void plusMinus(int[] arr) {

        double positive = 0;
        double negative = 0;
        double zero = 0;

        for (int i = 0; i < arr.length; i++){
            if (arr[i] > 0){
                positive++;
            }
            else if (arr[i] < 0){
                negative++;
            }
            else{
                zero++;
            }
        }

        System.out.printf("%.6f%n%.6f%n%.6f%n", positive/arr.length, negative/arr.length, zero/arr.length);
    }

//    public static void main(String[] args) {
//        int[] arr = { -4, 3, -9, 0, 4, 1 };
//
//        System.out.println(plusMinus(arr));
//    }
}
