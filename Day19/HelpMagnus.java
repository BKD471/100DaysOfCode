package Day19;

public class HelpMagnus {
    private static final int LIMIT = (int) (Math.pow(10, 9) + 7);

    private void swap(int[] nums, int l, int h) {
        int t = nums[l];
        nums[l] = nums[h];
        nums[h] = t;
    }

    // O(n)
    public int solve(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int negativeNumbersIndex = 0;
        for (int index = 0; index < n; index++) {
            if (nums[index] < 0) {
                swap(nums, negativeNumbersIndex, index);
                negativeNumbersIndex++;
            }
        }

        long negativeSum = 0;
        for (int index = 0; index < negativeNumbersIndex; index++) negativeSum += nums[index];

        long positiveSum = 0;
        for (int index = negativeNumbersIndex; index < n; index++) positiveSum += nums[index];


        long product1 = ((negativeSum % LIMIT) * (negativeSum % LIMIT)) % LIMIT;
        long product2 = ((positiveSum % LIMIT) * (positiveSum % LIMIT)) % LIMIT;
        long result = product1 + product2;
        return (int) (result % LIMIT);
    }
}
