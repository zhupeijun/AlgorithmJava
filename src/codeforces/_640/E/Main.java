package codeforces._640.E;

import java.io.*;
import java.util.*;

public class Main {
    private void solve() {
        int n = sc.nextInt();
        int[] a = sc.nextArray(n);
        boolean[] exist = new boolean[8005];

        int[] pre = new int[n];
        for (int i = 0; i < n; ++i) {
            pre[i] = i == 0 ? a[i] : pre[i - 1] + a[i];
        }

        for (int i = 0; i < n; ++i) {
            for (int j = i + 2; j < n; ++j) {
                int delta = pre[j] - pre[i];
                if (delta < exist.length) {
                    exist[delta] = true;
                }
            }

            if (i > 0 && pre[i] < exist.length) {
                exist[pre[i]] = true;
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (exist[a[i]]) {
                ++ans;
            }
        }
        out.println(ans);
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
