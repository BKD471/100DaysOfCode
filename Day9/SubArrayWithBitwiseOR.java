package Day9;

public class SubArrayWithBitwiseOR {
    // O(n)
    public long solve(int n, int[] nums) {
        // 1 0 1
        // 1          1
        // 0          0
        // 1          1
        // 1 0        1
        // 1 0 1      1
        //   0 1      1

        //1 1 1
        //   1
        //   1 1
        //   1 1 1
        //     1
        //     1 1
        //       1

        // 0 1 2 3 4
        // 0 1 1 0 1
        //         1

        //

        int count = 0;
        int lastFoundOne = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] == 1) {
                count += (n - i);
                lastFoundOne = i;
            } else if (nums[i] == 0 && lastFoundOne != -1) {
                count += (n - lastFoundOne);
            }
        }
        return count;
    }

    // Second Approach
    // O(n)
    public long solveAnotherApproach(int n, int[] nums) {
        long totalCountOfSubArrays = (((long) n * ((long) n + 1)) / 2);
        long totalCountOfSubArraysWithZeros = 0;
        long countOfContiguousZeros = 0;
        for (int v : nums) {
            if (v == 0) countOfContiguousZeros++;
            else {
                totalCountOfSubArraysWithZeros += ((countOfContiguousZeros * (countOfContiguousZeros + 1)) / 2);
                countOfContiguousZeros = 0;
            }
        }
        totalCountOfSubArraysWithZeros += ((countOfContiguousZeros * (countOfContiguousZeros + 1)) / 2);
        return totalCountOfSubArrays - totalCountOfSubArraysWithZeros;
    }

    public static void main(String[] args) {
        SubArrayWithBitwiseOR subArrayWithBitwiseOR = new SubArrayWithBitwiseOR();
        int[] nums = {0, 1, 1, 0, 1};
        long res = subArrayWithBitwiseOR.solve(nums.length, nums);
        System.out.println(res);
    }
}
