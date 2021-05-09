package atcoder.ARC._113.A;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private void solve() {
        int K = sc.nextInt();
        long ans = 0;
        for (int i = 1; i <= K; ++i) {
            for (int j = 1; i * j <= K; ++j) {
                int a = i * j;
                ans += K / a;
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
