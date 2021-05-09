package codechef.MARCH21B.SPACEARR;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = true;

    private void solve() {
        int N = sc.nextInt();
        int[] a = sc.nextIntArray(N);
        Arrays.sort(a);
        long tot = 0;
        for (int i = 0; i < N; i++) {
            if (a[i] > i + 1) {
                out.println("Second");
                return;
            } else {
                tot += i + 1 - a[i];
            }
        }
        out.println(tot % 2 == 0 ? "Second" : "First");
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