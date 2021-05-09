package atcoder.ABC.zone2021;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;
    private static final int M = 5;

    private boolean check(int[] cnt) {
        int tot = cnt.length;
        for (int i = 0; i < tot; ++i) {
            --cnt[i];
            for (int j = i; j < tot; ++j) {
                --cnt[j];
                for (int k = j; k < tot; ++k) {
                    --cnt[k];
                    if ((i | j | k) == tot - 1) {
                        if (cnt[i] >= 0 && cnt[j] >= 0 && cnt[k] >= 0) {
                            return true;
                        }
                    }
                    ++cnt[k];
                }
                ++cnt[j];
            }
            ++cnt[i];
        }
        return false;
    }

    private void solve() {
        int N = sc.nextInt();

        int[][] A = new int[N][M];

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                A[i][j] = sc.nextInt();
            }
        }

        final int tot = 1 << M;
        int l = 1, r = 1000_000_000;
        while (l <= r) {
            int mid = (l+r)/2;
            int[] cnt = new int[tot];
            for (int i = 0; i < N; ++i) {
                int v = 0;
                for (int j = 0; j < M; ++j) {
                    if (A[i][j] >= mid) {
                        v |= 1 << j;
                    }
                }
                ++cnt[v];
            }

            if (check(cnt)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        out.println(r);
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
