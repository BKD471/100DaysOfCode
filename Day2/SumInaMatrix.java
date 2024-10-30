package Day2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SumInaMatrix {
    public int matrixSum(int[][] nums) {
        int rows = nums.length;
        if (rows == 0) return 0;
        int cols = nums[0].length;

        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        int score = 0;
        for (int c = 0; c < cols; c++) {
            for (int r = 0; r < rows; r++) {
                Arrays.sort(nums[r]);
                q.offer(nums[r][cols - 1]);
                nums[r][cols - 1] = Integer.MIN_VALUE;
            }
            score += q.poll();
            q.clear();
        }
        return score;
    }
}
