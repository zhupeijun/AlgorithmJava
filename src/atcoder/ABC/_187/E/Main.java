package atcoder.ABC._187.E;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = false;

    private List<List<Integer>> tr;
    private int N;
    private long[] val;
    private long[] ans;
    private int[] rel;

    private void getRel(int fa, int u) {
        rel[u] = fa;
        for (int v : tr.get(u)) {
            if (v != fa) {
                getRel(u, v);
            }
        }
    }

    private void dfs(int fa, int u, long sum) {
        sum += val[u];
        ans[u] = sum;
        for (int v : tr.get(u)) {
            if (fa != v) {
                dfs(u, v, sum);
            }
        }
    }

    private void solve() {
        N = sc.nextInt();
        tr = createGraph(N);
        int[] a = new int[N-1];
        int[] b = new int[N-1];
        for (int i = 0; i < N-1; ++i) {
            a[i] = sc.nextInt() - 1;
            b[i] = sc.nextInt() - 1;
            tr.get(a[i]).add(b[i]);
            tr.get(b[i]).add(a[i]);
        }

        rel = new int[N];
        getRel(-1, 0);

        val = new long[N];
        int Q = sc.nextInt();
        for (int i = 0; i < Q; i++) {
            int t = sc.nextInt();
            int e = sc.nextInt() - 1;
            int x = sc.nextInt();

            int u, v;
            if (t == 1) {
                u = a[e]; v = b[e];
            } else {
                u = b[e]; v = a[e];
            }

            if(rel[u] == v) {
                val[u] += x;
            } else {
                val[0] += x;
                val[v] -= x;
            }
        }


        ans = new long[N];
        dfs(-1, 0, 0);
        for (long x : ans) {
            out.println(x);
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

        void println(long[] a) {
            for (long v : a) {
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