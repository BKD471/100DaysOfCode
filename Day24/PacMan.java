package Day24;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class PacMan {
    private static final int LIMIT = (int) (Math.pow(10, 9) + 7);

    public ArrayList<Integer> nearestSmallerLeft(ArrayList<Integer> nums) {
        int n = nums.size();
        if (n == 0) return new ArrayList<>();

        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();

        res.add(-1);
        st.push(0);
        for (int index = 1; index < n; index++) {
            int key = nums.get(index);
            while (!st.isEmpty() && nums.get(st.peek()) >= key) st.pop();

            if (st.isEmpty()) res.add(-1);
            else res.add(st.peek());
            st.push(index);
        }
        return res;
    }

    public ArrayList<Integer> nearestSmallerRight(ArrayList<Integer> nums) {
        int n = nums.size();
        if (n == 0) return new ArrayList<>();

        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();

        res.add(n);
        st.push(n - 1);
        for (int index = n - 2; index >= 0; index--) {
            int key = nums.get(index);
            while (!st.isEmpty() && nums.get(st.peek()) >= key) st.pop();

            if (st.isEmpty()) res.add(n);
            else res.add(st.peek());
            st.push(index);
        }
        Collections.reverse(res);
        return res;
    }

    public ArrayList<Integer> nearestGreaterLeft(ArrayList<Integer> nums) {
        int n = nums.size();
        if (n == 0) return new ArrayList<>();

        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();

        res.add(-1);
        st.push(0);
        for (int index = 1; index < n; index++) {
            int key = nums.get(index);
            while (!st.isEmpty() && nums.get(st.peek()) <= key) st.pop();

            if (st.isEmpty()) res.add(-1);
            else res.add(st.peek());
            st.push(index);
        }
        return res;
    }

    public ArrayList<Integer> nearestGreaterRight(ArrayList<Integer> nums) {
        int n = nums.size();
        if (n == 0) return new ArrayList<>();

        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();

        res.add(n);
        st.push(n - 1);
        for (int index = n - 2; index >= 0; index--) {
            int key = nums.get(index);
            while (!st.isEmpty() && nums.get(st.peek()) <= key) st.pop();

            if (st.isEmpty()) res.add(n);
            else res.add(st.peek());
            st.push(index);
        }
        Collections.reverse(res);
        return res;
    }

    public int solve(ArrayList<Integer> nums) {
        int n = nums.size();
        if (n == 0) return 0;

        ArrayList<Integer> nextGreaterLeft = nearestGreaterLeft(nums);
        ArrayList<Integer> nextGreaterRight = nearestGreaterRight(nums);
        ArrayList<Integer> nextSmallerLeft = nearestSmallerLeft(nums);
        ArrayList<Integer> nextSmallerRight = nearestSmallerRight(nums);

        long maxSum = 0;
        for (int index = 0; index < n; index++) {
            int key = nums.get(index);
            long countOfSubArraysStartingPoint = (index - nextGreaterLeft.get(index));
            long countOfSubArraysEndingPoint = (nextGreaterRight.get(index) - index);
            long countOfSubArraysWhereKeyIsMax = countOfSubArraysStartingPoint * countOfSubArraysEndingPoint;
            maxSum += countOfSubArraysWhereKeyIsMax * key;
        }

        long minSum = 0;
        for (int index = 0; index < n; index++) {
            int key = nums.get(index);
            long countOfSubArraysStartingPoint = (index - nextSmallerLeft.get(index));
            long countOfSubArraysEndingPoint = (nextSmallerRight.get(index) - index);
            long countOfSubArraysWhereKeyIsMin = countOfSubArraysStartingPoint * countOfSubArraysEndingPoint;
            minSum += countOfSubArraysWhereKeyIsMin * key;
        }

        return (int) ((maxSum - minSum) % LIMIT);
    }
}
