package main;

public class PrimeCalculator {

    // Metod för att räkna antalet primtal inom ett givet intervall
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

    // Metod för att summera primtalen inom ett givet intervall
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

    // Metod för att skriva ut antalet primtal
    public void printCount(int count) {
        System.out.println("Hej, det finns " + count + " primtal mellan 0 och 1000!");
    }

    // Metod för att skriva ut summan av primtalen
    public void printSum(int sum) {
        System.out.println("Och den totala summan av dessa primtal är " + sum + ".");
    }

    // Hjälpmetod för att kontrollera om ett tal är ett primtal
    private boolean isPrime(int number) {
        if (number < 2) return false; // Tal mindre än 2 är inte primtal
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false; // Om det går jämt upp är det inte ett primtal
        }
        return true; // Annars är det ett primtal
    }
}
