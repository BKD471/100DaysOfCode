package Day18;

public class NextPermutation {
    private void swap(int[] nums, int l, int h) {
        int t = nums[l];
        nums[l] = nums[h];
        nums[h] = t;
    }

    private void reverse(int[] nums, int l, int h) {
        while (l <= h) swap(nums, l++, h--);
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n == 0) return;

        // find the pivot , the index which can be swapped with next greater element
        // stop at index which is lesser than previous from right
        int pivotIndex = -1;
        for (int index = n - 2; index >= 0; index--) {
            if (nums[index] < nums[index + 1]) {
                pivotIndex = index;
                break;
            }
        }
        if (pivotIndex == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        int pivotElement = nums[pivotIndex];
        int minDiff = Integer.MAX_VALUE;

        int targetElementIndex = -1;
        for (int index = pivotIndex + 1; index < n; index++) {
            int possibleNextGreater = nums[index];
            if (possibleNextGreater > pivotElement) {
                int diff = possibleNextGreater - pivotElement;
                if (diff <= minDiff) {
                    minDiff = diff;
                    targetElementIndex = index;
                }
            }
        }
        swap(nums, pivotIndex, targetElementIndex);
        // before swapping with pivot, the right part of pivot contains numbers in descending which is the highest combination possible
        // after swapping with pivot, to make it the smallest just reverse it
        reverse(nums, pivotIndex + 1, n - 1);
    }
}
