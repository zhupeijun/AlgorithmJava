package codeforces._638.D;

import java.io.*;
import java.util.*;

public class Main {
    private int bs(int left, int right, int target, int d1, int d2, int n) {
        //out.println(d1 + " " + d2);
        while (left <= right) {
            int mid = (left + right) / 2;
            int total = mid * d1 + (n - mid) * d2;
      //      out.println("# " + mid + " " + left + " " + right + " " + total);
            if (total >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private void solve() {
        int n = sc.nextInt();
        int d = 0;
        int base = 1;
        while (base * 2 - 1 < n) {
            base <<= 1;
            ++d;
        }

        out.println(d);
        int[] ans = new int[d];
        int cur = 1;
        for (int i = 0; i < d; i++) {
            int r = bs(0, cur, n, base * 2 - 1, base, cur);
            //System.out.println(cur + " " + n + " " + (base * 2 - 1) + " " + (d - i + 1) + " " + r);
            ans[i] = r;
            n -= cur;
            base /= 2;
            cur = r * 2 + cur - r;
        }

        for (int i = 0; i < d; ++i) {
            out.print(ans[i]);
            out.print(i == d - 1 ? '\n' : ' ');
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
