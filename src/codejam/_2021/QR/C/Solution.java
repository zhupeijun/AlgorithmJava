package codejam._2021.QR.C;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Solution {
    private static final boolean N_CASE = true;

    private void solve() {
        int N = sc.nextInt();
        int C = sc.nextInt();

        int max = (1+N)*N/2-1;
        int min = N-1;
        if (C < min || C > max) {
            out.println("IMPOSSIBLE");
            return;
        }

        int[] A = new int[N+1];
        for (int i = 0; i < N; ++i) A[i] = i + 1;
        int cur = 3, last = cur;
        while (C > min) {
            int[] g = new int[cur];
            int l = 0, r = cur-1, t = 1, turn = 1;
            while (l <= r) {
                if (turn == 1) g[r--] = t;
                else g[l++] = t;
                ++t; turn ^= 1;
            }

            A[cur-1] = last;
            for (int i = 0, j = 0; i < cur; ++i) {
                if (g[i] != last) {
                    A[j++] = g[i];
                }
            }

            if (last == 2) {
                ++cur;
                last = cur;
            } else {
                --last;
            }
            --C;
        }

        for (int i = 0; i < N; ++i) {
            out.print(A[i]);
            out.print(i == N - 1 ? "\n" : " ");
        }
    }

    private void run() {
        int T = N_CASE ? sc.nextInt() : 1;
        for (int t = 0; t < T; ++t) {
            out.print(String.format("Case #%d: ", t + 1));
            solve();
        }
    }

    private static MyWriter out;
    private static MyScanner sc;
    private static CommonUtils cu;

    public static void main(String[] args) {
        out = new MyWriter(new BufferedOutputStream(System.out));
        sc = new MyScanner();
        new Solution().run();
        out.close();
    }
}