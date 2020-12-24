package atcoder.acl1.A;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = false;

    private void dfs(List<List<Integer>> g, int u, List<Integer> b, Set<Integer> s) {
        s.add(u); b.add(u);
        for (int v : g.get(u)) {
            if (!s.contains(v)) {
                dfs(g, v, b, s);
            }
        }
    }

    private void solve() {
        int N = sc.nextInt();
        List<int[]> a = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            a.add(new int[] { sc.nextInt(), sc.nextInt(), i });
        }

        a.sort(Comparator.comparingInt(v -> v[0]));
        List<List<Integer>> g = createGraph(N);
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (int i = N - 1; i >= 0; --i) {
            int u = a.get(i)[2];
            int t = a.get(i)[1];
            Integer k = m.higherKey(t);
            if (k != null) {
                int v = m.get(k);
                g.get(u).add(v);
                g.get(v).add(u);
            }
            m.put(t, u);
        }

        m = new TreeMap<>();
        for (int i = 0; i < N; ++i) {
            int u = a.get(i)[2];
            int t = a.get(i)[1];
            Integer k = m.lowerKey(t);
            if (k != null) {
                int v = m.get(k);
                g.get(u).add(v);
                g.get(v).add(u);
            }
            m.put(t, u);
        }

        int[] ans = new int[N];
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < N; ++i) {
            if (!s.contains(i)) {
                List<Integer> b = new ArrayList<>();
                dfs(g, i, b, s);
                for (int v : b) { ans[v] = b.size(); }
            }
        }

        for (int i = 0; i < N; i++) {
            out.println(ans[i]);
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