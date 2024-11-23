package Day24;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NextGreater {
    public ArrayList<Integer> nextGreaterRight(ArrayList<Integer> nums) {
        int n=nums.size();
        if(n==0) return new ArrayList<>();

        Stack<Integer> st=new Stack<>();
        ArrayList<Integer> res=new ArrayList<>();

        res.add(-1);
        st.push(nums.get(n-1));
        for(int index=n-2;index>=0;index--){
            int key=nums.get(index);
            while(!st.isEmpty() && st.peek()<=key) st.pop();

            if(st.isEmpty()) res.add(-1);
            else res.add(st.peek());
            st.push(key);
        }
        Collections.reverse(res);
        return res;
    }
}
