package codeforces._640.G;

import java.io.*;
import java.util.*;

public class Main {
    private void solve() {
        int n = sc.nextInt();

        if (n < 4) {
            out.println(-1);
            return;
        }

        int[] s1 = { 2, 4, 1, 5, 7, 3, 6};
        int[] s2 = { 2, 4, 1, 5, 3, 6};
        int[] s3 = { 2, 4, 1, 3, 5};
        int[] s4 = { 2, 4, 1, 3};

        int i = 0;
        boolean first = true;
        while (n > 0) {
            int[] s = null;
            int cur = i;
            if (n == 7) {
                s = s1;
                n -= 7;
            } else if (n == 6) {
                s = s2;
                n -= 6;
            } else if (n == 5) {
                s = s3;
                n -= 5;
            } else {
                s = s4;
                n -= 4;
                i += 4;
            }

            for (int d : s) {
                if (!first) {
                    out.print(' ');
                } else {
                    first = false;
                }

                out.print(cur + d);
            }
        }
        out.println();
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

        int[] nextArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }
    }

    public static void main(String[] args) {
        out = new PrintWriter(new BufferedOutputStream(System.out));
        sc = new MyScanner();
        new Main().run();
        out.close();
    }
}
