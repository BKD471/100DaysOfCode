package Day7;

public class ContainerWithMostWater {
    public int maxArea(int[] nums) {
        int n = nums.length;
        int l = 0, h = n - 1;
        int water = 0;
        while (l <= h) {
            if (nums[l] <= nums[h]) {
                water = Math.max(water, nums[l] * (h - l));
                l++;
            } else {
                water = Math.max(water, nums[h] * (h - l));
                h--;
            }
        }
        return water;
    }
}
