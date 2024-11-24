package Day25;

public class MaximumMatrixSum {
    public long maxMatrixSum(int[][] matrix) {
        long sum=0;
        int countOfNegatives=0;
        int minAbsoluteValue=Integer.MAX_VALUE;
        for(int[] rows:matrix){
            for(int v:rows){
                if(v<0) countOfNegatives++;
                sum+=Math.abs(v);
                minAbsoluteValue=Math.min(minAbsoluteValue,Math.abs(v));
            }
        }

        if((countOfNegatives&1)==0) return sum;
        return sum- 2L *minAbsoluteValue;
    }
}
