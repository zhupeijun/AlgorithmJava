package atcoder.ABC._193.B;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private void solve() {
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] P = new int[N];
        int[] X = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
            P[i] = sc.nextInt();
            X[i] = sc.nextInt();
        }

        int minPrice = -1;
        for (int i = 0; i < N; i++) {
            int r = X[i] - A[i];
            if (r > 0) {
                if (minPrice == -1 || minPrice > P[i]) {
                    minPrice = P[i];
                }
            }
        }
        out.println(minPrice);
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
