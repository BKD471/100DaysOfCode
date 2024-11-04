package Day7;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithGivenSum {
    public int[] solve(int[] nums, int k) {
        int n = nums.length;

        Map<Long, Integer> hash = new HashMap<>();
        long cumSum = 0L;

        int firstIndex = -1, lastIndex = -1;
        for (int i = 0; i < n; i++) {
            cumSum += nums[i];
            long key = (long) (cumSum - k);
            if (cumSum == k) {
                firstIndex = 0;
                lastIndex = i;
                break;
            }
            if (hash.containsKey(key)) {
                firstIndex = hash.get(key) + 1;
                lastIndex = i;
                break;
            }
            hash.put(cumSum, i);
        }
        if (firstIndex == -1) return new int[]{-1};

        int[] res = new int[lastIndex - firstIndex + 1];
        int index = 0;
        for (int i = firstIndex; i <= lastIndex; i++) res[index++] = nums[i];
        return res;
    }
}
