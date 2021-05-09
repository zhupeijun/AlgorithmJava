package atcoder.ABC._198.C;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private void solve() {
        long R = sc.nextInt();
        long X = sc.nextInt();
        long Y = sc.nextInt();

        long cur = 0;
        long d = X*X+Y*Y;
        int ans = 0;
        while (cur * cur < d) {
            cur += R;
            ++ans;
        }

        if (ans == 1) {
            if (cur * cur != d) {
                ++ans;
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