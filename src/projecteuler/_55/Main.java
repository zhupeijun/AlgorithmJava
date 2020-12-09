package projecteuler._55;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Main {

    private static boolean check(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }

    private static boolean checkInt(int x) {
        BigInteger v = BigInteger.valueOf(x);
        for (int i = 1; i <= 50; ++i) {
            BigInteger r = new BigInteger(new StringBuilder(String.valueOf(v)).reverse().toString());
            v = v.add(r);
            if (check(String.valueOf(v))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int cnt = 0;
        for (int i = 0; i < 10000; ++i) {
            if (!checkInt(i)) {
                ++cnt;
            }
        }
        System.out.println(cnt);
    }
}
