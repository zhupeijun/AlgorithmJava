package atcoder.ABC._199.E;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private void solve() {
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] limit = new int[N+1][N+1];
        for (int i = 0; i <= N; ++i) {
            Arrays.fill(limit[i], 20);
        }

        for (int i = 0; i < M; ++i) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            int Z = sc.nextInt();

            limit[X][Y] = Math.min(Z, limit[X][Y]);
        }

        int maskMax = 1 << N;
        long[]dp = new long[maskMax];
        dp[0] = 1;
        for (int mask = 0; mask < maskMax; ++mask) {
            int[] cnt = new int[N];
            int tot = 0;
            for (int i = 0; i < N; ++i) {
                int bit = 1 << i;
                if ((mask & bit ) > 0) {
                    ++cnt[i];
                    ++tot;
                }
            }

            if (tot == N || dp[mask] == 0) continue;

            int[] pre = new int[N];
            for (int i = 0; i < N; ++i) {
                pre[i] = i == 0 ? cnt[i] : pre[i-1] + cnt[i]; 
            }

            for (int i = 0; i < N; ++i) {
                int bit = 1 << i;
                if ((mask & bit) > 0) continue;
                int nextMask = mask | bit;
                boolean ok = true;
                for (int j = 0; j < N; ++j) {
                    int add = i <= j ? 1 : 0;
                    if (pre[j] + add > limit[tot+1][j+1]) {
                        ok = false;
                        break;
                    }
                }

                if (ok) {
                    dp[nextMask] += dp[mask];
                }
            }
        }
        out.println(dp[maskMax-1]);
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
