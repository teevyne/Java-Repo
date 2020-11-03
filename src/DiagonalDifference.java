public class DiagonalDifference {

    public static int diagonalDifference(int[][] arr) {

        int rightDiagonalSum = 0;
        int leftDiagonalSum = 0;

        for (int i =0 ; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                if (i == j){
//                    System.out.println(arr[i][j]);
                    rightDiagonalSum += arr[i][j];

                }
                if ( i == arr.length - j - 1){
//                    System.out.println(arr[i][j]);
                    leftDiagonalSum += arr[i][j];
                }
            }
        }

//        System.out.printf("%d%n%d%n", rightDiagonalSum, leftDiagonalSum);

        return Math.abs(rightDiagonalSum - leftDiagonalSum);
    }

    public static void main(String[] args) {
        int[][] array = { { 11, 2, 4}, { 4, 5, 6 }, { 10, 8, -12}};

        System.out.println(diagonalDifference(array));
    }
}

// The above code ran very well, only issue, I could not work with 2-dim lists yet
// So I sought to solve it in python

//    def diagonalDifference(arr):
//        d1 = 0
//        d2 = 0
//
//        for i in range(len(arr)):
//        for j in range(len(arr)):
//        if i == j:
//        d1 += arr[i][j]
//        if i == len(arr) - j -1:
//        d2 += arr[i][j]
//        return abs(d1 - d2)
