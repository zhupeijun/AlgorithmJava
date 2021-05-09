package projecteuler._57;

import java.math.BigInteger;

public class Main {
    private void solve() {
        BigInteger a = BigInteger.valueOf(1), b = BigInteger.valueOf(2);
        int ans = 0;
        for (int i = 1; i <= 1000; ++i) {
            BigInteger x = a.add(b);
            if (x.toString().length() > b.toString().length()) {
                ++ans;
            }

            BigInteger na = b;
            BigInteger nb = b.multiply(BigInteger.TWO).add(a);
            a = na;
            b = nb;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}
