package Day10;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(final int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        Set<Integer> hash = new HashSet<>();
        for (int v : nums) hash.add(v);

        int longestChain = 0;
        for (int v : nums) {
            int previousValue = v - 1;
            if (hash.contains(previousValue)) continue;

            int chainLength = 0;
            while (hash.contains(v)) {
                chainLength++;
                v++;
            }
            longestChain = Math.max(longestChain, chainLength);
        }
        return longestChain;
    }
}
