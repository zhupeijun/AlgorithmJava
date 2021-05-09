// BEGIN CUT HERE
package topcoder.SRM802;
// END CUT HERE

import java.util.*;
import java.util.function.IntSupplier;

public class DisjointDiceValues {
    private long pow(long a, int n) {
        long ret = 1;
        for (int i = 0; i < n; ++i) {
            ret *= a;
        }
        return ret;
    }

    private long c(long n, long m) {
        if (m == 0 || n == m) return 1;
        else return c(n-1, m) + c(n-1, m-1);
    }

    public double getProbability(int A, int B) {
        int M = A+B;
        long tot = pow(6, M);

        long sel = 0;
        for (int i = 1; i <= 5; ++i) {
            if (i <= A) {
                long val = 0;
                for (int k = i, sign = 1; k > 0; --k, sign = -sign) {
                    val += pow(k, A) * c(i, i-k) * sign;
                }
                sel += c(6,i) * val * pow(6-i, B);
            }
        }

        return 1.0 * (tot - sel) / tot;
    }
}
