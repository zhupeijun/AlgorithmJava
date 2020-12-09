package codeforces._664.E;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = false;
    private static final int BASE = 100000003;
    private static final int MOD = 1000000009;

    private int[] val;
    private long total;
    private long[][] c;
    private int n;
    private int k;
    private int m;
    private int ans;
    private List<List<Node>> g;
    private List<List<Integer>> bucket;

    private static class Node {
        int v, w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    private void dfs(int i, long hash) {
        if (i > k) {
            if (hash == total) {
                ++ans;
            }
            return;
        }

        for (int t = 1; t <= i; ++t) {
            dfs(i + 1, (hash + c[i][t]) % MOD);
        }
    }

    private void solve() {
        n = sc.nextInt();

        val = new int[n + 1];
        Random random = new Random(System.nanoTime());
        for (int i = 1; i <= n; ++i) {
            val[i] = val[i - 1] + random.nextInt(1003);
        }

        m = sc.nextInt();
        k = sc.nextInt();

        g = createGraph(n + 1);
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            g.get(u).add(new Node(v, w));
        }

        bucket = createGraph(k + 1);
        c = new long[k + 1][k + 1];
        for (int i = 1; i <= n; ++i) {
            List<Node> e = g.get(i);
            bucket.get(e.size()).add(i);
            e.sort(Comparator.comparingInt(v -> v.w));
            for (int j = 0; j < e.size(); ++j) {
                c[e.size()][j + 1] += val[e.get(j).v];
                c[e.size()][j + 1] %= MOD;
            }
        }

        total = 0;
        for (int i = 1; i <= n; i++) {
            total += val[i];
            total %= MOD;
        }

        ans = 0;

        dfs(1, 0);

        out.println(ans);
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

        void printlnArray(int[] a) {
            for (int v : a) {
                println(v);
            }
        }

        void printList(List<Integer> list) {
            for (int i = 0; i < list.size(); ++i) {
                print(list.get(i));
                print(i == list.size() - 1 ? '\n' : ' ');
            }
        }

        void printlnList(List<Integer> list) {
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

    public static void main(String[] args) {
        out = new MyWriter(new BufferedOutputStream(System.out));
        sc = new MyScanner();
        new Main().run();
        out.close();
    }
}