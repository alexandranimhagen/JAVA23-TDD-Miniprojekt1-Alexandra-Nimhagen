package test;

import main.PrimeCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrimeCalculatorTest {

    private final PrimeCalculator calculator = new PrimeCalculator();

    @Test
    @DisplayName("printCount should print correct message")
    public void printCount_printsCorrectMessage() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        calculator.printCount(10);

        // Kontrollera resultatet med trim för att ta bort extra radbrytningar
        assertEquals("Hej, det finns 10 primtal mellan 0 och 1000!", outContent.toString().trim());
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
}
