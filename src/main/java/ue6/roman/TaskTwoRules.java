package ue6.roman;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTwoRules {
    public static final int ROM_MAX = 3999;

    // Test if conversion works for easy stuff
    @Test
    void basicNumbers() {
        Roman roman = new Roman("I");
        assertEquals(1, roman.getInteger());

        roman = new Roman("X");
        assertEquals(10, roman.getInteger());
    }

    // Number range exceptions
    @Test
    void noNegativeNumbersOrZeroIntConstructor() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Roman(-1));
        assertEquals("Eingabe ist negativ oder 0", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Roman(0));
        assertEquals("Eingabe ist negativ oder 0", exception.getMessage());
    }

    @Test
    void noNegativeNumbersOrZeroStringConstructor() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Roman(""));
        assertEquals("Zahl entspricht nicht dem römischen Zahlenformat", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Roman("-IV"));
        assertEquals("Zahl entspricht nicht dem römischen Zahlenformat", exception.getMessage());
    }

    // Conversions
    @Test
    void conversionStringToInt() {
        Roman roman = new Roman("IX");
        assertEquals(9, roman.getInteger());

        roman = new Roman("XII");
        assertEquals(12, roman.getInteger());
    }

    @Test
    void conversionIntToString() {
        Roman roman = new Roman(13);
        assertEquals("XIII", roman.toString());
    }

    // Conversion Exceptions
    @Test
    void noNumbersOver3999() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Roman("MMMMCMXCIX"));
        assertEquals("Zahl entspricht nicht dem römischen Zahlenformat", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Roman(4000));
        assertEquals("Eingabe ist größer als " + ROM_MAX, exception.getMessage());
    }

    // Basic arithmetic operations
    @Test
    void add() {
        Roman roman = new Roman(20);
        Roman roman2 = new Roman(20);
        assertEquals(40, roman.add(roman2).getInteger());
    }

    @Test
    void substract() {
        Roman roman = new Roman(20);
        Roman roman2 = new Roman(9);
        assertEquals(11, roman.subtract(roman2).getInteger());
    }

    @Test
    void multiply() {
        Roman roman = new Roman(20);
        Roman roman2 = new Roman(20);
        assertEquals(400, roman.multiply(roman2).getInteger());
    }

    @Test
    void divide() {
        Roman roman = new Roman(20);
        Roman roman2 = new Roman(20);
        assertEquals(1, roman.divide(roman2).getInteger());
    }

    @Test
    void noNegativeSubtraction() {
        Roman roman = new Roman("XI");
        Roman roman2 = new Roman("XII");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> roman.subtract(roman2));
        assertEquals("Eingabe ist negativ oder 0", exception.getMessage());
    }

    @Test
    void compare() {
        Roman roman = new Roman("XI");
        Roman roman2 = new Roman("XII");

        assertNotEquals(roman, roman2);

        roman2 = new Roman("XI");
        assertEquals(roman, roman2);

        // oder ohne assertEquals
        if (roman.equals(roman2)) {
            System.out.println("Ja, ist gleich");
        } else {
            System.out.println("Nein, ist nicht gleich");
        }

        roman2 = roman;
        assertEquals(roman, roman2);
    }
}
