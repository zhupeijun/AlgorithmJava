package codeforces.E85.A;

import java.io.*;
import java.util.*;

public class Main {
    private void solve() {
        int n = sc.nextInt();
        int[] p = new int[n];
        int[] c = new int[n];

        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
            c[i] = sc.nextInt();
        }

        boolean ans = true;
        for (int i = 0; i < n; ++i) {
            if (i > 0) {
                int t = c[i] - c[i - 1];
                if (t < 0 || t > p[i] - p[i - 1]) {
                    ans = false;
                    break;
                }
            } else {
                if (p[i] < c[i]) {
                    ans = false;
                    break;
                }
            }
        }

        out.println(ans ? "YES" : "NO");
    }

    private void run() {
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
