package Day19;

import java.util.Deque;
import java.util.LinkedList;

public class ShortestSubArrayWithSumAtLeastK {
    public int solve(int[] nums, int k) {
        int n = nums.length;

        Deque<Integer> deq = new LinkedList<>();
        long[] prefixSum = new long[n];

        int result = Integer.MAX_VALUE;
        int h = 0;

        while (h < n) {
            if (h == 0)
                prefixSum[h] = nums[h];
            else
                prefixSum[h] = prefixSum[h - 1] + nums[h];

            if (prefixSum[h] >= k)
                result = Math.min(result, h + 1);

            while (!deq.isEmpty() && prefixSum[h] - prefixSum[deq.peekFirst()] >= k) {
                result = Math.min(result, h - deq.peekFirst());  // Calculate the length of the subarray
                deq.pollFirst();
            }

            while (!deq.isEmpty() && prefixSum[h] <= prefixSum[deq.peekLast()]) {
                deq.pollLast();
            }
            deq.offerLast(h);

            h++;
        }

        return result != Integer.MAX_VALUE ? result : -1;
    }
}
