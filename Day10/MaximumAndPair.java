package Day10;

public class MaximumAndPair {
    private boolean checkSetBits(int nums, int bitPosition) {
        return ((nums >> bitPosition) & 1) == 1;
    }

    // O(31*n) ~ O(n)
    public int solve(int[] nums) {
        int res = 0;
        for (int bitPosition = 31; bitPosition >= 0; bitPosition--) {
            int countOfSetBits = 0;
            for (int v : nums) {
                if (checkSetBits(v, bitPosition)) countOfSetBits++;
            }

            if (countOfSetBits >= 2) {
                res = (res | 1 << bitPosition);
                for (int i = 0; i < nums.length; i++) {
                    if (!checkSetBits(nums[i], bitPosition)) nums[i] = 0;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4, 8, 12, 16};
        MaximumAndPair maximumAndPair = new MaximumAndPair();
        int res = maximumAndPair.solve(nums);
        System.out.println(res);
    }
}
