package Day5;

public class SearchInRotatedAndSortedII {
    private boolean binSearch(int[] nums, int l, int h, int key) {
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == key) return true;
            if (nums[mid] > key) h = mid - 1;
            else l = mid + 1;
        }
        return false;
    }

    public boolean search(int[] nums, int key) {
        // [1, 0 , 1 , 1 , 1]
        //  0  1   2   3   4
        //   l      mid     h
        //       l        h
        //    1,1,1,1,1,   1,1,1,1,1, 1, 1, 1, 2,      1, 1, 1,  1, 1
        //    0 1 2 3 4    5 6 7 8 9 10  11 12 13      14 15 16  17  18

        //    l=0,h=18,mid=9
        //    l=5,mid=9,h=13

        //target=0
        //l=0,h=4,mid=2
        int n = nums.length;
        int l = 0, h = n - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == key) return true;

            // for duplicates
            while (l < n && h > 0 && nums[l] == nums[mid] && nums[mid] == nums[h]) {
                l++;
                h--;
            }

            // if first part is sorted
            if (l < n && nums[l] <= nums[mid]) {
                if (key >= nums[l] && key <= nums[mid]) return binSearch(nums, l, mid, key);
                else l = mid + 1;
            }
            // second part is sorted
            else {
                if (h >= 0 && key >= nums[mid] && key <= nums[h]) return binSearch(nums, mid, h, key);
                else h = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1};
        int key = 2;
        SearchInRotatedAndSortedII rotatedSortedArraySearchII =
                new SearchInRotatedAndSortedII();
        boolean isFound = rotatedSortedArraySearchII.search(nums, key);
        System.out.println(isFound);
    }
}
