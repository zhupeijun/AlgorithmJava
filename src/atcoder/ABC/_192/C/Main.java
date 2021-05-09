package atcoder.ABC._192.C;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private void solve() {
        long cur = sc.nextInt();
        int K = sc.nextInt();
        for (int i = 0; i < K; ++i) {
            char[] c = String.valueOf(cur).toCharArray();
            Arrays.sort(c);
            String s = String.valueOf(c);
            long v1 = Long.parseLong(s);

            String s2 = new StringBuilder(s).reverse().toString();
            long v2 = Long.parseLong(s2);

            cur = v2 - v1;
        }

        out.println(cur);
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
