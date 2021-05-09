package codeforces._638.C;

import java.io.*;
import java.util.*;

public class Main {
    private void solve() {
        int n = sc.nextInt();
        int k = sc.nextInt();

        String s = sc.next();
        char[] c = s.toCharArray();
        Arrays.sort(c);
        StringBuilder sb = new StringBuilder();
        if (c[0] != c[k - 1]) {
            sb.append(c[k - 1]);
        } else {
            if (k == n) {
                sb.append(c[k - 1]);
            } else {
                if (c[k] == c[n - 1]) {
                    sb.append(c[0]);
                    for (int i = k; i < n; i += k) {
                        sb.append(c[i]);
                    }
                } else {
                    sb.append(c[0]);
                    for (int i = k; i < n; ++i) {
                        sb.append(c[i]);
                    }
                }
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
    }

    public static void main(String[] args) {
        out = new PrintWriter(new BufferedOutputStream(System.out));
        sc = new MyScanner();
        new Main().run();
        out.close();
    }
}
