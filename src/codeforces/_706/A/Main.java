package codeforces._706.A;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = true;

    private void solve() {
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();

        if (k * 2 >= n) {
            out.println("NO");
            return;
        }


        for (int i = 0; i < k; ++i) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                out.println("NO");
                return;
            }
        }
        out.println("YES");
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