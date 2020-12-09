package codeforces._639.D;

import java.io.*;
import java.util.*;

public class Main {
    private String[] s;
    private boolean[][] visit;
    private int n;
    private int m;

    private static final int[][] DIR = {{0, -1}, {1, 0}, {-1, 0}, {0, 1}};

    private boolean check() {
        for (int i = 0; i < n; ++i) {
            int pn = 0;
            for (int j = 0; j < m; ++j) {
                if (s[i].charAt(j) == '#' && (j == 0 || s[i].charAt(j - 1) == '.')) {
                    ++pn;
                }
            }
            if (pn > 1) {
                return false;
            }
        }

        for (int j = 0; j < m; ++j) {
            int pn = 0;
            for (int i = 0; i < n; ++i) {
                if (s[i].charAt(j) == '#' && (i == 0 || s[i - 1].charAt(j) == '.')) {
                    ++pn;
                }
            }
            if (pn > 1) {
                return false;
            }
        }

        int[] cr = new int[n];
        int[] cc = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (s[i].charAt(j) == '#') {
                    ++cr[i];
                    ++cc[j];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (cr[i] == 0) {
                boolean exist = false;
                for (int j = 0; j < m; j++) {
                    if (cc[j] == 0) {
                        exist = true;
                    }
                }
                if (!exist) {
                    return false;
                }
            }
        }

        for (int j = 0; j < m; j++) {
            if (cc[j] == 0) {
                boolean exist = false;
                for (int i = 0; i < n; i++) {
                    if (cr[i] == 0) {
                        exist = true;
                    }
                }
                if (!exist) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    private void bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {x, y});
        while (!q.isEmpty()) {
            int[] u = q.poll();
            x = u[0]; y = u[1];
            if (visit[x][y]) {
                continue;
            }
            visit[x][y] = true;
            for (int[] d : DIR) {
                int nx = x + d[0];
                int ny = y + d[1];
                if (isValid(nx, ny) && s[x].charAt(y) == '#') {
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    private void solve() {
        n = sc.nextInt();
        m = sc.nextInt();
        s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }

        if (check()){
            visit = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                Arrays.fill(visit[i], false);
            }

            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visit[i][j] && s[i].charAt(j) == '#') {
                        bfs(i, j);
                        ++ans;
                    }
                }
            }
            out.println(ans);
        } else {
            out.println("-1");
        }
    }

    private void run() {
        int T = 1; //sc.nextInt();
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
