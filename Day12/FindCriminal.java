package Day12;

public class FindCriminal {
    private boolean isDuplicates(int[] freq){
        for(int i=0;i<127;i++){
            if(freq[i]>1) return true;
        }
        return false;
    }

    // O(n)
    public int lengthOfLongestSubstring(String str) {
        int n=str.length();
        if(n==0) return 0;

        int[] freq=new int[127];
        int l=0,h=0;
        int maxLength=0;
        while(h<n){
            int incomingCharIndex=str.charAt(h);
            freq[incomingCharIndex]++;
            while(isDuplicates(freq)){
                int leavingCharIndex=str.charAt(l);
                freq[leavingCharIndex]--;
                l++;
            }
            int length=h-l+1;
            maxLength=Math.max(maxLength,length);
            h++;
        }
        return maxLength;
    }
}
