package ue8;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ue8.submission.MoveableGO;
import ue8.submission.Rectangle;
import ue8.submission.ResizeableGO;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TaskOneRules {

    public static class Pair<L,R> {
        private L l;
        private R r;
        public Pair(L l, R r){
            this.l = l;
            this.r = r;
        }
        public L getL(){ return l; }
        public R getR(){ return r; }
        public void setL(L l){ this.l = l; }
        public void setR(R r){ this.r = r; }
    }

    static Random random;
    static int randomIterations = 1000;

    static int positiveRandom() {
        return Math.abs(random.nextInt());
    }

    static float fractionalRandom() {
        return ((float)positiveRandom() / (float)positiveRandom()) * ((positiveRandom() < (positiveRandom()/2)) ? 1 : -1);
    }

    static int wholeRandom() {
        return positiveRandom() * ((positiveRandom() < (positiveRandom()/2)) ? 1 : -1);
    }

    @BeforeAll
    static void init() {
        random = new Random();
    }


    static Rectangle[] rectsGlobal = {
            new Rectangle(0, 0, 1, 1),
            new Rectangle(1, 1, 2, 2),
            new Rectangle(1, 4, 2, 3)
    };
    public static void resizeAll(float r, ResizeableGO[] rgo) {
        for (ResizeableGO g : rgo) g.resize(r);
    }
    public static void moveAll(float dx, float dy, MoveableGO[] mgo) {
        for (MoveableGO m : mgo) m.move(dx, dy);
    }

    @Test
    void negativeHeight() {
        // it's forbidden to create rectangles with negative height or width
        assertThrows(IllegalArgumentException.class, () ->
            new Rectangle(1, 4, 2, -1)
        );
    }

    @Test
    void negativeWidth() {
        // it's forbidden to create rectangles with negative height or width
        assertThrows(IllegalArgumentException.class, () ->
                new Rectangle(1, 4, -2, 1)
        );
    }

    @Test
    void moveAll() {
        // the rectangles have been moved by the given parameters dx, dy.
        // it is not allowed to set them to exactly dx, dy.

        Pair<Float, Float>[] coordinates = new Pair[randomIterations];
        Rectangle[] rectangles = new Rectangle[randomIterations];

        for (int i = 0; i < randomIterations; i++) {
            float x = fractionalRandom();
            float y = fractionalRandom();

            coordinates[i] = new Pair<>(x, y);
            rectangles[i] = new Rectangle(x, y, positiveRandom(), positiveRandom());
        }


        float dx = fractionalRandom();
        float dy = fractionalRandom();

        moveAll(dx, dy, rectangles);

        for (int i = 0; i < randomIterations; i++) {
            if (dx != rectangles[i].getX() &&
                dy != rectangles[i].getY()) {

                assertEquals(coordinates[i].getL() + dx, rectangles[i].getX());
                assertEquals(coordinates[i].getR() + dy, rectangles[i].getY());
            }
        }
    }

    @Test
    void resizeAll() {
        // the rectangles have been resized by the given parameter r.
        // this does not mean, that it has to be scaled (multiplied) by this parameter.
        // addition/subtraction is permitted.

        Pair<Integer, Integer>[] dimensions = new Pair[randomIterations];
        Rectangle[] rectangles = new Rectangle[randomIterations];

        for (int i = 0; i < randomIterations; i++) {
            int w = positiveRandom();
            int h = positiveRandom();

            dimensions[i] = new Pair<>(w, h);
            rectangles[i] = new Rectangle(positiveRandom(), positiveRandom(), w, h);
        }


        float r = fractionalRandom();
        resizeAll(r, rectangles);

        for (int i = 0; i < randomIterations; i++) {
            // test if it was added
            if (dimensions[i].getL() + r != rectangles[i].getW() &&
                dimensions[i].getR() + r != rectangles[i].getH()) {

                // test if it was multiplied
                assertEquals(dimensions[i].getL() * r, rectangles[i].getW());
                assertEquals(dimensions[i].getR() * r, rectangles[i].getH());

                // fails if neither is the case
            }
        }
    }
}
