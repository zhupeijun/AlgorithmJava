package codeforces._633.B;

import java.io.*;
import java.util.*;

public class Main {
    private void solve() {
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        Arrays.sort(a);
        int left = 0, right = n - 1;
        int[] ans = new int[n];
        for (int i = n - 1, t = 0; i >= 0; i--, ++t) {
            if (t % 2 == 0) {
                ans[i] = a[left++];
            } else {
                ans[i] = a[right--];
            }
        }

        for (int i = 0; i < n; i++) {
            out.print(ans[i]);
            out.print(i == n - 1 ? '\n' : ' ');
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
