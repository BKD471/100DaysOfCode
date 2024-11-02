package Day5;

public class SingleNumberII {
    private boolean checkSetBit(int num, int bitPosition) {
        return ((num >> bitPosition) & 1) >= 1;
    }

    // O(n)
    public int singleNumber(final int[] nums) {
        int res = 0;
        for (int bitPosition = 0; bitPosition <= 31; bitPosition++) {
            int count = 0;
            for (int v : nums) {
                if (checkSetBit(v, bitPosition)) count++;
            }
            if (count % 3 > 0) res = (res | 1 << bitPosition);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 3, 3, 2, 2, 3, 1, 1};
        SingleNumberII singleNumberII = new SingleNumberII();
        int res = singleNumberII.singleNumber(nums);
        System.out.println(res);
    }
}
