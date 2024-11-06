package Day9;

public class AlienCalculator {
    public int solve(int A, int B) {
        int res = Integer.MAX_VALUE;
        for (int x = 0; x <= Math.max(A, B); x++) {
            int value = (A ^ x) + (B ^ x);
            res = Math.min(res, value);
        }

        return res;
    }


    private boolean checkSetBits(int num,int bitPosition){
        return ((num>>bitPosition)&1)==1;
    }

    //O(1)
    public int solveBest(int A, int B) {
        int x=0;
        for(int bitPosition=0;bitPosition<=31;bitPosition++){
            if(checkSetBits(A,bitPosition) && checkSetBits(B,bitPosition)) x=(x | (1<<bitPosition));

        }
        return (x^A)+(x^B);
    }
}
