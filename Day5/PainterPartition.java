package Day5;

public class PainterPartition {
    private static final int LIMIT = (int) (Math.pow(10, 7) + 3);

    private boolean canDistributeLoad(int[] boards, long optimalLoad, long painters) {
        long numberOfPainters = 1;
        long load = 0;
        for (int v : boards) {
            if (load + v <= optimalLoad) load += v;
            else {
                numberOfPainters++;
                load = v;
            }
        }
        return numberOfPainters <= painters;

    }

    public int paint(int painters, int time, int[] boards) {
        int n = boards.length;
        if (n == 0) return 0;

        long lowestLoad = 0;
        long highestLoad = 0;
        for (int v : boards) {
            lowestLoad = Math.max(lowestLoad, v);
            highestLoad = (highestLoad % LIMIT + v % LIMIT) % LIMIT;
        }

        long bestLoad = lowestLoad;
        while (lowestLoad <= highestLoad) {
            long optimalLoad = lowestLoad + (highestLoad - lowestLoad) / 2;

            if (canDistributeLoad(boards, optimalLoad, painters)) {
                bestLoad = optimalLoad;
                highestLoad = optimalLoad - 1;
            } else lowestLoad = optimalLoad + 1;
        }
        return (int) (((bestLoad % LIMIT) * (time % LIMIT)) % LIMIT);
    }
}
