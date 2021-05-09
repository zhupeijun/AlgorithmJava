package projecteuler._66;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private void solve() {
        for (int i = 79; ; ++i) {
            for (int j = 2; j * j <= i; ++j) {
                if (i % j == 0 && gcd(j, i / j) == 1) {
                    System.out.println(i + " " + j + " " + (i/j));
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}
