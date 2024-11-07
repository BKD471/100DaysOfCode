package Day10;

public class SubArrayOR {
    // 1 ,2, 3, 4

    // 1 -> 0 0 1
    // 2 -> 0 1 0
    // 3 -> 0 1 1
    // 4 -> 1 0 0

//    [1]         0 0 1
//    [1,2]       0 1 1
//    [1,2,3]     0 1 1
//    [1,2,3,4]   1 1 1
//    [2]         0 1 0
//    [2,3]       0 1 1
//    [2,3,4]     1 1 1
//    [3]         0 1 1
//    [3,4]       1 1 1
//    [4]         1 0 0

// total bits              10
// unset bits     6 2 2
// set bits       4 8 8

    // sum           4*2^2+8*2^1+8*2^0=4*4+8*2+8=16+16+8=40

    private boolean checkUnSetBit(int num, int bitPosition) {
        return ((num >> bitPosition) & 1) == 0;
    }

    public int solve(int[] nums) {
        int n = nums.length;
        long totalSubArrays = (((long) n * ((long) n + 1)) / 2);

        long sum = 0;
        for (int bitPosition = 0; bitPosition <= 31; bitPosition++) {
            long countOfContiguousUnsetBits = 0;
            long countOfSubArraysWithUnsetBits = 0;
            for (int v : nums) {
                if (checkUnSetBit(v, bitPosition)) {
                    countOfContiguousUnsetBits++;
                } else {
                    countOfSubArraysWithUnsetBits += (countOfContiguousUnsetBits * (countOfContiguousUnsetBits + 1)) / 2;
                    countOfContiguousUnsetBits = 0;
                }
            }
            countOfSubArraysWithUnsetBits += (countOfContiguousUnsetBits * (countOfContiguousUnsetBits + 1)) / 2;
            long countOfSubArraysWithSetBits = totalSubArrays - countOfSubArraysWithUnsetBits;
            long product = countOfSubArraysWithSetBits * (1 << bitPosition);
            sum = (sum + product);
        }
        return (int) (sum % 1000000007);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        SubArrayOR solver = new SubArrayOR();
        int res = solver.solve(nums);
        System.out.println(res);
    }
}
