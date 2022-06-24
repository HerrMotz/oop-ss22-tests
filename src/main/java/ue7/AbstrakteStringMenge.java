package ue7;

import java.util.Arrays;

abstract public class AbstrakteStringMenge implements StringMenge {
    @Override
    public int getCharCount() {
        String[] array = getElements();
        int counter = 0;
        for (String j : array) {
            counter += j.length();
        }
        return counter;
    }

    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    @Override
    public void print() {
        System.out.println(Arrays.toString(getElements()));
    }
}
