package projecteuler._56;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {

        int ans = 0;
        for (int a = 0; a < 100; ++a) {
            for (int b = 0; b < 100; ++b) {
                BigInteger v = BigInteger.valueOf(a);
                BigInteger x = BigInteger.valueOf(a);
                for (int i = 0; i < b; ++i) {
                    v = v.multiply(x);
                    int sum = 0;
                    for (char c : v.toString().toCharArray()) {
                        sum += c - '0';
                    }
                    ans = Math.max(ans, sum);
                }
            }
        }
        System.out.println(ans);
    }
}
