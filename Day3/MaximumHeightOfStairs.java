package Day3;

public class MaximumHeightOfStairs {
    /*
* Given an integer A representing the number of square blocks.
* The height of each square block is 1.
* The task is to create a staircase of max-height using these blocks.

The first stair would require only one block,
* and the second stair would require two blocks, and so on.

Find and return the maximum height of the staircase.
*
*
* A=10
* 4
*
* A=20
* 5
*
* */
    private boolean isPossibleToConstruct(final long optimalHeightStairs,
                                          final long totalBricks) {
        return ((optimalHeightStairs * (optimalHeightStairs + 1)) / 2) <= totalBricks;
    }

    public int solve(int totalBricks) {
        if (totalBricks <= 1) return totalBricks;
        if (totalBricks == 2) return 1;

        long minHeightStairs = 1, maxHeightStairs = totalBricks;
        long best = -1L;
        while (minHeightStairs <= maxHeightStairs) {
            long optimalHeightStairs = minHeightStairs + (maxHeightStairs - minHeightStairs) / 2;
            if (isPossibleToConstruct(optimalHeightStairs, totalBricks)) {
                best = optimalHeightStairs;
                minHeightStairs = optimalHeightStairs + 1;
            } else maxHeightStairs = optimalHeightStairs - 1;
        }
        return (int) best;
    }
}
