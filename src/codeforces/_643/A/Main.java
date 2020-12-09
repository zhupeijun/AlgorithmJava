package codeforces._643.A;

import java.io.*;
import java.util.*;

public class Main {
    private long plus(long x) {
        long max = 0;
        long min = 9;

        while (x > 0) {
            long d = x % 10;
            max = Math.max(max, d);
            min = Math.min(min, d);
            x /= 10;
        }
        return max * min;
    }

    private void solve() {
        long a1 = sc.nextLong();
        long k = sc.nextLong();

        long cur = a1;
        for (int i = 1; i < k; ++i) {
            long next = cur + plus(cur);
            if (next == cur) {
                break;
            }
            cur = next;
        }
        out.println(cur);
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
