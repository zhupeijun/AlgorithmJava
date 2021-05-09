package atcoder.ABC._161.F;

import java.io.*;
import java.util.*;

public class Main {

    private void solve() {
        long n = sc.nextLong();
        long m = n - 1;

        long x = 2;
        long ans = n == 2 ? 1 : 2;
        while (x * x < m) {
            if (m % x == 0) {
                ans += 2;
            }

            ++x;
        }

        if (x * x == m) {
            ++ans;
        }

        x = 2;
        while (x * x <= n) {
            if (n % x == 0) {
                long y = n;
                while (y % x == 0) {
                    y /= x;
                }
                if (y % x == 1) {
                    ++ans;
                }
            }
            ++x;
        }

        out.println(ans);
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
        new Main().solve();
        out.close();
    }
}
