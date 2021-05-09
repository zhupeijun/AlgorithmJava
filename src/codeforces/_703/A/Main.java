package codeforces._703.A;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = true;

    private void solve() {
        int n = sc.nextInt();
        long[] h = sc.nextLongArray(n);

        for (int i = 0; i < n; ++i) {
            if (h[i] < i) {
                out.println("NO");
                return;
            }
            if (i + 1 < n) {
                h[i + 1] += h[i] - i;
            }
        }
        out.println("YES");
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