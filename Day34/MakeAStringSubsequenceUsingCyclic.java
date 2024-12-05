package Day34;

public class MakeAStringSubsequenceUsingCyclic {
        private boolean isSubsequence(String str1,String str2,int i,int m,int j,int n){
            if(j>=n) return true;
            if(i>=m) return false;

            if(str1.charAt(i)==str2.charAt(j) || str1.charAt(i)+1==str2.charAt(j) || str1.charAt(i)-25==str2.charAt(j) ) return isSubsequence(str1,str2,i+1,m,j+1,n);
            else return isSubsequence(str1,str2,i+1,m,j,n);
        }
        public boolean canMakeSubsequence(String str1, String str2) {
            //[97,98,99]
            //[97,100]
            int m=str1.length(),n=str2.length();
            if(n>m) return false;
            return isSubsequence(str1,str2,0,m,0,n);
        }
}
