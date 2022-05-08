package ue1;

public class Submission3 {
    static int prost(int n) {
        if (n <= 1) {
            return 0;
        }
        return prost(n - 1) + n - 1;
    }
}
