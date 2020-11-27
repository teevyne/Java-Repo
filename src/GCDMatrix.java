public class GCDMatrix {

    public static void main(String[] args) {

        int[] a = { 1, 2, 3 };
        int[] b = { 2, 4, 6 };

        mGcd(a, b);

    }

    public static void mGcd(int[] a, int[] b)
    {
        int[][] newAr = new int[a.length][b.length];

        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < b.length; j++)
            {
                newAr[i][j] = gcd(a[i], b[j]);
                System.out.printf("%d ", newAr[i][j]);
            }
            System.out.println();
        }
    }

    public static int gcd(int a, int b)
    {
        int gcd = 1;
        for (int i = 1; i <= b && i <= a; i++)
        {
            if (a % i == 0 && b % i == 0)
                gcd = i;
        }
        return gcd;
    }
}