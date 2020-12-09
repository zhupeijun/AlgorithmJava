package codeforces._640.F;

import java.io.*;
import java.util.*;

public class Main {
    private void solve() {
        int n0 = sc.nextInt(), n1 = sc.nextInt(), n2 = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        if (n2 > 0) {
            sb.append(1);
            sb.append("1".repeat(n2));
        }

        if (n0 > 0) {
            sb.append(0);
            sb.append("0".repeat(n0));
        }

        if (n1 > 0) {
            if (sb.length() == 0) {
                sb.append(0);
            } else if (sb.charAt(sb.length() - 1) == '1') {
                sb.append(0);
                --n1;
            } else {
                if (n2 > 0) {
                    --n1;
                }
            }

            int cur = 1;
            for (int i = 0; i < n1; ++i) {
                sb.append(cur);
                cur ^= 1;
            }
        }
        out.println(sb.toString());
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
