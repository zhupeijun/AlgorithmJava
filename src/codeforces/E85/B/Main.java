package codeforces.E85.B;

import java.io.*;
import java.util.*;

public class Main {
    private void solve() {
        int n = sc.nextInt();
        long x = sc.nextLong();
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        Arrays.sort(a);

        int ans = 0;
        long sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += a[i];
            if (sum >= x * (n - i)) {
                ans = n - i;
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
    }

    public static void main(String[] args) {
        out = new PrintWriter(new BufferedOutputStream(System.out));
        sc = new MyScanner();
        new Main().run();
        out.close();
    }
}
