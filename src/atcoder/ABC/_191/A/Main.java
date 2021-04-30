package atcoder.ABC._191.A;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private void solve() {
        int V = sc.nextInt();
        int T = sc.nextInt();
        int S = sc.nextInt();
        int D = sc.nextInt();

        int st = T * V, ed = S * V;
        boolean ans = D >= st && D <= ed;
        out.println(ans ? "No" : "Yes");
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
