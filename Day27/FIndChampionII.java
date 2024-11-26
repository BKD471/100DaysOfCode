package Day27;

public class FIndChampionII {
    public int findChampion(int n, int[][] edges) {
        if (n == 0) return -1;

        int[] inDegrees = new int[n];
        for (int[] edge : edges) {
            int weakerTeam = edge[1];
            inDegrees[weakerTeam]++;
        }

        int countOfStrongerTeams = 0;
        int winner = -1;
        for (int teams = 0; teams < n; teams++) {
            if (inDegrees[teams] == 0) {
                countOfStrongerTeams++;
                winner = teams;
            }
        }
        return countOfStrongerTeams == 1 ? winner : -1;
    }
}
