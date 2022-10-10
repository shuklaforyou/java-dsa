package dp;

public class targetsum {
    static int findWays(int[] num, int tar) {
        int n = num.length;

        int prev[] = new int[tar + 1];

        if (num[0] == 0)
            prev[0] = 2; // 2 cases -pick and not pick
        else
            prev[0] = 1; // 1 case - not pick

        if (num[0] != 0 && num[0] <= tar)
            prev[num[0]] = 1; // 1 case -pick

        for (int ind = 1; ind < n; ind++) {
            int cur[] = new int[tar + 1];
            for (int target = 0; target <= tar; target++) {
                int notTaken = prev[target];

                int taken = 0;
                if (num[ind] <= target)
                    taken = prev[target - num[ind]];

                cur[target] = (notTaken + taken);
            }
            prev = cur;
        }
        return prev[tar];
    }

    static int stargetSum(int n, int target, int[] arr) {
        int totSum = 0;
        for (int i = 0; i < n; i++) {
            totSum += arr[i];
        }

        // Checking for edge cases
        if (totSum - target < 0 || (totSum - target) % 2 == 1)
            return 0;

        return findWays(arr, (totSum - target) / 2);
    }

    public static int targetSum(int n, int target, int[] arr) {
        // Write your code here.
        return stargetSum(n, target, arr);

    }
}
