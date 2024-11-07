package test;

import main.PrimeCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PrimeCalculatorTest {

    private final PrimeCalculator calculator = new PrimeCalculator();

    @Test
    @DisplayName("printCount should print correct message")
    public void printCount_printsCorrectMessage() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        calculator.printCount(10);

        // Kontrollera resultatet med trim för att ta bort extra radbrytningar
        assertEquals("Det finns 10 primtal mellan 0 och 1000!", outContent.toString().trim());
    }

    @Test
    @DisplayName("printSum should print correct message")
    public void printSum_printsCorrectMessage() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        calculator.printSum(100);

        // Kontrollera resultatet med trim för att ta bort extra radbrytningar
        assertEquals("Och den totala summan av dessa primtal är 100.", outContent.toString().trim());
    }

    // Nytt test för att hantera ogiltig inmatning vid printCount
    @Test
    @DisplayName("printCount with negative count should throw exception")
    public void printCount_withNegativeCount_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.printCount(-1);
        }, "Expected an IllegalArgumentException for negative count value");
    }

    // Nytt test för att hantera ogiltig inmatning vid printSum
    @Test
    @DisplayName("printSum with negative sum should throw exception")
    public void printSum_withNegativeSum_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.printSum(-1);
        }, "Expected an IllegalArgumentException for negative sum value");
    }

    @Test
    @DisplayName("countPrimes with valid range returns correct count")
    public void countPrimes_withValidRange_returnsCorrectCount() {
        int result = calculator.countPrimes(10, 50);
        assertEquals(11, result, "Expected 11 prime numbers between 10 and 50");
    }

    @Test
    @DisplayName("sumPrimes with valid range returns correct sum")
    public void sumPrimes_withValidRange_returnsCorrectSum() {
        int result = calculator.sumPrimes(10, 50);
        assertEquals(311, result, "Expected sum of 311 for prime numbers between 10 and 50");
    }

    @Test
    @DisplayName("countPrimes with start greater than end should throw exception")
    public void countPrimes_withStartGreaterThanEnd_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.countPrimes(50, 10);
        }, "Expected an IllegalArgumentException when start is greater than end");
    }

    @Test
    @DisplayName("sumPrimes with out-of-bounds range should throw exception")
    public void sumPrimes_withOutOfBoundsRange_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.sumPrimes(1001, 2000);
        }, "Expected an IllegalArgumentException for input outside valid range");
    }

    // Tester för att täcka alla grenar i isPrime-metoden
    @Test
    @DisplayName("isPrime should return false for numbers less than 2")
    public void isPrime_returnsFalse_forNumbersLessThan2() {
        assertFalse(calculator.isPrime(1), "Expected false for number 1");
        assertFalse(calculator.isPrime(0), "Expected false for number 0");
        assertFalse(calculator.isPrime(-5), "Expected false for negative number -5");
    }

    @Test
    @DisplayName("isPrime should return true for number 2")
    public void isPrime_returnsTrue_forNumber2() {
        assertTrue(calculator.isPrime(2), "Expected true for number 2");
    }

    @Test
    @DisplayName("isPrime should return false for even numbers greater than 2")
    public void isPrime_returnsFalse_forEvenNumbersGreaterThan2() {
        assertFalse(calculator.isPrime(4), "Expected false for number 4");
        assertFalse(calculator.isPrime(10), "Expected false for number 10");
    }

    @Test
    @DisplayName("isPrime should return true for odd prime numbers")
    public void isPrime_returnsTrue_forOddPrimeNumbers() {
        assertTrue(calculator.isPrime(17), "Expected true for prime number 17");
        assertTrue(calculator.isPrime(31), "Expected true for prime number 31");
    }

    @Test
    @DisplayName("isPrime should return false for odd non-prime numbers")
    public void isPrime_returnsFalse_forOddNonPrimeNumbers() {
        assertFalse(calculator.isPrime(9), "Expected false for number 9");
        assertFalse(calculator.isPrime(15), "Expected false for number 15");
    }

    // Nytt test för gränsfall för isPrime
    @Test
    @DisplayName("isPrime should handle boundary cases correctly")
    public void isPrime_handlesBoundaryCases() {
        assertTrue(calculator.isPrime(3), "Expected true for prime number 3");
        assertFalse(calculator.isPrime(25), "Expected false for non-prime number 25");
    }
}
