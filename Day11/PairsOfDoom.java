package Day11;

import java.util.HashMap;
import java.util.Map;

public class PairsOfDoom {
    // tc-O(n)
    // sc-O(n)
    public int solve(int[] nums, int k) {
        Map<Long, Long> hash = new HashMap<>();
        for (long v : nums) hash.put(v, hash.getOrDefault(v, 0L) + 1);

        long count = 0L;
        for (long v : nums) {
            hash.put(v, hash.getOrDefault(v, 0L) - 1);
            count += hash.getOrDefault(k - v, 0L);

            hash.put(v, hash.getOrDefault(v, 0L) + 1);
        }
        return (int) ((count / 2) % 1000000007);
    }

    // tc-O(n)
    public int solveBest(int[] nums, int k) {
        int n = nums.length;

        int l = 0, h = n - 1;
        long count = 0;
        while (l <= h) {
            int key = nums[l] + nums[h];
            if (key == k) {
                if (nums[l] != nums[h]) {
                    long count1 = 1;
                    while (l + 1 < n && nums[l] == nums[l + 1]) {
                        l++;
                        count1++;
                    }

                    long count2 = 1;
                    while (h > 0 && nums[h] == nums[h - 1]) {
                        h--;
                        count2++;
                    }

                    count += (count1 * count2);
                    l++;
                    h--;
                } else {
                    long cnt = (h - l + 1);
                    count += ((cnt * (cnt - 1)) / 2);
                    break;
                }
            } else if (key > k) h--;
            else l++;
        }
        return (int) (count % 1000000007);
    }
}
