package Day13;

import java.util.Arrays;

public class HerculesLabour {

    // O(nlog(n))
    public int solve(int[] nums) {
        //  3,2,1,2,1,7

        //  1 1 2 2 3 7
        //  0 1 2 3 4 5

        //      1 1 2 2 3 7
        //  i=1  1 2 2 2 3 7      count=1
        //  i=2  1 2 3 2 3 7      count=1+1=2

        //  at i=3<i=2 , array is sorted it means there lies duplicate
        //  i=3  1 2 3 4 3 7      count=2+2=4

        //  at i=4<i=3, there lies duplicate i=4
        //  i=4  1 2 3 4 5 7      count=4+2=6

        int n = nums.length;
        Arrays.sort(nums);

        long count = 0;
        for (int i = 1; i < n; i++) {
            // if current is same as previous, increment by one
            if (nums[i] == nums[i - 1]) {
                count++;
                nums[i]++;
            }
            //if current is less than previous despite of being sorted, increment based on previous
            else if (nums[i] < nums[i - 1]) {
                int diff = nums[i - 1] - nums[i];
                count = count + diff + 1;
                nums[i] += diff + 1;
            }
        }
        return (int) count;
    }

    // tc -> O(n)
    public int minIncrementForUnique(int[] nums) {
        int n = nums.length;

        int maxElement = 0;
        for (int v : nums) maxElement = Math.max(maxElement, v);

        int[] hash = new int[maxElement + n];
        for (int v : nums) hash[v]++;

        int moves = 0;
        for (int number = 0; number < hash.length; number++) {
            if (hash[number] <= 1) continue;

            // find extra
            int extra = hash[number] - 1;
            // add this extra to next number
            hash[number + 1] += extra;
            hash[number] = 1;

            moves += extra;
        }
        return moves;
    }
}
