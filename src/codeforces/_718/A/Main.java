package codeforces._718.A;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = true;

    private void solve() {
        long base = 2050_000_000_000_000_000L;

        long x = sc.nextLong();
        long ans = 0;
        while (base >= 2050) {
            if (x >= base) {
                ans += x / base;
                x -= x / base * base;
            }
            base /= 10;
        }
        out.println(x == 0 ? ans : -1);
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
