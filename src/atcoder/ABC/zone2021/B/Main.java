package atcoder.ABC.zone2021.B;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private void solve() {
        int N = sc.nextInt();
        int D = sc.nextInt();
        int H = sc.nextInt();

        double ans = 0;
        for (int i = 0; i < N; ++i) {
            int d = sc.nextInt();
            int h = sc.nextInt();
            double a = 1.0 * (H - h) / (D - d);
            double b = H - a * D;

            ans = Math.max(ans, b);
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
