package main;

public class PrimeCalculator {

    public int countPrimes(int start, int end) {
        if (start < 0 || end > 1000 || start > end) {
            throw new IllegalArgumentException("Hoppsan, fel intervall angivet!");
        }
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    public int sumPrimes(int start, int end) {
        if (start < 0 || end > 1000 || start > end) {
            throw new IllegalArgumentException("Hoppsan, fel intervall angivet!");
        }
        int sum = 0;
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }
        return sum;
    }

    public void printCount(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("Antalet primtal kan inte vara negativt!");
        }
        System.out.println("Det finns " + count + " primtal mellan 0 och 1000!");
    }

    public void printSum(int sum) {
        if (sum < 0) {
            throw new IllegalArgumentException("Summan av primtal kan inte vara negativ!");
        }
        System.out.println("Och den totala summan av dessa primtal är " + sum + ".");
    }

    public boolean isPrime(int number) {
        if (number < 2) return false;
        if (number == 2) return true;
        if (number % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) return false;
        }
        return true;
    }


}
