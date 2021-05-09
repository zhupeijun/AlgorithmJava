package codeforces._641.B;

import java.io.*;
import java.util.*;

public class Main {
    private static final int N = 100005;

    private List<List<Integer>> d;
    private void init() {
        d = new ArrayList<>();
        for (int i = 1; i <= N; ++i) {
            List<Integer> t = new ArrayList<>();
            for (int j = 1; (long) j * j <= i; ++j) {
                if (i % j == 0) {
                    t.add(j);

                    if (i / j != j) {
                        t.add(i / j);
                    }
                }
            }
            d.add(t);
        }
    }

    private void solve() {
        int n = sc.nextInt();
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
        }

        int ans = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int p : d.get(i)) {
                if (s[p - 1] < s[i]) {
                    dp[i] = Math.max(dp[i], dp[p - 1] + 1);
                    ans = Math.max(ans, dp[i]);
                }
            }
        }
        out.println(ans);
    }

    private void run() {
        init();
        int T = sc.nextInt();
        for (int t = 0; t < T; ++t) {
            solve();
        }
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
        new Main().run();
        out.close();
    }
}
