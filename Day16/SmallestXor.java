package Day16;

public class SmallestXor {
    private boolean checkSetBits(int number,int bitPosition){
        return ((number>>bitPosition)&1)==1;
    }

    public int solve(int A, int B) {
        if(B==0) return 0;
        int countOfSetBitsinX = B;

        int x = 0;
        for (int bitPosition = 31; bitPosition >= 0; bitPosition--) {
            if (checkSetBits(A, bitPosition)){
                x = (x | 1 << bitPosition);
                countOfSetBitsinX--;
            }
            if(countOfSetBitsinX<=0) return x;
        }

        for (int bitPosition = 0; bitPosition <=31; bitPosition++) {
            if (!checkSetBits(A, bitPosition)){
                x = (x | 1 << bitPosition);
                countOfSetBitsinX--;
            }
            if(countOfSetBitsinX<=0) return x;
        }

        return x;
    }

    public static void main(String[] args) {
        int a = 4, b = 6;
        SmallestXor xor = new SmallestXor();
        int res = xor.solve(a, b);
        System.out.println(res);
    }
}
