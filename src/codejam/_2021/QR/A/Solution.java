package codejam._2021.QR.A;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Solution {
    private static final boolean N_CASE = true;

    private void solve() {
        int N = sc.nextInt();
        int[] L = sc.nextIntArray(N);

        int cost = 0;
        for (int i = 0; i < N-1; ++i) {
            int mv = N+1, mj = -1;
            for (int j = i; j < N; ++j) {
                if (L[j] < mv) {
                    mv = L[j];
                    mj = j;
                }
            }
            int l = i, r = mj;
            while (l < r) {
                int t = L[l]; L[l] = L[r]; L[r] = t;
                ++l; --r;
            }
            cost += mj - i + 1;
        }
        out.println(cost);
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