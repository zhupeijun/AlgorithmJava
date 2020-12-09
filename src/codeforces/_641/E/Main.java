package codeforces._641.E;

import java.io.*;
import java.util.*;

public class Main {
    private static final int[][] DIR = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }

    private void solve() {
        int n = ni(), m = ni(), t = ni();
        String[] s = new String[n];
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
            for (int j = 0; j < m; j++) {
                a[i][j] = s[i].charAt(j) - '0';
            }
        }

        int[][] st = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean keep = true;
                for (int[] d : DIR) {
                    int ni = i + d[0];
                    int nj = j + d[1];

                    if (isValid(ni, nj, n, m) && a[i][j] == a[ni][nj]) {
                        keep = false;
                        break;
                    }
                }
                st[i][j] = keep ? 0 : 1;
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (st[i][j] == 1) {
                    q.add(new int[] { i, j, a[i][j] ^ 1, 0 });
                }
            }
        }

        while (!q.isEmpty()) {
            int[] u = q.poll();
            int i = u[0], j = u[1], na = u[2], tm = u[3];
            for (int[] d : DIR) {
                int ni = i + d[0], nj = j + d[1];
                if (isValid(ni, nj, n, m) && st[ni][nj] == 0 && a[ni][nj] == na) {
                    st[ni][nj] = st[i][j] + 1;
                    q.add(new int[] { ni, nj, a[ni][nj] ^ 1, 0 });
                }
            }

            if (tm == 0) {
                q.add(new int[] { i, j, u[2] ^ 1, 1});
            }
        }

        for (int k = 0; k < t; k++) {
            int i = ni() - 1, j = ni() - 1;
            long p = sc.nextLong();
            if (p < st[i][j] || st[i][j] == 0) {
                out.println(a[i][j]);
            } else {
                out.println(a[i][j] ^ ((p - st[i][j] + 1) % 2));
            }
        }
    }

    private void dg(int[][] t) {
        System.out.println("----");
        for (int[] r : t) {
            System.out.println(Arrays.toString(r));
        }
    }

    private static PrintWriter out;
    private static MyScanner sc;

    private int ni() {
        return sc.nextInt();
    }

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
