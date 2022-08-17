package array;

import java.util.*;

public class traprainwater {
    public static void water(int number[]) {
        int n = number.length;
        int left[] = new int[n];
        int right[] = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {

            sum = Math.max(sum, number[i]);
            left[i] = sum;
        }
        int sum2 = 0;
        for (int i = n - 1; i >= 0; i--) {

            sum2 = Math.max(sum2, number[i]);
            right[i] = sum2;
        }
        int Final[] = new int[n];
        int sum3 = 0;
        int sun = 0;
        for (int i = 0; i < n; i++) {
            Final[i] = Math.min(left[i], right[i]);
            sum3 += Final[i] - number[i];
        }

        System.out.println("the Total of water contain=" + sum3);
    }

    public static void main(String args[]) {
        int number[] = { 4, 2, 0, 6, 3, 2, 5 };
        water(number);
    }
}
