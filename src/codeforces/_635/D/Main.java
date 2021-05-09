package codeforces._635.D;

import java.io.*;
import java.util.*;

public class Main {
    private static final int M = 3;

    private long sq(long x) {
        return x * x;
    }

    private long cal(long x, long y, long z) {
        return sq(x - y) + sq(x - z) + sq(y - z);
    }

    private void solve() {
        int[] n = new int[M];
        for (int i = 0; i < M; i++) {
            n[i] = sc.nextInt();
        }

        int[][] a = new int[M][];
        List<TreeSet<Integer>> ts = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            ts.add(new TreeSet<>());
        }

        for (int i = 0; i < M; i++) {
            a[i] = new int[n[i]];
            for (int j = 0; j < n[i]; j++) {
                a[i][j] = sc.nextInt();
                ts.get(i).add(a[i][j]);
            }
        }

        long ans = Long.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < n[i]; j++) {
                int y = a[i][j];
                Integer x = ts.get((i + 1) % M).lower(y + 1);
                Integer z = ts.get((i - 1 + M) % M).higher(y - 1);

                if (x != null && z != null) {
                    ans = Math.min(cal(x, y, z), ans);
                }

                x = ts.get((i - 1 + M) % M).lower(y + 1);
                z = ts.get((i + 1) % M).higher(y - 1);

                if (x != null && z != null) {
                    ans = Math.min(cal(x, y, z), ans);
                }
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
