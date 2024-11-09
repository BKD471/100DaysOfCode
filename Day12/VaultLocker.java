package Day12;

public class VaultLocker {
    private boolean compareStrings(int[] targetFreq,int[] originalFreq){
        for(int index=0;index<127;index++){
            if(targetFreq[index]>originalFreq[index]) return false;
        }
        return true;
    }
    public int solve(String b, String a) {
        int m=a.length(),n=b.length();
        if(n>m) return 0;

        int[] targetFreq=new int[127];
        for(char ch:b.toCharArray()){
            targetFreq[ch]++;
        }

        int[] originalFreq=new int[127];
        for(int i=0;i<n;i++){
            originalFreq[a.charAt(i)]++;
        }

        long count=0;
        if(compareStrings(targetFreq,originalFreq))  count++;

        int l=0,h=n;
        while(h<m){
            int incomingCharIndex=a.charAt(h);
            originalFreq[incomingCharIndex]++;

            int leavingCharIndex=a.charAt(l);
            originalFreq[leavingCharIndex]--;
            if(compareStrings(targetFreq,originalFreq)) count++;
            h++;
            l++;
        }
        return (int)count;
    }
}
