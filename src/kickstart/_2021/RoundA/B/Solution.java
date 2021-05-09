package kickstart._2021.RoundA.B;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Solution {
    private static final boolean N_CASE = true;

    private void solve() {
        int R = sc.nextInt();
        int C = sc.nextInt();
        int[][] a = sc.nextIntArray(R, C);

        int[][] l = new int[R][C];
        int[][] r = new int[R][C];
        int[][] t = new int[R][C];
        int[][] d = new int[R][C];

        for (int i = 0; i < R; ++i) for (int j = 0; j < C; ++j) {
            if (a[i][j] == 1) l[i][j] = 1 + (j == 0 ? 0 : l[i][j-1]);
        }

        for (int i = 0; i < R; ++i) for (int j = C-1; j >= 0; --j) {
            if (a[i][j] == 1) r[i][j] = 1 + (j == C-1 ? 0 : r[i][j+1]);
        }

        for (int j = 0; j < C; ++j) for (int i = 0; i < R; ++i) {
            if (a[i][j] == 1) t[i][j] = 1 + (i == 0 ? 0 : t[i-1][j]);
        }

        for (int j = 0; j < C; ++j) for (int i = R-1; i >= 0; --i) {
            if (a[i][j] == 1) d[i][j] = 1 + (i == R-1 ? 0 : d[i+1][j]);
        }

        int ans = 0;
        for (int i = 0; i < R; ++i) {
            for (int j = 0; j < C; ++j) {
                if (a[i][j] == 0) continue;

                int tn = Math.max(t[i][j] - 2, 0) / 2;
                int rn = r[i][j]-1;
                int ln = l[i][j]-1;
                ans += Math.min(tn, rn);
                ans += Math.min(tn, ln);

                tn = t[i][j]-1;
                rn = Math.max(r[i][j]-2, 0) / 2;
                ln = Math.max(l[i][j]-2, 0) / 2;
                ans += Math.min(tn, rn);
                ans += Math.min(tn, ln);

                int dn = Math.max(d[i][j]-2,0) / 2;
                rn = r[i][j]-1;
                ln = l[i][j]-1;
                ans += Math.min(dn, rn);
                ans += Math.min(dn, ln);

                dn = d[i][j]-1;
                rn = Math.max(r[i][j]-2, 0) / 2;
                ln = Math.max(l[i][j]-2, 0) / 2;
                ans += Math.min(dn, rn);
                ans += Math.min(dn, ln);
            }
        }
        out.println(ans);
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