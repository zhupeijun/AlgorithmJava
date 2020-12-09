package atcoder._168.A;

import java.io.*;
import java.util.*;

public class Main {
    private void solve() {
        int n  =sc.nextInt();

        int d = n % 10;
        if (Arrays.asList(2, 4, 5, 7, 9).contains(d)) {
            out.println("hon");
        } else if (Arrays.asList(0, 1, 6, 8).contains(d)) {
            out.println("pon");
        } else {
            out.println("bon");
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
