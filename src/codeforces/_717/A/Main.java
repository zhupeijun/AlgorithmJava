package codeforces._717.A;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = true;

    private void solve() {
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] a = sc.nextIntArray(n);
        
        for (int i = 0; i < n-1 && k > 0; ++i) {
            int sub = Math.min(k, a[i]);
            a[i] -= sub;
            a[n-1] += sub;
            k -= sub;
        }

        out.printArray(a);
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
