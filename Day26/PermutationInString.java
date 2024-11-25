package Day26;

public class PermutationInString {
    private boolean compareFreq(int[] charFreq,int[] tempFreq){
        for(int index=0;index<26;index++){
            if(charFreq[index]!=tempFreq[index]) return false;
        }
        return true;
    }

    // O(n)
    public boolean checkInclusion(String s1, String s2) {
        int m=s1.length(),n=s2.length();
        if(m>n) return false;

        int[] charFreq=new int[26];
        for(char ch:s1.toCharArray()){
            int index=ch-'a';
            charFreq[index]++;
        }


        int[] tempFreq=new int[26];
        for(int i=0;i<m;i++){
            int index=s2.charAt(i)-'a';
            tempFreq[index]++;
        }

        if(compareFreq(charFreq,tempFreq)) return true;
        int l=0,h=m;
        while(h<n){
            int incomingIndex=s2.charAt(h++)-'a';
            int leavingIndex=s2.charAt(l++)-'a';
            tempFreq[incomingIndex]++;
            tempFreq[leavingIndex]--;
            if(compareFreq(charFreq,tempFreq)) return true;
        }
        return false;
    }
}
