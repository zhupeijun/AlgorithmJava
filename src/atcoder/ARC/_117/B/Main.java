package atcoder.ARC._117.B;

import java.io.*;
import java.util.*;

import library.algorithm.Mint;
import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;
    private static final Mint Mt = new Mint();

    private void solve() {
        int N = sc.nextInt();
        List<Integer> a = sc.nextList(N);
        Collections.sort(a);

        long ans = 1;
        for (int i = 0; i < N; ++i) {
            int diff = a.get(i) - (i == 0 ? 0 : a.get(i-1)) + 1;
            ans = Mt.mul(ans, diff);
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