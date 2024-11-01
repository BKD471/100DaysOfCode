package Day4;

public class MatrixMedian {
    private int upperBound(final int[] nums, final int target) {
        int l = 0, h = nums.length - 1;
        int best = nums.length;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] > target) {
                best = mid;
                h = mid - 1;
            } else l = mid + 1;
        }
        return best;
    }

    private int findCountOfNumbersLessThanEqualsPossibleMedian(final int[][] nums, final int possibleMedian) {
        int count = 0;
        for (int[] row : nums) count += upperBound(row, possibleMedian);
        return count;
    }

    public int findMedian(int[][] nums) {
        final int rows = nums.length;
        if (rows == 0) return 0;
        final int cols = nums[0].length;

        final int numberOfElementsRequiredToBeInEachHalf = (rows * cols) / 2;
        int lowestNumberPossibleToBeMedian = Integer.MAX_VALUE;
        int highestNumberPossibleToBeMedian = Integer.MIN_VALUE;


        for (int[] row : nums) {
            lowestNumberPossibleToBeMedian = Math.min(lowestNumberPossibleToBeMedian, row[0]);
            highestNumberPossibleToBeMedian = Math.max(highestNumberPossibleToBeMedian, row[cols - 1]);
        }
        int best = -1;
        while (lowestNumberPossibleToBeMedian <= highestNumberPossibleToBeMedian) {
            int possibleMedian =
                    lowestNumberPossibleToBeMedian + (highestNumberPossibleToBeMedian - lowestNumberPossibleToBeMedian) / 2;

            int countOfNumberLessThanEqualsPossibleMedian =
                    findCountOfNumbersLessThanEqualsPossibleMedian(nums, possibleMedian);
            if (countOfNumberLessThanEqualsPossibleMedian > numberOfElementsRequiredToBeInEachHalf) {
                best = possibleMedian;
                highestNumberPossibleToBeMedian = possibleMedian - 1;
            } else lowestNumberPossibleToBeMedian = possibleMedian + 1;
        }
        return best;
    }
}
