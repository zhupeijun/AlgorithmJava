package atcoder.ARC._114.C;

import java.io.*;
import java.util.*;

import library.algorithm.Mint;
import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;
    private static final Mint MT = new Mint(()->998244353);

    private void solve() {
        int N = sc.nextInt();
        int M = sc.nextInt();

        long[] p = new long[N+1]; p[0] = 1;
        for (int i = 1; i <= N; ++i) {
            p[i] = MT.mul(p[i-1], M);
        }

        long ans = MT.mul(N, p[N]);
        for (int v = 1; v <= M; ++v) {
            long t2 = 0;
            for (int i = 1; i < N; ++i) {
                t2 = MT.add(MT.mul(t2, M-v), p[i-1]);
                ans = MT.sub(ans, MT.mul(t2, p[N-1-i]));
            }
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