package Day24;

import java.util.ArrayList;
import java.util.Stack;

public class NextSmaller {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> nums) {
        int n=nums.size();
        if(n==0) return new ArrayList<>();

        Stack<Integer> st=new Stack<>();
        ArrayList<Integer> res=new ArrayList<>();

        res.add(-1);
        st.push(nums.getFirst());
        for(int index=1;index<n;index++){
            int key=nums.get(index);
            while(!st.isEmpty() && st.peek()>=key) st.pop();

            if(st.isEmpty()) res.add(-1);
            else res.add(st.peek());
            st.push(key);
        }
        return res;
    }
}
