package Day5;

import java.util.Arrays;

public class AggressiveCows {
    private boolean canPlaceCows(int[] nums, int distance, int cows) {
        if (nums.length == 0) return false;
        int numberOfCows = 1;
        int prevLocation = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int currentLocation = nums[i];
            if (prevLocation + distance <= currentLocation) {
                numberOfCows++;
                prevLocation = currentLocation;
            }
        }
        return numberOfCows >= cows;
    }

    public int solve(int[] nums, int cows) {
        int n = nums.length;
        if (n == 0) return 0;
        Arrays.sort(nums);

        int lowestDistance = 1, highestDistance = nums[n - 1] - nums[0];
        int bestDistance = highestDistance;
        while (lowestDistance <= highestDistance) {
            int minDistance = lowestDistance + (highestDistance - lowestDistance) / 2;

            if (canPlaceCows(nums, minDistance, cows)) {
                bestDistance = minDistance;
                lowestDistance = minDistance + 1;
            } else highestDistance = minDistance - 1;
        }
        return bestDistance;
    }
}
