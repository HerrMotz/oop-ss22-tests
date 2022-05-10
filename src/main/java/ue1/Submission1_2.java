package ue1;

public class Submission1_2 {
    static int studentFibonacci(int n) {
        if (n < 0) {
            System.exit(-1);
        }
        if (n == 0) {
            return n;
        }
        int fib = 1;
        int lastFib = 0;

        for (int i = 1; i < n; i++) {
            int temp = fib;
            fib += lastFib;
            lastFib = temp;
        }
        return fib;
    }
}
