package dp;

import java.util.*;

import java.util.*;

class tuf {
    static int unboundedKnapsack(int n, int W, int[] val, int[] wt) {

        int cur[] = new int[W + 1];

        // Base Condition
        for (int i = 0; i <= W; i++) {
            cur[i] = ((int) i / wt[0]) * val[0];
        }

        for (int ind = 1; ind < n; ind++) {
            for (int cap = 0; cap <= W; cap++) {

                int notTaken = cur[cap];

                int taken = Integer.MIN_VALUE;
                if (wt[ind] <= cap)
                    taken = val[ind] + cur[cap - wt[ind]];

                cur[cap] = Math.max(notTaken, taken);
            }
        }

        return cur[W];

    }

    public static void main(String args[]) {

        int wt[] = { 7, 2, 4 };
        int val[] = { 5, 10, 20 };
        int W = 15;

        int n = wt.length;

        System.out.println(unboundedKnapsack(n, W, val, wt));
    }
}