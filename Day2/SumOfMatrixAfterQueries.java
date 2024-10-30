package Day2;

import java.util.HashSet;
import java.util.Set;

public class SumOfMatrixAfterQueries {
    public long matrixSumQueries(int n, int[][] queries) {
        if (n == 0) return n;
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();

        long totalSum = 0;
        int querySize = queries.length;
        for (int i = querySize - 1; i >= 0; i--) {
            int[] query = queries[i];
            int type = query[0];
            int index = query[1];
            int value = query[2];
            if (type == 0) {
                if (!rowSet.contains(index)) {
                    totalSum += (long) value * (n - colSet.size());
                    rowSet.add(index);
                }
            } else {
                if (!colSet.contains(index)) {
                    totalSum += (long) value * (n - rowSet.size());
                    colSet.add(index);
                }
            }
        }
        return totalSum;
    }
}
