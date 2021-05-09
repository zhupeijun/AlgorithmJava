package codeforces._639.B;

import java.io.*;
import java.util.*;

public class Main {
    private static final int M = 30000;
    private int[] a = new int[M];
    private void init() {
        a[1] = 2;
        for (int i = 2; i < M; i++) {
            a[i] = a[i - 1] + 3 * i - 1;
        }
    }

    private void solve() {
        int n = sc.nextInt();
        int ans = 0;
        for (int i = M - 1; i > 0; --i) {
            while (a[i] <= n) {
                ++ans;
                n -= a[i];
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
