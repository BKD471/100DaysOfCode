package Day2;

import java.util.Arrays;

public class MaxNumberOfMovesInAGrid {
    class Solution {
        private int solve(int[][] grid, int r, int c, int prevValue, int[][] memo, boolean init) {
            if (!init && (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] <= prevValue))
                return -1;
            if (memo[r][c] != -1) return memo[r][c];

            // down right
            int dr = 1 + solve(grid, r + 1, c + 1, grid[r][c], memo, false);

            // up right
            int ur = 1 + solve(grid, r - 1, c + 1, grid[r][c], memo, false);

            // right
            int rt = 1 + solve(grid, r, c + 1, grid[r][c], memo, false);
            return memo[r][c] = Math.max(rt, Math.max(dr, ur));
        }

        public int maxMoves(int[][] grid) {
            int rows = grid.length;
            if (rows == 0) return 0;
            int cols = grid[0].length;

            int[][] memo = new int[rows + 1][cols + 1];
            for (int i = 0; i <= rows; i++) Arrays.fill(memo[i], -1);


            int maxMoves = 0;
            for (int r = 0; r < rows; r++) {
                maxMoves = Math.max(maxMoves, solve(grid, r, 0, grid[r][0], memo, true));
            }
            return maxMoves;
        }
    }
}
