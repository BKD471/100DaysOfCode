package Day1;

import java.util.Arrays;

public class MaximumSubmatrixSum {
    // Brute Force O(n^6)
    private long solveBrute(int[][] nums) {
        int rows = nums.length;
        if (rows == 0) return 0;
        int cols = nums[0].length;

        long maxSum = Long.MIN_VALUE;
        for (int r1 = 0; r1 < rows; r1++) {
            for (int c1 = 0; c1 < cols; c1++) {
                //top left (r1,c1)
                for (int r2 = r1; r2 < rows; r2++) {
                    for (int c2 = c1; c2 < cols; c2++) {
                        // bottom right (r2,c2)

                        int subMatrixSum = 0;
                        for (int row = r1; row <= r2; row++) {
                            for (int col = c1; col <= c2; col++) {
                                subMatrixSum += nums[row][col];
                                // O(n^6)
                            }
                        }
                        maxSum = Math.max(maxSum, subMatrixSum);
                    }
                }
            }
        }
        return maxSum;
    }

    // Little Better O(n^4)
    private long solveBetterWay(int[][] nums) {
        int rows = nums.length;
        if (rows == 0) return 0;
        int cols = nums[0].length;

        long[][] ps = new long[rows][cols];

        // row wise prefix sum
        for (int r = 0; r < rows; r++) {
            ps[r][0] = nums[r][0];
            for (int c = 1; c < cols; c++) ps[r][c] = ps[r][c - 1] + nums[r][c];
        }

        // col wise prefix sum
        for (int c = 0; c < cols; c++) {
            for (int r = 1; r < rows; r++) {
                ps[r][c] += ps[r - 1][c];
            }
        }


        long maxSum = Long.MIN_VALUE;
        for (int r1 = 0; r1 < rows; r1++) {
            for (int c1 = 0; c1 < cols; c1++) {
                //top left (r1,c1)
                for (int r2 = r1; r2 < rows; r2++) {
                    for (int c2 = c1; c2 < cols; c2++) {
                        // bottom right (r2,c2)
                        long left = (c1 > 0) ? ps[r2][c1 - 1] : 0;
                        long up = (r1 > 0) ? ps[r1 - 1][c2] : 0;
                        long topLeftCorner = (r1 > 0 && c1 > 0) ? ps[r1 - 1][c1 - 1] : 0;

                        long subMatrixSum = ps[r2][c2] - left - up + topLeftCorner;
                        maxSum = Math.max(maxSum, subMatrixSum);
                        //O(n^4)
                    }
                }
            }
        }
        return maxSum;
    }

    private long maxContiguousSumSubArray(long[] nums) {
        int n = nums.length;
        long meh = 0, msf = Long.MIN_VALUE;
        for (long v : nums) {
            meh += v;
            msf = Math.max(msf, meh);
            if (meh < 0) meh = 0;
        }
        return msf;
    }

    // O(r*r*c*c)  r,r for rows , c-> for cols and last c is to calculate kadane max sum
    private long solveAnotherBetterUsingKadane(int[][] nums) {
        int rows = nums.length;
        if (rows == 0) return 0;
        int cols = nums[0].length;
        MaximumSubmatrixSum maximumSubmatrixSum = new MaximumSubmatrixSum();

        long maxSum = Long.MIN_VALUE;
        for (int r1 = 0; r1 < rows; r1++) {
            long[] prefixSumRowWise = new long[cols];
            for (int r2 = r1; r2 < rows; r2++) {
                for (int c = 0; c < cols; c++) {
                    prefixSumRowWise[c] += nums[r2][c];
                }
                maxSum = Math.max(maxSum, maximumSubmatrixSum.maxContiguousSumSubArray(prefixSumRowWise));
            }
        }
        return maxSum;
    }


    public static void main(String[] args) {
        int[][] nums = {{-5, -4, -3},
                {9, -2, -3},
                {8, -2, -4}};
        MaximumSubmatrixSum maximumSubmatrixSum = new MaximumSubmatrixSum();
        long res = maximumSubmatrixSum.solveBrute(nums);
        System.out.println(res);

        int[][] nums2 = {{1, 2}, {-5, -7}};
        int[][] nums1 = {{0, -2, -7, 0}, {9, 2, -6, 2}, {-4, 1, -4, 1}, {-1, 8, 0, -2}};
        long res1 = maximumSubmatrixSum.solveBetterWay(nums1);
        System.out.println(res1);


        long res2 = maximumSubmatrixSum.solveAnotherBetterUsingKadane(nums1);
        System.out.println(res2);

    }
}
