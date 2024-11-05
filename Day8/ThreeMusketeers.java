package Day8;

import java.util.Arrays;

public class ThreeMusketeers {
    // O(n^2)
    private int countOfTripletsLessThanPossibleSum(int[] nums, int possibleSum, int k) {
        int n = nums.length;

        int countOfTriplets = 0;
        for (int i = 0; i < n; i++) {
            int l = i + 1, h = n - 1;
            while (l < h) {
                int sum = nums[i] + nums[l] + nums[h];
                if (sum <= possibleSum) {
                    countOfTriplets += (h - l);
                    l++;
                } else h--;
            }
        }
        return countOfTriplets;
    }

    // O(n^2*log(highestPossibleSum-lowestPossibleSum))
    public int solve(int[] nums, int k) {
        // 2,4,3,2
        // 3

        //  2,4,3 =9
        //  2,4,2 =8
        //  2,3,3 =7
        //  4,3,2 =9

        //  2 2 3 4
        //  7 8 9 9
        int n = nums.length;
        if (n == 0) return 0;
        Arrays.sort(nums);

        int lowestPossibleSum = 3;
        int highestPossibleSum = nums[n - 1] + nums[n - 2] + nums[n - 3];
        int kthSumTriplet = -1;
        while (lowestPossibleSum <= highestPossibleSum) {
            int possibleSum = lowestPossibleSum + (highestPossibleSum - lowestPossibleSum) / 2;
            // O(n^2)
            int count = countOfTripletsLessThanPossibleSum(nums, possibleSum, k);

            // for k=4
            // mid=6
            // NoOfTripletsLessThanMid=5
            // 1 2 3 6 6 6
            // 1 2 3 4 5 6
            // although count of triplets with sum lesser than sum(mid)=6 is greater than k=4
            // at 5, but it still can be a answer because of duplicates.
            if (count >= k) {
                kthSumTriplet = possibleSum;
                highestPossibleSum = possibleSum - 1;
            } else lowestPossibleSum = possibleSum + 1;
        }
        return kthSumTriplet;
    }
}
