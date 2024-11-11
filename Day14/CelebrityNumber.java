package Day14;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CelebrityNumber {
    // O(nloglogn)
    private int[] getSpf(int number) {
        boolean[] isPrime = new boolean[number + 1];
        int[] spf = new int[number + 1];
        Arrays.fill(isPrime, true);
        Arrays.fill(spf, -1);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int numbers = 2; numbers * numbers <= number; numbers++) {
            if (isPrime[numbers]) {
                for (int multipleOfNumber = numbers * numbers; multipleOfNumber <= number; multipleOfNumber += numbers) {
                    if (spf[multipleOfNumber] == -1) spf[multipleOfNumber] = numbers;
                    isPrime[multipleOfNumber] = false;
                }
            }
        }

        for (int numbers = 2; numbers <= number; numbers++) if (spf[numbers] == -1) spf[numbers] = numbers;
        return spf;
    }

    // O(nloglogn + logn)
    private boolean isCelebrity(int number, int[] spf) {
        Set<Long> primeFactorsOfNumber = new HashSet<>();
        while (number > 1) {
            long smallestPrimeDivisor = spf[number];
            primeFactorsOfNumber.add(smallestPrimeDivisor);
            while (number % smallestPrimeDivisor == 0) {
                number /= (int) smallestPrimeDivisor;
            }
        }
        return primeFactorsOfNumber.size() == 2;
    }

    // O(nlogn)
    public int solve(int n) {
        if (n == 0) return 0;

        int[] spf = getSpf(n);
        long countOfLukcyNumbers = 0;
        for (int number = 2; number <= n; number++) {
            if (isCelebrity(number, spf)) countOfLukcyNumbers++;
        }
        return (int) countOfLukcyNumbers;
    }

    // Another approach just use sieve of thanos
    // to count number of times struck by a prime number
    // O(nlogn)
    public int solveAnotherApproach(int n) {
        if (n == 0) return 0;

        int[] countOfPrimeFactors = new int[n + 1];
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        for (int number = 2; number <= n; number++) {
            if (isPrime[number]) {
                for (int multipleOfNumber = number; multipleOfNumber <= n; multipleOfNumber += number) {
                    countOfPrimeFactors[multipleOfNumber]++;
                    isPrime[multipleOfNumber] = false;
                }
            }
        }


        long countOfLukcyNumbers = 0;
        for (int number = 2; number <= n; number++) if (countOfPrimeFactors[number] == 2) countOfLukcyNumbers++;
        return (int) countOfLukcyNumbers;
    }
}
