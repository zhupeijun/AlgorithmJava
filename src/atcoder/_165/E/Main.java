package atcoder._165.E;

import java.io.*;
import java.util.*;

public class Main {
    private void solve() {
        int N = sc.nextInt();
        int M = sc.nextInt();

        int left = 1, right = M + 1;
        while (left < right) {
            out.println(String.format("%d %d", left, right));
            ++left;
            --right;
        }

        left = M + 2;
        right = M * 2 + 1;
        while (left < right) {
            out.println(String.format("%d %d", left, right));
            ++left;
            --right;
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
