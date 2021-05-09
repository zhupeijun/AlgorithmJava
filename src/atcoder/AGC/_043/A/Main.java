package atcoder.AGC._043.A;

import java.io.*;
import java.util.*;

public class Main {
    private void solve() {
        int H = sc.nextInt();
        int W = sc.nextInt();

        String[] g = new String[H];
        for (int i = 0; i < H; i++) {
            g[i] = sc.next();
        }

        int[][] dp = new int[H][W];
        for (int i = 0; i < H; i++) {
            Arrays.fill(dp[i], 10000000);
        }

        dp[0][0] = g[0].charAt(0) == '#' ? 1 : 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (g[i].charAt(j) == '#') {
                    if (i > 0) {
                        if (g[i - 1].charAt(j) == '#') {
                            dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
                        } else {
                            dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                        }
                    }

                    if (j > 0) {
                        if (g[i].charAt(j - 1) == '#') {
                            dp[i][j] = Math.min(dp[i][j], dp[i][j - 1]);
                        } else {
                            dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                        }
                    }
                } else {
                    if (i > 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
                    }

                    if (j > 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j - 1]);
                    }
                }
            }
        }

        out.println(dp[H - 1][W - 1]);
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
