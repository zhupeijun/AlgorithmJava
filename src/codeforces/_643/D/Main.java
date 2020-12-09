package codeforces._643.D;

import java.io.*;
import java.util.*;

public class Main {
    private void solve() {
        int n = sc.nextInt();
        int s = sc.nextInt();

        if (s < n * 2) {
            out.println("NO");
        } else {
            out.println("YES");
            for (int i = 0; i < n; i++) {
                if (i == n - 1) {
                    out.print(s);
                    out.print("\n");
                } else {
                    out.print(2);
                    out.print(" ");
                    s -= 2;
                }
            }
            out.print(1);
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
        new Main().solve();
        out.close();
    }
}
