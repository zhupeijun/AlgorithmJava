package codeforces._640.C;

import java.io.*;
import java.util.*;

public class Main {
    private long bs(long n, int k) {
        long left = 1, right = Integer.MAX_VALUE;
        while (left <= right) {
            long mid = (left + right) / 2;
            long v = mid - mid / n;
            if (v >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private void solve() {
        int n = sc.nextInt();
        int k = sc.nextInt();

        out.println(bs(n, k));
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
