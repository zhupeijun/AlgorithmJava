package codeforces._704.A;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = true;

    private long need(long p, long a) {
        if (p % a == 0) return 0;
        else return p / a * a + a - p;
    }

    private void solve() {
        long p = sc.nextLong();
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();

        long ans = Long.MAX_VALUE;
        ans = Math.min(ans, need(p, a));
        ans = Math.min(ans, need(p, b));
        ans = Math.min(ans, need(p, c));
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