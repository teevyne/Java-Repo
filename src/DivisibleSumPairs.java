public class DivisibleSumPairs {

    public static int divisiblePairs(int[] array, int k) {
        int counter = 0;

        for (int i = 0; i < array.length - 1; i++){
            for (int j = i + 1; j < array.length; j++){
                if((array[i] + array[j]) % k == 0){
                    System.out.printf("(%d, %d)%n", i, j);
                    counter++;
                }
            }
        }
        return counter;
    }


    public static void main(String[] args) {

        int[] anArray = {1, 3, 2, 6, 1, 2};
        System.out.println(divisiblePairs(anArray, 3));
    }
}
