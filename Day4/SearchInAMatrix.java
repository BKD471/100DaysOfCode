package Day4;

public class SearchInAMatrix {
    // O(row+col)
    public int searchMatrix(int[][] nums, int key) {
        int rows = nums.length;
        if (rows == 0) return -1;
        int cols = nums[0].length;

        int row = 0, col = cols - 1;
        while (row < rows && col >= 0) {
            if (nums[row][col] == key) return 1;
            if (nums[row][col] > key) col--;
            else row++;
        }
        return 0;
    }

    private boolean binSearch(int[] nums, int key) {
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == key) return true;
            if (nums[mid] > key) h = mid - 1;
            else l = mid + 1;
        }
        return false;
    }

    // O(log(row)+log(col))
    public boolean searchMatrixBest(int[][] nums, int key) {
        int rows = nums.length;
        if (rows == 0) return false;
        int cols = nums[0].length;

        int lrow = 0, hrow = rows - 1;
        while (lrow <= hrow) {
            int midRow = lrow + (hrow - lrow) / 2;

            if (nums[midRow][0] <= key && nums[midRow][cols - 1] >= key) return binSearch(nums[midRow], key);
            if (nums[midRow][0] > key) hrow = midRow - 1;
            else lrow = midRow + 1;
        }
        return false;
    }
}
