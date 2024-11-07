package Day10;

public class MaximumOrPair {
    private boolean checkSetBits(int nums, int bitPosition) {
        return ((nums >> bitPosition) & 1) == 1;
    }

    public int solve(int[] nums) {
        int res = 0;
        for (int bitPosition = 31; bitPosition >= 0; bitPosition--) {
            int countOfSetBits = 0;
            for (int v : nums) {
                if (checkSetBits(v, bitPosition)) countOfSetBits++;
            }

            if (countOfSetBits >= 1) {
                res = (res | 1 << bitPosition);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4, 8, 12, 16};
        MaximumOrPair maximumORPair = new MaximumOrPair();
        int res = maximumORPair.solve(nums);
        System.out.println(res);
    }
}
