package atcoder.aising2020.D;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = false;

    private int f(int x) {
        if (x == 0) {
            return 0;
        }

        int cnt = 0;
        int t = x;
        while (x > 0) {
            if ((x & 1) > 0) {
                ++cnt;
            }
            x >>= 1;
        }
        return f(t % cnt) + 1;
    }

    private void solve() {
        int N = sc.nextInt();
        String s = sc.next();
        int n1 = 0;
        char[] c = s.toCharArray();
        for (char ci : c) {
            if (ci == '1') {
                ++n1;
            }
        }

        if (n1 == 0) {
            for (int i = 0; i < N; i++) {
                out.println(1);
            }
            return;
        } else if (n1 == 1) {
            for (int i = 0; i < N; i++) {
                if (c[i] == '1') {
                    out.println(0);
                } else {
                    c[i] = '1';
                    if (c[N - 1] == '0') {
                        out.println(1);
                    } else {
                        out.println(2);
                    }
                }
            }
            return;
        }

        int m1 = n1 - 1;
        int m2 = n1 + 1;
        int v1 = 0;
        int v2 = 0;
        for (int i = 0; i < N; ++i) {
            int d = c[i] - '0';
            v1 = (v1 << 1) + d;
            v1 %= m1;
            v2 = (v2 << 1) + d;
            v2 %= m2;
        }

        int t1 = 1, t2 = 1;
        int[] ans = new int[N];
        for (int i = N - 1; i >= 0; --i) {
            if (c[i] == '0') {
                int x = (v2 + t2) % m2;
                ans[i] = f(x) + 1;
            } else {
                int x = (v1 - t1 + m1) % m1;
                ans[i] = f(x) + 1;
            }
            t1 = (t1 << 1) % m1;
            t2 = (t2 << 1) % m2;
        }

        for (int v : ans) {
            out.println(v);
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