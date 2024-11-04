package Day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0) return res;
        Arrays.sort(nums);

        // [0,0,0,0]
        // 0 0   0
        //   0 0 0


        for (int i = 0; i < n; i++) {
            int j = i + 1, k = n - 1;
            while (j < k) {
                int key = nums[i] + nums[j] + nums[k];
                if (key == 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    int lv = nums[j];
                    while (j < n && lv == nums[j]) j++;
                    int rv = nums[k];
                    while (k >= 0 && rv == nums[k]) k--;
                } else if (key > 0) k--;
                else j++;
            }
            while (i + 1 < n && nums[i] == nums[i + 1]) i++;
        }
        return res;
    }
}
