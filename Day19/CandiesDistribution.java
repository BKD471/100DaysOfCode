package Day19;

import java.util.Arrays;

public class CandiesDistribution {
    // O(number*log(log(number)))
    public int solve(int number) {
        boolean[] isPrime = new boolean[1011 + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int numbers = 2; numbers * numbers <= 1011; numbers++) {
            if (isPrime[numbers]) {
                for (int multipleOfNumbers = numbers * numbers; multipleOfNumbers <= 1011; multipleOfNumbers += numbers)
                    isPrime[multipleOfNumbers] = false;
            }
        }


        for (int numbers = number + 1; numbers <= 1011; numbers++) {
            if (isPrime[numbers]) return numbers;
        }
        return 2;
    }
}
