package codeforces._640.D;

import java.io.*;
import java.util.*;

public class Main {
    private void solve() {
        int n = sc.nextInt();
        int[] c = sc.nextArray(n);

        int a = 0, b = 0;
        a += c[0];
        int prev = a;

        int i = 1, j = n - 1, turn = 1;
        while (i <= j) {
            int ate = 0;
            if (turn % 2 == 0) {
                while (i <= j && ate <= prev) {
                    ate += c[i++];
                }
                a += ate;
                ++turn;
            } else {
                while (i <= j && ate <= prev) {
                    ate += c[j--];
                }
                b += ate;
                ++turn;
            }
            prev = ate;
        }

        out.println(String.format("%d %d %d", turn, a, b));
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
