package atcoder.ABC._194.B;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private void solve() {
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
            B[i] = sc.nextInt();
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; j++) {
                int tot = 0;
                if (i != j) {
                    tot = Math.max(A[i], B[j]);
                } else {
                    tot = A[i] + B[j];
                }
                ans = Math.min(ans, tot);
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
        new Main().run();
        out.close();
    }
}