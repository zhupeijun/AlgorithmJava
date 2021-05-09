package codejam._2021.QR.B;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Solution {
    private static final boolean N_CASE = true;
    private static final int INF = 1000_0000;

    private void solve() {
        int X = sc.nextInt();
        int Y = sc.nextInt();
        String s = sc.next();

        int n = s.length();
        int[][] dp = new int[n+1][2];
        cu.fill(dp, INF);

        char first = s.charAt(0);
        if (first == 'C') dp[1][0] = 0;
        else if (first == 'J') dp[1][1] = 0;
        else dp[1][0] = dp[1][1] = 0;

        for (int i = 2; i <= n; ++i) {
            char c = s.charAt(i-1);

            if (c == 'C') {
                dp[i][0] = Math.min(dp[i][0], dp[i-1][1] + Y);
                dp[i][0] = Math.min(dp[i][0], dp[i-1][0]);
            } else if (c == 'J') {
                dp[i][1] = Math.min(dp[i][1], dp[i-1][0] + X);
                dp[i][1] = Math.min(dp[i][1], dp[i-1][1]);
            } else {
                dp[i][0] = Math.min(dp[i][0], dp[i-1][1] + Y);
                dp[i][0] = Math.min(dp[i][0], dp[i-1][0]);
                dp[i][1] = Math.min(dp[i][1], dp[i-1][0] + X);
                dp[i][1] = Math.min(dp[i][1], dp[i-1][1]);
            }
        }

        out.println(Math.min(dp[n][0], dp[n][1]));
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
        cu = new CommonUtils();
        new Solution().run();
        out.close();
    }
}