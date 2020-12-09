package codeforces._635.E;

import java.io.*;
import java.util.*;

public class Main {
    private static final int MOD = 998244353;

    private void solve() {
        String s = sc.next();
        String t = sc.next();

        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            if (i >= m || s.charAt(0) == t.charAt(i)) {
                dp[0][i] = 1;
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                int f = j - 1;
                if (f >= m || (f >= 0 && s.charAt(i + 1) == t.charAt(f))) {
                    dp[i + 1][f] += dp[i][j];
                    dp[i + 1][f] %= MOD;
                }

                int b = j + i + 1;
                if (b < n && (b >= m || s.charAt(i + 1) == t.charAt(b))) {
                    dp[i + 1][j] += dp[i][j];
                    dp[i + 1][j] %= MOD;
                }
            }
        }

        int ans = 0;
        for (int i = m - 1; i < n; i++) {
            ans += dp[i][0];
            ans %= MOD;
        }
        ans = (ans + ans) % MOD;
        out.println(ans);
    }

    private static PrintWriter out;
    private static MyScanner sc;

    private static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        private MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    public static void main(String[] args) {
        out = new PrintWriter(new BufferedOutputStream(System.out));
        sc = new MyScanner();
        new Main().solve();
        out.close();
    }
}
