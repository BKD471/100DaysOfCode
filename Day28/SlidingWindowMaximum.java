package Day28;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    //O(n*log(n))
    public int[] slidingWindowBrute(int[] arr, int k) {
        int n = arr.length;
        if (n == 0) return new int[]{};

        PriorityQueue<Integer> pq =
                new PriorityQueue<>(k, (a, b) -> b - a);
        for (int i = 0; i < k; i++) pq.offer(arr[i]);

        int index = 0;
        int[] res = new int[n - k + 1];
        if (!pq.isEmpty()) res[index++] = pq.poll();

        int l = 0, h = k;
        while (h < n) {
            pq.offer(arr[h++]);
            pq.remove(arr[l++]);
            res[index++] = !pq.isEmpty() ? pq.peek() : -1;
        }
        return res;
    }

    // O(n)
    public int[] slidingWindowBest(int[] arr, int k) {
        int n = arr.length;
        if (n == 0) return new int[]{};

        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        for (int index = 0; index < k; index++) {
            int key = arr[index];
            if (dq.isEmpty()) {
                dq.addLast(index);
                continue;
            }
            while (!dq.isEmpty() && arr[dq.getLast()] < key) dq.removeLast();
            dq.addLast(index);
        }

        int index = 0;
        res[index++] = !dq.isEmpty() ? arr[dq.getFirst()] : -1;

        int h = k;
        while (h < n) {
            int indexOfFirst = dq.getFirst();
            if (h - k >= indexOfFirst) dq.removeFirst();

            int key = arr[h];
            while (!dq.isEmpty() && arr[dq.getLast()] < key) dq.removeLast();
            dq.addLast(h);

            res[index++] = !dq.isEmpty() ? arr[dq.getFirst()] : -1;
            h++;
        }

        return res;
    }
}
