package atcoder.ABC._190.C;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private void solve() {
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] A = new int[M];
        int[] B = new int[M];
        for (int i = 0; i < M; ++i) {
            A[i] = sc.nextInt();
            B[i] = sc.nextInt();
        }

        int K = sc.nextInt();
        int[] C = new int[K];
        int[] D = new int[K];
        for (int i = 0; i < K; i++) {
            C[i] = sc.nextInt();
            D[i] = sc.nextInt();
        }
        
        int maskMax = 1 << K;
        int ans = 0;
        for (int i = 0; i < maskMax; ++i) {
            int[] dish = new int[N+1];
            for (int j = 0; j < K; ++j) {
                if (((1 << j) & i) > 0) {
                    ++dish[C[j]];
                } else {
                    ++dish[D[j]];
                }
            }

            int cnt = 0;
            for (int j = 0; j < M; ++j) {
                if (dish[A[j]] > 0 && dish[B[j]] > 0) {
                    ++cnt;
                }
            }
            ans = Math.max(ans, cnt);
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
