package codeforces._641.D;

import java.io.*;
import java.util.*;

public class Main {
    private void solve() {
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] a = new int[n];
        boolean exist = false;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            if (a[i] == k) {
                exist = true;
            }
        }

        if (!exist) {
            out.println("no");
            return;
        }

        if (n == 1) {
            out.println("yes");
            return;
        } if (n == 2) {
            out.println(Math.min(a[0], a[1]) >= k ? "yes" : "no");
            return;
        }

        for (int i = 2; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < 3; j++) {
                cnt += a[i - j] >= k ? 1 : 0;
            }
            if (cnt >= 2) {
                out.println("yes");
                return;
            }
        }
        out.println("no");
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
