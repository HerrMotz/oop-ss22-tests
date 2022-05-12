package ue1;

public class SubmissionFibonacci2 {
    static int studentFibonacci(int n) {
        int currentNumber = 1, previousNumber = 0;
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 0;
        }
        for (int i = 1; i < n; i++) {
            currentNumber = currentNumber + previousNumber;
            previousNumber = currentNumber - previousNumber; // currentNumber - previousNumber = vorherige currentNumber
        }
        return currentNumber;
    }
}
