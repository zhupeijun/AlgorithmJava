package codeforces._670.C;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = true;

    List<List<Integer>> g;
    int n;

    int dfs(int u, int fa, int[] c) {
        int cnt = 0;
        int max = 0;
        for (int v : g.get(u)) {
            if (v != fa) {
                int ret = dfs(v, u, c);
                max = Math.max(max, ret);
                cnt += ret;
            }
        }
        ++cnt;
        c[u] = Math.max(max, n - cnt);
        return cnt;
    }

    int dfs2(int u, int fa, int[] l) {
        int cnt = 0;
        for (int v : g.get(u)) {
            if (v != fa) {
                cnt += dfs2(v, u, l);
            }
        }
        if (cnt == 0) {
            l[0] = u;l[1] = fa;
        }
        return cnt + 1;
    }

    private void solve() {
        n = sc.nextInt();
        g = createGraph(n);
        int[][] e = new int[n - 1][2];
        for (int i = 0; i < n - 1; ++i) {
            e[i][0] = sc.nextInt() - 1;
            e[i][1] = sc.nextInt() - 1;
            g.get(e[i][0]).add(e[i][1]);
            g.get(e[i][1]).add(e[i][0]);
        }

        int[] c = new int[n];
        dfs(0, -1, c);
        List<int[]> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            a.add(new int[] { c[i], i });
        }
        a.sort(Comparator.comparingInt(v -> v[0]));
        if (a.get(0)[0] != a.get(1)[0]) {
            out.println(String.format("%d %d", e[0][0] + 1, e[0][1] + 1));
            out.println(String.format("%d %d", e[0][0] + 1, e[0][1] + 1));
        } else {
            g = createGraph(n);
            for (int[] uv : e) {
                if ((uv[0] == a.get(0)[1] && uv[1] == a.get(1)[1]) || (uv[0] == a.get(1)[1] && uv[1] == a.get(0)[1])) {
                    continue;
                }
                g.get(uv[0]).add(uv[1]);
                g.get(uv[1]).add(uv[0]);
            }

            int[] l = new int[2];
            dfs2(a.get(0)[1], -1, l);
            out.println(String.format("%d %d", l[0] + 1, l[1] + 1));
            out.println(String.format("%d %d", l[0] + 1, a.get(1)[1] + 1));
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