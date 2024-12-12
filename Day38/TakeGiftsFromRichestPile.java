package Day38;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TakeGiftsFromRichestPile {
    private long pickGifts(int[] gifts, int k) {
        //5,8,9,4,10
        //5,8,9,4,3

        int n = gifts.length;
        if (n == 0) return 0;

        Comparator<Long> sort = (a, b) -> {
            if (b > a) return 1;
            else if (b < a) return -1;
            return 0;
        };
        PriorityQueue<Long> pq = new PriorityQueue<>(sort);
        for (long v : gifts) pq.offer(v);

        while (!pq.isEmpty() && k-- > 0) {
            long v = pq.poll();
            long newValue = (long) (Math.sqrt(v));
            pq.offer(newValue);
        }

        long res = 0;
        while (!pq.isEmpty()) res += pq.poll();
        return res;
    }
}
