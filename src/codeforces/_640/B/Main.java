package codeforces._640.B;

import java.io.*;
import java.util.*;

public class Main {
    private void solve() {
        int n = sc.nextInt();
        int k = sc.nextInt();

        if (k > n) {
            out.println("NO");
        } else {
            if (n % 2 != 0) {
                if (k % 2 == 0) {
                    out.println("NO");
                } else {
                    out.println("YES");
                    for (int i = 1; i < k; ++i) {
                        out.print(1);
                        out.print(' ');
                    }
                    out.println(n - (k - 1));
                }
            } else {
                if (k % 2 == 0) {
                    out.println("YES");
                    for (int i = 1; i < k; ++i) {
                        out.print(1);
                        out.print(' ');
                    }
                    out.println(n - (k - 1));
                } else {
                    if (k * 2 <= n) {
                        out.println("YES");
                        for (int i = 1; i < k; ++i) {
                            out.print(2);
                            out.print(' ');
                        }
                        out.println(n - (k - 1) * 2);
                    } else {
                        out.println("NO");
                    }
                }
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
