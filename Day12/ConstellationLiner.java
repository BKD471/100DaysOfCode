package Day12;

import java.util.HashMap;
import java.util.Map;

public class ConstellationLiner {
    // O(m*n)
    public int solve(int[] x, int[] y) {
        int m = x.length, n = y.length;
        if (m != n) return 0;

        int maxPoints = 0;
        for (int i = 0; i < m; i++) {
            int x1 = x[i];
            int y1 = y[i];
            Map<Double, Integer> hash = new HashMap<>();
            int duplicate = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int x2 = x[j];
                int y2 = y[j];

                if (x1 == x2 && y1 == y2) {
                    duplicate++;
                    continue;
                }
                double dy = y2 - y1;
                double dx = x2 - x1;
                double slope = dy / dx;
                hash.put(slope, hash.getOrDefault(slope, 0) + 1);
                maxPoints = Math.max(maxPoints, duplicate + hash.get(slope));
            }
        }
        return maxPoints + 1;
    }
}
