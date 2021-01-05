package atcoder.ABC._168.C;

import java.io.*;
import java.util.*;

public class Main {

    private double sq(double x) {
        return Math.sqrt(x);
    }

    private double p2(double x) {
        return x * x;
    }

    private void solve() {
        int A = sc.nextInt();
        int B = sc.nextInt();
        int H = sc.nextInt();
        int M = sc.nextInt();

        H %= 12;
        M %= 60;

        double x1 = 0, y1 = B;
        double b1 = Math.PI * 2 * M / 60;
        double x3 = x1 * Math.cos(b1) + y1 * Math.sin(b1);
        double y3 = y1 * Math.cos(b1) - x1 * Math.sin(b1);

        double x2 = 0, y2 = A;
        double b2 = Math.PI * 2 * (1.0 * H / 12 + 1.0 * M / 720);
        double x4 = x2 * Math.cos(b2) + y2 * Math.sin(b2);
        double y4 = y2 * Math.cos(b2) - x2 * Math.sin(b2);

        double dist = sq(p2(x3 - x4) + p2(y3 - y4));
        out.println(dist);
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
