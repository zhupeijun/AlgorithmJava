package atcoder.ABC._190.D;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private void solve() {
        long N = sc.nextLong();

        int ans = 0;
        long n = 1;
        while (true) {
            long v = N * 2 + n - n * n;
            if (v <= 0) {
                break;
            }

            if (v % (2 * n) == 0) {
                ++ans;
            }
            ++n;
        }
        out.println(ans * 2);
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
