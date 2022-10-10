package dp;

import java.util.*;

public class partionssumdiffernce {
    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4 };
        int n = arr.length;
        int totalsum = 0;
        for (int q = 0; q < n; q++)
            totalsum += arr[q];

        int k = totalsum;
        // boolean[][] dp = new boolean[n][k + 1];

        // for (int i = 0; i < n; i++) {
        // dp[i][0] = true;

        // }
        // if (arr[0] <= k)
        // dp[0][arr[0]] = true;

        // for (int ind = 1; ind < n; ind++) {
        // for (int target = 1; target <= k; target++) {

        // boolean nottake = dp[ind - 1][target];
        // boolean take = false;
        // if (target >= arr[ind])
        // take = dp[ind - 1][target - arr[ind]];
        // dp[ind][target] = nottake || take;

        // }
        // }
        // int maxi = 99999999;
        // for (int s1 = 0; s1 <= totalsum; s1++) {
        // if (dp[n - 1][s1] == true) {

        // maxi = Math.min(maxi, Math.abs((totalsum - s1) - s1));

        // }

        // }
        // System.out.println(maxi);

        boolean[] prev = new boolean[k + 1];

        for (int i = 0; i < n; i++) {
            prev[0] = true;

        }
        if (arr[0] <= k)
            prev[arr[0]] = true;

        for (int ind = 1; ind < n; ind++) {
            boolean[] curi = new boolean[k + 1];
            curi[0] = true;
            for (int target = 1; target <= k; target++) {

                boolean nottake = prev[target];
                boolean take = false;
                if (target >= arr[ind])
                    take = prev[target - arr[ind]];
                curi[target] = nottake || take;

            }
            prev = curi;
        }
        int maxi = 99999999;
        for (int s1 = 0; s1 <= totalsum; s1++) {
            if (prev[s1] == true) {

                maxi = Math.min(maxi, Math.abs((totalsum - s1) - s1));

            }

        }
        System.out.println(maxi);
    }
}