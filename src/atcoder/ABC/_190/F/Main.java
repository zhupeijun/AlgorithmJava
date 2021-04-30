package atcoder.ABC._190.F;

import java.io.*;
import java.util.*;

import library.algorithm.BIT;
import library.algorithm.Seg;
import library.basic.*;


public class Main {
    private static final boolean N_CASE = false;

    private void solve() {
        int N = sc.nextInt();
        int[] a = sc.nextIntArray(N);

        Seg seg = new Seg(N+2);
        BIT bit = new BIT(N+2);
        for (int i = 0; i < N; ++i) {
            int k = a[i] + 1;
            long invNum = bit.sum(N) - bit.sum(a[i]);
            seg.add(k, k + 1, invNum);
            bit.add(k, 1);
        }

        for (int i = 0; i < N; ++i) {
            out.println(seg.sum(1, N+1));
            int k = a[i] + 1;
            seg.add(1, k, -1);
            seg.add(k+1, N+1, 1);
        }
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
