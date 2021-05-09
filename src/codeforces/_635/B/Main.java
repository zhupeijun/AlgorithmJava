package codeforces._635.B;

import java.io.*;
import java.util.*;

public class Main {
    private void solve() {
        int x = sc.nextInt();
        int n = sc.nextInt();
        int m = sc.nextInt();

        while (x > 20 && n > 0) {
            x = x / 2 + 10;
            --n;
        }

        while (m > 0 && x > 0) {
            x -= 10;
            --m;
        }

        out.println(x <= 0 ? "YES" : "NO");
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
