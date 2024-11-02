package Day5;

public class SearchInRotatedAndSorted {
    private int binSearch(int[] nums, int l, int h, int key) {
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == key) return mid;
            if (nums[mid] > key) h = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }

    public int search(int[] nums, int key) {
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;

            // if first part is sorted
            if (nums[l] <= nums[mid]) {
                if (key >= nums[l] && key <= nums[mid]) return binSearch(nums, l, mid, key);
                else l = mid + 1;
            }
            // second part is sorted
            else {
                if (key >= nums[mid] && key <= nums[h]) return binSearch(nums, mid, h, key);
                else h = mid - 1;
            }
        }
        return -1;
    }
}
