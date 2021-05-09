package codejam._2021.Round1A.B;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

import library.basic.*;

public class Solution {
    private static final boolean N_CASE = true;

    private void solve() {
        int M = sc.nextInt();
        int[] P = new int[M];
        long[] N = new long[M];

        long tot = 0;
        for (int i = 0; i < M; i++) {
            P[i] = sc.nextInt();
            N[i] = sc.nextLong();

            tot += P[i] * N[i];
        }

        long ans = 0;
        for (int i = 1; i <= 3500; ++i) {
            long sum = tot - i;
            if (sum <= 0) break;

            int[] cnt = new int[M];
            for (int j = 0; j < M; ++j) {
                while (sum % P[j] == 0) {
                    sum /= P[j];
                    ++cnt[j];
                }
            }

            if (sum == 1) {
                boolean ok = true;
                for (int j = 0; j < M; ++j) {
                    if (cnt[j] > N[j]) {
                        ok = false;
                        break;
                    }
                }

                if (ok) {
                    long t = tot - i;
                    BigInteger val = BigInteger.ONE;
                    BigInteger max = BigInteger.valueOf(t);
                    long s2 = 0;
                    for (int j = 0; j < M; ++j) {
                        for (int k = 0; k < cnt[j]; ++k) {
                            val = val.multiply(BigInteger.valueOf(P[j]));
                            if (val.compareTo(max) > 0) break;
                            s2 += P[j];
                        }
                        if (val.compareTo(max) > 0)break;
                    }

                    if (val.compareTo(max) == 0 && s2 == i) {
                        ans = t;
                        break;
                    }
                }
            }
        }
        out.println(ans);
    }

    private void run() {
        int T = N_CASE ? sc.nextInt() : 1;
        for (int t = 0; t < T; ++t) {
            out.print(String.format("Case #%d: ", t + 1));
            solve();
        }
    }

    private static MyWriter out;
    private static MyScanner sc;
    private static CommonUtils cu;

    public static void main(String[] args) {
        out = new MyWriter(new BufferedOutputStream(System.out));
        sc = new MyScanner();
        new Solution().run();
        out.close();
    }
}