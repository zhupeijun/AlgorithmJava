package codeforces._704.A;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = true;

    private long need(long x, long p) {
        long n = p / x;
        n = n * x < p ? n + 1 : n;
        return n * x - p;
    }

    private void solve() {
        long p = sc.nextLong();
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();

        long ans = need(a, p);
        ans = Math.min(ans, need(b, p));
        ans = Math.min(ans, need(c, p));
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
        cu = new CommonUtils();
        new Main().run();
        out.close();
    }
}
