package codeforces._638.E;

import java.io.*;
import java.util.*;

public class Main {
    private void solve() {
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        long total = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();

            total += a[i];
            total += b[i];
        }

        int[][] dp = new int[n][k];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int rrm = Math.min(k - 1, a[0]);
        for (int j = 0; j <= rrm; ++j) {
            int rb = (a[0] - j + b[0]) % k;
            if (rb > b[0]) {
                dp[0][j] = -1;
            } else {
                if (dp[0][j] == -1 || dp[0][j] > rb) {
                    dp[0][j] = rb;
                }
            }
        }

        for (int i = 1; i < n; ++i) {
            rrm = Math.min(k - 1, a[i]);
            for (int j = 0; j <= rrm; ++j) {
                int rb = (a[i] - j + b[i]) % k;
                if (rb > b[i]) {
                    continue;
                }

                for (int p = 0; p < k; ++p) {
                    if (dp[i - 1][p] == -1) {
                        continue;
                    }
                    int crr = (j + p) % k;
                    int crb = (rb + dp[i - 1][p]) % k;
                    if (dp[i][crr] == -1 || dp[i][crr] > crb) {
                        dp[i][crr] = crb;
                    }
                }
            }

            for (int p = 0; p < k; ++p) {
                if (dp[i - 1][p] == -1) {
                    continue;
                }

                int rr = (p + a[i]) % k;
                int rb = (dp[i - 1][p] + b[i]) % k;
                if (dp[i][rr] == -1 || dp[i][rr] > rb) {
                    dp[i][rr] = rb;
                }
            }
        }

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < k; j++) {
//                out.print(dp[i][j] + " ");
//            }
//            out.println();
//        }

        long max = 0;
        for (int j = 0; j < k; j++) {
            if (dp[n - 1][j] != -1) {
                max = Math.max(max, (total - j - dp[n - 1][j]) / k);
            }
        }
        out.println(max);
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
