package atcoder.ABC.zone2021.F;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;
    private void solve() {
        int N = sc.nextInt();
        int M = sc.nextInt();

        int n = Integer.bitCount(N-1);
        boolean[] used = new boolean[N];
        for (int i = 0; i < M; ++i) {
            used[sc.nextInt()] = true;
        }

        int[] val = new int[n];
        int[] tmp = new int[n];
        for (int i = 1; i < N; ++i) {
            if (!used[i]) {
                int x = i;
                for (int j = n-1; j >= 0; --j) {
                    if ((x&1<<j) > 0) {
                        x ^= tmp[j];
                    }
                }

                if (x > 0) {
                    int bit = Integer.highestOneBit(x);
                    int p = Integer.bitCount(bit-1);
                    val[p] = i;
                    tmp[p] = x;
                }
            }
        }

        for (int i = 0; i < n; ++i) {
            if (val[i] == 0) {
                out.println(-1);
                return;
            }
        }

        int u = 0;
        for (int i = 1; i < N; ++i) {
            int p = Integer.bitCount((i&-i)-1);
            int v = u ^ val[p];
            out.println(u + " " + v);
            u = v;
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
