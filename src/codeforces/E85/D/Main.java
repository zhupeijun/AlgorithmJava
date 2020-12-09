package codeforces.E85.D;

import javax.management.MBeanRegistration;
import java.io.*;
import java.util.*;

public class Main {
    private void solve() {
        long n = sc.nextLong();
        long l = sc.nextLong();
        long r = sc.nextLong();

        long last = n * (n - 1) + 1;
        if (l == last) {
            out.println(1);
            return;
        }

        long g = 1;
        long k = 0;
        while (g < n) {
            long m = (n - g) * 2;
            if (k + m >= l) {
                break;
            }
            k += m;
            ++g;
        }

        long start = g + 1;
        for (long i = k + 1; i <= r; i += 2) {
            if (i == last) {
                out.println(1);
                break;
            }

            if (i >= l) {
                out.print(g);
                out.print(i == r ? "\n" : " ");
            }

            if (i + 1 >= l && i + 1 <= r) {
                out.print(start);
                out.print(i + 1 == r ? "\n" : " ");
            }

            if (start == n) {
                ++g;
                start = g + 1;
            } else {
                ++start;
            }
        }
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
