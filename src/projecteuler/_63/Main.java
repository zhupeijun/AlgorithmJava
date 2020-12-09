package projecteuler._63;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {

        int ans = 1;
        for (int i = 2; i <= 9; ++i) {
            BigInteger x = BigInteger.valueOf(i);
            long n = 1;
            while (true) {
                int len = String.valueOf(x).length();
                if (len < n) {
                    break;
                }

                if (len == n) {
                    System.out.println(n + " " + i + " " + x);
                    ++ans;
                }
                ++n;
                x = x.multiply(BigInteger.valueOf(i));
            }
        }
        System.out.println(ans);
    }
}
