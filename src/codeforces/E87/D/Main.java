package codeforces.E87.D;

import java.io.*;
import java.util.*;

public class Main {
    private static final int M = 1000005;
    static class BIT {
        private int[] bit;

        BIT() {
            bit = new int[M];
        }

        void add(int i, int x) {
            while (i < M) {
                bit[i] += x;
                i += i & -i;
            }
        }

        int sum(int i) {
            int s = 0;
            while (i > 0) {
                s += bit[i];
                i -= i & -i;
            }
            return s;
        }
    }

    private int bs(BIT b, int k) {
        int left = 1, right = M - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = b.sum(mid);
            if (cnt >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private void solve() {
        int n = sc.nextInt();
        int q = sc.nextInt();

        BIT b = new BIT();
        for (int i = 0; i < n; i++) {
            b.add(sc.nextInt(), 1);
        }

        for (int i = 0; i < q; i++) {
            int k = sc.nextInt();
            if (k > 0) {
                b.add(k, 1);
            } else {
                k = -k;
                int v = bs(b, k);
                b.add(v, -1);
            }
        }

        for (int i = 1; i <= n; i++) {
            if (b.bit[i] > 0) {
                out.println(i);
                return;
            }
        }
        out.println(0);
    }

    private static PrintWriter out;
    private static MyScanner sc;

    private static class MyScanner {
        BufferedReader br;

        private MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        private boolean isSpace(char c) {
            return c == '\n' || c == '\r' || c == ' ';
        }

        String next() {
            try {
                StringBuilder sb = new StringBuilder();
                int r;
                while ((r = br.read()) != -1 && isSpace((char)r));
                if (r == -1) {
                    return null;
                }

                sb.append((char) r);
                while ((r = br.read()) != -1 && !isSpace((char)r)) {
                    sb.append((char)r);
                }
                return sb.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
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
