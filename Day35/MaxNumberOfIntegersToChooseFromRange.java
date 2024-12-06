package Day35;

import java.util.HashSet;
import java.util.Set;

public class MaxNumberOfIntegersToChooseFromRange {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> hash = new HashSet<>();
        for (int v : banned) hash.add(v);

        int sum = 0;
        int count = 0;
        for (int number = 1; number <= n; number++) {
            if (hash.contains(number)) continue;
            if (sum + number <= maxSum) {
                sum += number;
                count++;
            } else break;
        }
        return count;
    }
}
