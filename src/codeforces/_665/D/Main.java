package codeforces._665.D;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = true;
    private static final int MOD = 1000_000_007;

    private int n;
    private List<List<Integer>> g;

    private long dfs(int u, int fa, List<Long> k) {

        long total = 0;
        for (int v : g.get(u)) {
            if (v != fa) {
                total += dfs(v, u, k);
            }
        }

        ++total;
        if (fa != -1) {
            k.add(total * (n - total));
        }

        return total;
    }

    private void solve() {
        n = sc.nextInt();
        g = createGraph(n);
        for (int i = 1; i < n; ++i) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            g.get(u).add(v);
            g.get(v).add(u);
        }

        List<Long> k = new ArrayList<>();
        dfs(0, -1, k);

        int m = sc.nextInt();
        List<Integer> p = sc.nextList(m);
        for (int i = m; i < k.size(); ++i) {
            p.add(1);
        }
        Collections.sort(p);
        Collections.sort(k);

        for (int i = 0; i < p.size(); ++i) {
            int ki = Math.min(i, k.size() - 1);
            k.set(ki, ((k.get(ki) % MOD) * p.get(i)) % MOD);
        }


        long ans = 0;
        for (Long aLong : k) {
            ans += aLong;
            ans %= MOD;
        }
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