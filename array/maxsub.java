package array;

import java.util.*;

public class maxsub {
    public static void PrintSub(int number[]) {
        int sum = Integer.MIN_VALUE;
        int prefix[] = new int[number.length];
        prefix[0] = 0;
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + number[i];
        }
        for (int i = 0; i < number.length; i++) {
            for (int j = i; j < number.length; j++) {
                int sm = 0;
                // for (int k = i; k <= j; k++) {
                // sm = sm + number[k];

                // }
                sm = i == 0 ? prefix[j] : prefix[j] - prefix[i - 1];

                if (sum < sm) {
                    sum = sm;
                }

            }

        }
        System.out.println("max of sub array=" + sum);

    }

    // System.out.println(Final);

    public static void kadance(int number[]) {
        int ms = Integer.MIN_VALUE;
        int cs = 0;
        for (int i = 0; i < number.length; i++) {
            cs = cs + number[i];
            if (cs < 0) {
                cs = 0;
            }
            ms = Math.max(cs, ms);
        }
        System.out.println("max of sub array=" + ms);
    }

    public static void main(String args[]) {
        int number[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
        PrintSub(number);
    }
}
