package atcoder.ABC._191.D;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private long ceil(long x) {
        return x > 0 ? (x + 9999) / 10000 : x / 10000;
    }

    private long floor(long x) {
        return x > 0 ? x / 10000 : (x - 9999) / 10000;
    }

    // 99999.4444 -> 9999.44439999999
    private long nextLong() {
        String s = sc.next();
        String[] p = s.split("\\.");
        long v = Long.parseLong(p[0]);
            for (int i = 0; i < 4; ++i) {
                v *= 10;
                if (p.length > 1) {
                    if (i < p[1].length()) {
                        v += p[1].charAt(i) - '0';
                    }
                }
            }
        return v;
    }

    private void solve() {
        long X = nextLong();
        long Y = nextLong();
        long R = nextLong();


        long ed = floor(Y + R);
        long st = ceil(Y - R);
        long ans = 0;
        for (long y = st; y <= ed; ++y) {
            long l = 0, r = floor(R) + 5;
            long lx = floor(X);
            while (l <= r) {
                long mid = (l + r) / 2;
                long tx = lx - mid;
                long ty = y;
                long dx = tx * 10000 - X;
                long dy = ty * 10000 - Y;

                if (dx * dx <= R * R - dy * dy) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            long left = lx - r;

            l = 0;
            r = floor(R) + 5;
            long rx = ceil(X);
            while (l <= r) {
                long mid = (l + r) / 2;
                long tx = rx + mid;
                long ty = y;
                long dx = tx * 10000 - X;
                long dy = ty * 10000 - Y;
                if (dx * dx <= R * R - dy * dy) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            long right = rx + r;

            if (right >= left) {
                ans += right - left + 1;
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
        cu = new CommonUtils();
        new Main().run();
        out.close();
    }
}
