package atcoder.ABC._192.D;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private boolean check(String s, long base, long M) {
        long value = 0;
        long b = 1;
        int n = s.length();
        for (int i = n - 1; i >= 0; --i) {
            int d = s.charAt(i) - '0';
            if (i == n - 1) {
                value += d;
                continue;
            }

            if (base > M / b) {return false; }
            b *= base;
            if (b > M) { return false; }
            if (b * d > M) { return false; }
            value += b * d;
            if (value > M) { return false; }
        }
        return value <= M;
    }

    private void solve() {
        String s = sc.next();
        int n = s.length();
        long M = sc.nextLong();
        int d = s.chars().max().orElse(0) - '0';

        if (n == 1) {
            out.println(M >= d ? 1 : 0);
            return;
        }

        if (M <= d) {
            out.println(0);
            return;
        }

        long l = d + 1, r = M;

        while (l <= r) {
            long mid = (l + r) / 2;
            if (check(s, mid, M)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        out.println(r - d);
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
