import java.util.*;

public class PA2 {
    /* recursive function */
    public static int solve(int[] carOrder) {
        int n = carOrder.length;
        /* base case */
        if (n == 1) {
            return 0;
        }
        /* divide */
        int midpoint = n / 2;
        int[] left = new int[midpoint];
        int[] right = new int[n - midpoint];
        for (int i = 0; i < midpoint; i++) {
            left[i] = carOrder[i];
        }
        for (int i = midpoint; i < n; i++) {
            right[i - midpoint] = carOrder[i];
        }
        int leftInversions = solve(left);
        int rightInversions = solve(right);
        int crossInversions = conquer(left, right, carOrder);
        return leftInversions + rightInversions + crossInversions;
    }

    private static int conquer(int[] left, int[] right, int[] array) {
        int leftSize = left.length;
        int rightSize = right.length;
        int i = 0;
        int l = 0;
        int r = 0;
        int inversion = 0;
        while (l < leftSize && r < rightSize) {
            if (left[l] <= right[r]) {
                array[i] = left[l];
                i++;
                l++;
            } else {
                array[i] = right[r];
                inversion = inversion + (leftSize - l);
                i++;
                r++;
            }
        }
        while (l < leftSize) {
            array[i] = left[l];
            l++;
            i++;
        }
        while (r < rightSize) {
            array[i] = right[r];
            r++;
            i++;
        }
        return inversion;
    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int test_cases = stdin.nextInt();
        stdin.nextLine();
        for (int i = 0; i < test_cases; i++) {
            String line = stdin.nextLine();
            Scanner lineScanner = new Scanner(line);
            int n = lineScanner.nextInt();
            int[] carOrders = new int[n];
            int j = 0;
            while (lineScanner.hasNextInt()) {
                carOrders[j] = lineScanner.nextInt();
                j++;
            }
            System.out.println(solve(carOrders));
        }
    }
}
