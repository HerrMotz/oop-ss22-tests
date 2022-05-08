package ue1;

public class Submission2 {
    static int fibonacci(int number) {
        int currentNumber = 1, previousNumber = 0;
        if (number == 0) {
            return 0;
        }
        for (int i = 1; i < number; i++) {
            currentNumber = currentNumber + previousNumber;
            previousNumber = currentNumber - previousNumber; // currentNumber - previousNumber = vorherige currentNumber
        }
        return currentNumber;
    }
}
