package codeforces._706.C;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = true;

    private void solve() {
        int n = sc.nextInt();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        int m = n * 2;
        for (int i = 0; i < m; i++) {
            int x = Math.abs(sc.nextInt());
            int y = Math.abs(sc.nextInt());

            if (x == 0) {
                a.add(y);
            } else {
                b.add(x);
            }
        }

        Collections.sort(a);
        Collections.sort(b);

        double ans = 0;
        for (int i = 0; i < n; i++) {
            double v1 = a.get(i);
            double v2 = b.get(i);
            ans += Math.sqrt(v1 * v1 + v2 * v2);
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