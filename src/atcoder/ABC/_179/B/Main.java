package atcoder.ABC._179.B;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private void solve() {

        int N = sc.nextInt();
        int cnt = 0;
        boolean ans = false;
        for (int i = 0; i < N; i++) {
            int d1 = sc.nextInt();
            int d2 = sc.nextInt();

            if (d1 == d2) {
                ++cnt;
            } else {
                cnt = 0;
            }

            if (!ans && cnt >= 3) {
                ans = true;
            }
        }
        out.println(ans ? "Yes" : "No");
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
