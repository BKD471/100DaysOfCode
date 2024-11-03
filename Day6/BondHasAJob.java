package Day6;

import java.util.Arrays;

public class BondHasAJob {
    public int[] bondHasAJobBrute(int[] nums, int k) {
        // 1 1 2 2 3
        // 2 2 2 2 3     occurrence=4,minvalue=2  -> [4,2]
        int n = nums.length;
        Arrays.sort(nums);

        int[] res = new int[2];
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            int count = 0;
            int ops = k;
            while (j >= 0 && nums[i] - nums[j] <= ops) {
                count++;
                ops -= (nums[i] - nums[j]);
                j--;
            }
            if (count > maxCount) {
                maxCount = count;
                res[0] = maxCount;
                res[1] = nums[i];
            }
        }
        return res;
    }

    private long[] ps;

    private boolean canAdd(int[] nums, int index, int optimalNumberToIncrement, int k) {
        int start = index - optimalNumberToIncrement;
        long sum = (start >= 0) ? ps[index] - ps[start] : ps[index];
        return optimalNumberToIncrement * (long) nums[index] - sum <= k;
    }

    public int[] bondHasAJob(int[] nums, int k) {
        // 3 1 2 2 1
        // 3 2 2 2 2
        int n = nums.length;
        if (n == 0) return new int[]{};

        Arrays.sort(nums);
        this.ps = new long[n];
        this.ps[0] = nums[0];
        for (int i = 1; i < n; i++) ps[i] = ps[i - 1] + nums[i];

        int[] res = new int[2];
        int maxCount = 0;
        for (int index = 1; index < n; index++) {
            int leastNumberToIncrement = 1, highestNumberToIncrement = index + 1;
            int best = -1;
            while (leastNumberToIncrement <= highestNumberToIncrement) {
                int optimalNumberToIncrement =
                        leastNumberToIncrement + (highestNumberToIncrement - leastNumberToIncrement) / 2;
                if (canAdd(nums, index, optimalNumberToIncrement, k)) {
                    best = optimalNumberToIncrement;
                    leastNumberToIncrement = optimalNumberToIncrement + 1;
                } else highestNumberToIncrement = optimalNumberToIncrement - 1;
            }
            if (best > maxCount) {
                maxCount = best;
                res[0] = maxCount;
                res[1] = nums[index];
            }

        }
        return res;
    }
}
