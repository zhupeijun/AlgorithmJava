package atcoder.ABC._197.C;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private void solve() {
        int N = sc.nextInt();
        int[] A = sc.nextIntArray(N);
        int M = 1 << (N - 1);
        int ans = Integer.MAX_VALUE;
        for (int mask = 0; mask < M; ++mask) {
            List<Integer> val = new ArrayList<>();
            int cur = 0;
            for (int j = 0; j < N; ++j) {
                cur |= A[j];
                if (j == N-1 || (mask & (1<<j)) > 0) {
                    val.add(cur);
                    cur = 0;
                }
            }

            int y = 0;
            for (int x : val) y ^= x;
            ans = Math.min(y, ans);
        }
        out.println(ans);
    }

    private void run() {
        int T = N_CASE ? sc.nextInt() : 1;
        for (int t = 0; t < T; ++t) {
            solve();
        }
    }

    private static MyWriter out;
    private static MyScanner sc;
    private static CommonUtils cu;

    public static void main(String[] args) {
        out = new MyWriter(new BufferedOutputStream(System.out));
        sc = new MyScanner();
        new Main().run();
        out.close();
    }
}