package Day14;

import java.util.Arrays;

public class GoldBachConjecture {
    // O(nloglogn)
    public int[] goldBachNumber(int number) {
        if (number == 0) return new int[]{};

        boolean[] isPrime = new boolean[number + 1];
        Arrays.fill(isPrime, true);

        for (int numbers = 2; numbers * numbers <= number; numbers++) {
            if (isPrime[numbers]) {
                for (int multipleOfNumber = numbers * numbers; multipleOfNumber <= number; multipleOfNumber += numbers) {
                    isPrime[multipleOfNumber] = false;
                }
            }
        }

        for (int numbers = 2; numbers <= number; numbers++) {
            if (isPrime[numbers] && isPrime[number - numbers]) return new int[]{numbers, number - numbers};
        }
        return new int[]{};
    }
}
