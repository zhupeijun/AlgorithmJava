package codeforces._637.C;

import java.io.*;
import java.util.*;

public class Main {
    private void solve() {
        int n = sc.nextInt();

        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }

        int cur = 1;
        int end = n - 1;
        boolean ans = true;
        for (int i = n - 1; i > 0; --i) {
            if (p[i] == cur) {
                cur = p[end] + 1;
                end = i - 1;
                continue;
            }

            if (p[i] != p[i - 1] + 1) {
                ans = false;
                break;
            }
        }

        out.println(ans ? "Yes" : "No");
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
        sc  = new MyScanner();
        new Main().run();
        out.close();
    }
}
