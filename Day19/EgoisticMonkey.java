package Day19;

public class EgoisticMonkey {
    private static final int LIMIT = (int) (Math.pow(10, 7));

    // O(2^n) for every index two choice
    //  1) jump to i+1
    //  2) jump to i+2
    private int minCost(int[] nums, int index, int n, int B, int C) {
        if (index >= n - 1) return 0;

        // jump to i+1
        int cost1 = LIMIT;
        if (index + 1 < n) {
            cost1 = B * Math.abs(nums[index + 1] - nums[index])
                    + minCost(nums, index + 1, n, B, C);
        }

        // jump to i+2
        int cost2 = LIMIT;
        if (index + 2 < n) {
            cost2 = C * Math.abs(nums[index + 2] - nums[index])
                    + minCost(nums, index + 2, n, B, C);
        }

        return Math.min(cost1, cost2);

    }

    public int solve(int[] nums, int B, int C) {
        int n = nums.length;
        return minCost(nums, 0, n, B, C);
    }
}
