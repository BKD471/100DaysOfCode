package Day13;

public class ChocolateTray {
    public int solve(int[] nums) {
        int maxElement=0,index=0,countOfSplit=0;
        for(int v:nums){
            maxElement=Math.max(maxElement,v);
            if(maxElement==index) countOfSplit++;
            index++;
        }
        return countOfSplit;
    }
}
