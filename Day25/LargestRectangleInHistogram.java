package Day25;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class LargestRectangleInHistogram {
    private ArrayList<Integer> getNextSmallerLeft(ArrayList<Integer> nums) {
        int n = nums.size();
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();

        stack.push(0);
        res.add(-1);
        for (int index = 1; index < n; index++) {
            int key = nums.get(index);
            while (!stack.isEmpty() && nums.get(stack.peek()) >= key) stack.pop();

            if (stack.isEmpty()) res.add(-1);
            else res.add(stack.peek());
            stack.push(index);
        }
        return res;
    }

    private ArrayList<Integer> getNextSmallerRight(ArrayList<Integer> nums) {
        int n = nums.size();
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();

        stack.push(n - 1);
        res.add(n);
        for (int index = n - 2; index >= 0; index--) {
            int key = nums.get(index);
            while (!stack.isEmpty() && nums.get(stack.peek()) >= key) stack.pop();

            if (stack.isEmpty()) res.add(n);
            else res.add(stack.peek());
            stack.push(index);
        }

        Collections.reverse(res);
        return res;
    }


    public int largestRectangleArea(ArrayList<Integer> nums) {
        int n = nums.size();
        if (n == 0) return 0;

        ArrayList<Integer> nextSmallerLeft = getNextSmallerLeft(nums);
        ArrayList<Integer> nextSmallerRight = getNextSmallerRight(nums);

        long largestArea = 0;
        for (int index = 0; index < n; index++) {
            long key = nums.get(index);
            long width = nextSmallerRight.get(index) - nextSmallerLeft.get(index) - 1;
            largestArea = Math.max(largestArea, key * width);
        }
        return (int) largestArea;
    }
}
