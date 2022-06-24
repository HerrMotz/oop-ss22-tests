package ue7;

import com.sun.source.doctree.SinceTree;
import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {

    static int iterations = 1000;
    Random random = new Random(5765466);

    private String randomString(int length) {
        // create a string of all characters
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // create random string builder
        StringBuilder sb = new StringBuilder();

        // create an object of Random class
        Random random = new Random();

        for(int i = 0; i < length; i++) {

            // generate random index number
            int index = random.nextInt(alphabet.length());

            // get character specified by index
            // from the string
            char randomChar = alphabet.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }

        return sb.toString();
    }

    @Test
    void empty() {
        StringMenge stringMenge = new StringMengeImpl();

        System.out.println(stringMenge.getSize());

        assertTrue(stringMenge.isEmpty());
    }

    @Test
    void emptyAfterAddAndRemove() {
        StringMenge stringMenge = new StringMengeImpl();

        LinkedList<String> list = new LinkedList<>();

        for (int i = 0; i < iterations; i++) {
            String random1 = String.valueOf(random.nextInt());
            list.add(random1);

            stringMenge.add(random1);
        }

        for (String listItem: list) {
            stringMenge.remove(listItem);
        }

        assertTrue(stringMenge.isEmpty());
    }

    @Test
    void checkGetElements() {
        StringMenge stringMenge = new StringMengeImpl();

        Set<String> set = new HashSet<>();

        for (int i = 0; i < iterations; i++) {
            String random1 = String.valueOf(random.nextInt());
            set.add(random1);

            stringMenge.add(random1);
        }

        Iterator<String> iter1 = Arrays.stream(stringMenge.getElements()).sorted().iterator();
        Iterator<String> iter2 = set.stream().sorted().iterator();

        while(iter1.hasNext() && iter2.hasNext())
            assertEquals(iter1.next(), iter2.next());
        assert !iter1.hasNext() && !iter2.hasNext();
    }

    @Test
    void getSizeAndCheckDuplicates() {
        StringMenge stringMenge = new StringMengeImpl();

        Set<String> set = new HashSet<>();

        for (int i = 0; i < iterations; i++) {
            String random1 = String.valueOf(random.nextInt());

            int sizeBefore = stringMenge.getSize();

            stringMenge.add(random1);
            if (!set.add(random1)) {
                assertEquals(sizeBefore, stringMenge.getSize());
            }
        }
    }

    @Test
    void checkDuplicates() {
        StringMenge stringMenge = new StringMengeImpl();

        stringMenge.add("A");
        stringMenge.add("A");

        assertEquals(1, stringMenge.getSize());
    }

    @Test
    void checkCharCount() {
        StringMenge stringMenge = new StringMengeImpl();
        Set<String> set = new HashSet<>();

        int sum = 0;

        for (int i = 0; i < iterations; i++) {
            int length = random.nextInt(10);
            String generatedString = randomString(length);

            if (set.add(generatedString)) {
                sum += length;
                stringMenge.add(generatedString);
            }
        }

        assertEquals(sum, stringMenge.getCharCount());
    }

    @Test
    void add() {
        StringMengeImpl stringMenge = new StringMengeImpl();

        for (int i = 0; i < iterations; i++) {
            String random1 = String.valueOf(random.nextInt());
            stringMenge.add(random1);

            assertTrue(stringMenge.contains(random1));
        }
    }

    @Test
    void remove() {
        StringMenge stringMenge = new StringMengeImpl();

        for (int i = 0; i < iterations; i++) {
            String random1 = String.valueOf(random.nextInt());
            stringMenge.add(random1);
            stringMenge.remove(random1);

            assertFalse(stringMenge.contains(random1));
        }
    }

    @Test
    void print() {
        System.out.println("Hier soll eine Ausgabe kommen, sonst ABZUG!");

        StringMenge stringMenge = new StringMengeImpl();
        stringMenge.add("Das ist ja nice");
        stringMenge.add("Das ist ja nice");
        stringMenge.add("Das ist ja nice");
        stringMenge.print();
    }
}
