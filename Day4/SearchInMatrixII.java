package Day4;

public class SearchInMatrixII {
    // O(rows+cols)
    public boolean searchMatrixApproach1(int[][] nums, int key) {
        int rows = nums.length;
        if (rows == 0) return false;
        int cols = nums[0].length;

        int row = 0, col = cols - 1;
        while (row < rows && col >= 0) {
            if (nums[row][col] == key) return true;
            if (nums[row][col] > key) col--;
            else row++;
        }
        return false;
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

    // O(row*log(col))
    public boolean searchMatrixApproach2(int[][] nums, int key) {
        int rows = nums.length;
        if (rows == 0) return false;

        for (int row = 0; row < rows; row++) {
            if (binSearch(nums[row], key)) return true;
        }
        return false;
    }
}
