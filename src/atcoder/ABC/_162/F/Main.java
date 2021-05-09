package atcoder.ABC._162.F;

import java.io.*;
import java.util.*;

public class Main {
    private void solve() {
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int m = n % 2 == 0 ? 2 : 3;
        long[][] dp = new long[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Long.MIN_VALUE);
        }
        dp[0][0] = a[0];
        dp[1][1] = a[1];

        if (n > 2) {
            dp[2][0] = a[0] + a[2];
            if (m == 3) {
                dp[2][2] = a[2];
            }
        }

        for (int i = 3; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    int pi = i - 2 - k;
                    int pj = j - k;
                    if (pi >= 0 && pj >= 0) {
                        dp[i][j] = Math.max(dp[pi][pj], dp[i][j]);
                    }
                }
                if (dp[i][j] != Long.MIN_VALUE) {
                    dp[i][j] += a[i];
                }
            }
        }

        long ans = Long.MIN_VALUE;
        for (int j = 0; j < m; j++) {
            int li = n - 1 - j;
            int lj = m - 1 - j;
            if (li >= 0) {
                ans = Math.max(ans, dp[li][lj]);
            }
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
