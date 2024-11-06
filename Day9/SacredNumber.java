package Day9;

public class SacredNumber {
    private boolean checkSetBits(int A, int bitPosition) {
        return ((A >> bitPosition) & 1) == 1;
    }

    public int solve(int A) {

        int countOfBitsinA = 0;
        int index = -1;
        for (int bitPosition = 31; bitPosition >= 0; bitPosition--) {
            if (checkSetBits(A, bitPosition)) {
                countOfBitsinA = bitPosition + 1;
                index = bitPosition;
                break;
            }
        }

        int y = 1 << countOfBitsinA;
        int x = 0;
        for (int bitPosition = 0; bitPosition <= index; bitPosition++) {
            if (!checkSetBits(A, bitPosition)) x = (x | (1 << bitPosition));
        }
        return x ^ y;
    }
}
