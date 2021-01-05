package atcoder.ABC._184.E;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = false;
    private static final int[][] D = { {0, -1}, {0, 1}, {-1, 0},{ 1, 0}};

    private void solve() {
        int H = sc.nextInt(), W = sc.nextInt();

        String[] g = new String[H];
        for (int i = 0; i < H; i++) {
            g[i] = sc.next();
        }

        Queue<int[]> q = new ArrayDeque<>();
        List<List<int[]>> a = new ArrayList<>();
        for (int i = 0; i < 26; ++i) {
            a.add(new ArrayList<>());
        }

        int[][] dist = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < H; ++i) {
            for (int j = 0; j < W; ++j) {
                char c = g[i].charAt(j);
                if (c == 'S') {
                    q.add(new int[] { i, j, 0} );
                    dist[i][j] = 0;
                } else if (c >= 'a' && c <= 'z') {
                    a.get(c - 'a').add(new int[] { i, j});
                }
            }
        }

        boolean[] vis = new boolean[26];
        while (!q.isEmpty()) {
            int[] u = q.poll();
            char c = g[u[0]].charAt(u[1]);
            if (c >= 'a' && c <= 'z') {
                int k = c - 'a';
                if (!vis[k]) {
                    for (int[] v : a.get(k)) {
                        if (dist[v[0]][v[1]] == Integer.MAX_VALUE) {
                            dist[v[0]][v[1]] = u[2] + 1;
                            q.add(new int[] { v[0], v[1], u[2] + 1});
                        }
                    }
                    vis[k] = true;
                }
            }

            for (int[] dir : D) {
                int nx = u[0] + dir[0];
                int ny = u[1] + dir[1];

                if (nx >= 0 && nx < H && ny >= 0 && ny < W && g[nx].charAt(ny) != '#' && dist[nx][ny] == Integer.MAX_VALUE) {
                    dist[nx][ny] = u[2] + 1;
                    q.add(new int[] { nx, ny, u[2] + 1});
                }
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (g[i].charAt(j) == 'G') {
                    int ans = dist[i][j];
                    if (ans == Integer.MAX_VALUE) {
                        out.println(-1);
                    } else {
                        out.println(ans);
                    }
                }
            }
        }
    }

    private void run() {
        int T = N_CASE ? sc.nextInt() : 1;
        for (int t = 0; t < T; ++t) {
            solve();
        }
    }

    private static MyWriter out;
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

        int[] nextIntArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        int[][] nextIntArray(int n, int m) {
            int[][] a = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            return a;
        }

        long[] nextLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextLong();
            }
            return a;
        }

        long[][] nextLongArray(int n, int m) {
            long[][] a = new long[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = nextLong();
                }
            }
            return a;
        }

        List<Integer> nextList(int n) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(nextInt());
            }
            return list;
        }

        List<Long> nextLongList(int n) {
            List<Long> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(nextLong());
            }
            return list;
        }

        char[] nextCharArray(int n) {
            return sc.next().toCharArray();
        }

        char[][] nextCharArray(int n, int m) {
            char[][] c = new char[n][m];
            for (int i = 0; i < n; i++) {
                String s = sc.next();
                for (int j = 0; j < m; j++) {
                    c[i][j] = s.charAt(j);
                }
            }
            return c;
        }
    }

    private static class MyWriter extends PrintWriter {
        private MyWriter(OutputStream outputStream) {
            super(outputStream);
        }

        void printArray(int[] a) {
            for (int i = 0; i < a.length; ++i) {
                print(a[i]);
                print(i == a.length - 1 ? '\n' : ' ');
            }
        }

        void printArray(long[] a) {
            for (int i = 0; i < a.length; ++i) {
                print(a[i]);
                print(i == a.length - 1 ? '\n' : ' ');
            }
        }

        void println(int[] a) {
            for (int v : a) {
                println(v);
            }
        }

        void print(List<Integer> list) {
            for (int i = 0; i < list.size(); ++i) {
                print(list.get(i));
                print(i == list.size() - 1 ? '\n' : ' ');
            }
        }

        void println(List<Integer> list) {
            list.forEach(this::println);
        }
    }

    private <T> List<List<T>> createGraph(int n) {
        List<List<T>> g = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            g.add(new ArrayList<>());
        }
        return g;
    }

    private void fill(int[][] a, int value) {
        for (int[] row : a) {
            fill(row, value);
        }
    }

    private void fill(int[] a, int value) {
        Arrays.fill(a, value);
    }

    public static void main(String[] args) {
        out = new MyWriter(new BufferedOutputStream(System.out));
        sc = new MyScanner();
        new Main().run();
        out.close();
    }
}