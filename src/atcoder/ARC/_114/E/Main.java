package atcoder.ARC._114.E;

import java.io.*;
import java.util.*;

import library.algorithm.Mint;
import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;
    private static final Mint MT = new Mint(()->998244353);

    private void solve() {
        int H = sc.nextInt();
        int W = sc.nextInt();
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();

        int A = Math.min(x1, x2) - 1;
        int B = W - Math.max(y1, y2);
        int C = H - Math.max(x1, x2);
        int D = Math.min(y1, y2) - 1;
        int E = Math.abs(x1 - x2) + Math.abs(y1-y2);

        long ans = 1;
        for (int i = 1; i <= A; ++i) ans = MT.add(ans, MT.div(1, i+E));
        for (int i = 1; i <= B; ++i) ans = MT.add(ans, MT.div(1, i+E));
        for (int i = 1; i <= C; ++i) ans = MT.add(ans, MT.div(1, i+E));
        for (int i = 1; i <= D; ++i) ans = MT.add(ans, MT.div(1, i+E));

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