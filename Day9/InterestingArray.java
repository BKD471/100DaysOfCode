package Day9;

public class InterestingArray {
    public String solve(int[] nums) {
        int countOfOdd=0;
        for(int v:nums){
            if((v&1)==1) countOfOdd++;
        }

        return (countOfOdd&1)==0? "Yes":"No";
    }
}
