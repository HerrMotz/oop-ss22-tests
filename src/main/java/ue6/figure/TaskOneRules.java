package ue6.figure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskOneRules {

    @Test
    void rectangleContained() {
        Rectangle rectangle = new Rectangle(0f, 0f, 10f, 10f);
        Rectangle rectangle2 = new Rectangle(0f, 0f, 8f, 8f);

        // one contains the other, but
        MobileObjekt.compareState state = rectangle.compare(rectangle2);
        assertEquals("CONTAINED", state.toString());

        rectangle2.increase(2f);

        state = rectangle.compare(rectangle2);
        assertEquals("CONTAINED", state.toString());
    }

    @Test
    void rectangleDisjoint() {
        Rectangle rectangle = new Rectangle(0f, 0f, 10f, 10f);
        Rectangle rectangle2 = new Rectangle(0f, 100f, 12f, 12f);

        MobileObjekt.compareState state = rectangle.compare(rectangle2);
        assertEquals("DISJOINT", state.toString());
    }

    @Test
    void rectangleSame() {
        Rectangle rectangle = new Rectangle(0f, 0f, 10f, 10f);

        MobileObjekt.compareState state = rectangle.compare(rectangle);
        assertEquals("SAME", state.toString());
    }

    @Test
    void rectangleAligned() {
        Rectangle rectangle = new Rectangle(0f, 0f, 10f, 10f);
        Rectangle rectangle2 = new Rectangle(0f, 10f, 10f, 10f);

        MobileObjekt.compareState state = rectangle.compare(rectangle2);
        assertEquals("ALIGNED", state.toString());

        rectangle2.move(1f, 10f);

        state = rectangle.compare(rectangle2);
        assertEquals("ALIGNED", state.toString());
    }

    @Test
    void move() {
        Rectangle rectangle = new Rectangle(0f, 0f, 1f, 1f);
        Rectangle rectangle2 = new Rectangle(0f, 0f, 1f, 1f);

        MobileObjekt.compareState state = rectangle.compare(rectangle2);
        assertEquals("SAME", state.toString());

        rectangle.move(2f, 1f);

        state = rectangle.compare(rectangle2);
        assertEquals("DISJOINT", state.toString());
    }

    @Test
    void increase() {
        Rectangle rectangle = new Rectangle(0f, 0f, 1f, 1f);
        assertFalse(rectangle.increase(0.1f));
        assertFalse(rectangle.increase(0f));
        assertFalse(rectangle.increase(-1f));

    }

    @Test
    void decrease() {
        Rectangle rectangle = new Rectangle(0f, 0f, 1f, 1f);
        assertTrue(rectangle.decrease(1f));
        assertFalse(rectangle.decrease(1.1f));
    }

    @Test
    void print() {
        Rectangle rectangle = new Rectangle(0f, 0f, 100f, 100f);
        rectangle.print();
    }
}
