package hackercup._2020.A;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = true;

    private boolean dfs(int u, int t, List<List<Integer>> g, boolean[] vis) {
        if (u == t) {
            return true;
        }

        vis[u] = true;
        for (int v : g.get(u)) {
            if (vis[v]) {
                continue;
            }

            if (dfs(v, t, g, vis)) {
                return true;
            }
        }
        return false;
    }

    private void solve() {
        int n = sc.nextInt();
        String I = sc.next();
        String O = sc.next();

        List<List<Integer>> g = createGraph(n);
        for (int i = 1; i < n; i++) {
            if (I.charAt(i) == 'Y' && O.charAt(i - 1) == 'Y') {
                g.get(i - 1).add(i);
            }

            if (I.charAt(i - 1) == 'Y' && O.charAt(i) == 'Y') {
                g.get(i).add(i - 1);
            }
        }

        char[][] ans = new char[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                boolean[] vis = new boolean[n];
                if (dfs(i, j, g, vis)) {
                    ans[i][j] = 'Y';
                } else {
                    ans[i][j] = 'N';
                }
            }
        }

        for (int i = 0; i < n; i++) {
            out.println(new String(ans[i]));
        }
    }

    private void run() {
        int T = N_CASE ? sc.nextInt() : 1;
        for (int t = 0; t < T; ++t) {
            out.println(String.format("Case #%d: ", t + 1));
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
        try {
            out = new MyWriter(new FileOutputStream("output.txt"));
            sc = new MyScanner();
            new Main().run();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}