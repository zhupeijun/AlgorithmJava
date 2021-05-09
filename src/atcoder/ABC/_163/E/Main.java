package atcoder.ABC._163.E;

import java.io.*;
import java.util.*;

public class Main {
    private void solve() {
        int n = sc.nextInt();
        List<int[]> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] p = new int[2];
            p[0] = sc.nextInt();
            p[1] = i;
            a.add(p);
        }
        a.sort((x, y) -> y[0] - x[0]);

        long[][] dp = new long[n][n + 1];

        for (int i = 0; i < n; i++) {
            int[] p = a.get(i);
            int m = i + 1;
            dp[i][0] = (i == 0 ? 0 : dp[i - 1][0]) + (long) p[0] * (n - m - p[1]);
            dp[i][m] = (i == 0 ? 0 : dp[i - 1][m - 1]) + (long) p[0] * (p[1] - i);
        }

        for (int i = 1; i < n; i++) {
            int[] p = a.get(i);
            int m = i + 1;
            for (int l = 0; l <= m; l++) {
                if (l > 0) {
                    dp[i][l] = Math.max(dp[i][l], dp[i - 1][l - 1] + (long) p[0] * (p[1] - (l - 1)));
                }

                if (l < m) {
                    dp[i][l] = Math.max(dp[i][l], dp[i - 1][l] + (long) p[0] * (n - (m - l) - p[1]));
                }
            }
        }

        long ans = 0;
        for (int l = 0; l <= n; l++) {
            ans = Math.max(ans, dp[n - 1][l]);
        }
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
