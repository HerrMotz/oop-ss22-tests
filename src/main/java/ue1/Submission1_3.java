package ue1;

public class Submission1_3 {
    static int prost(int n) {
        if(n == 1)
        {
            return 1;
        }
        return (n + prost(--n));
    }
}
