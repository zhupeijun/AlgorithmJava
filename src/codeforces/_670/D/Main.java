package codeforces._670.D;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = false;

    private long totalAdd;
    private long totalSub;
    private long[] add;
    private long[] sub;
    private long[] a;

    private long calc(long x, long y) {
        long x2 = 0;
        long y2 = x2 - totalSub;
        long y1 = y - y2;
        long x1 = y1 - totalAdd;
        long ans = x2 + y1;
        return ans >= 0 ? (ans + 1) / 2 : ans / 2;
    }

    private void update(int l, int x1, int x2) {
        long v1 = 0, v2 = add[l] - sub[l];
        totalAdd -= add[l]; totalSub -= sub[l];
        v1 += x1;
        v2 += x2;
        if (v2 > v1) {
            add[l] = v2 - v1;
            sub[l] = 0;
            totalAdd += add[l];
        } else {
            sub[l] = v1 - v2;
            add[l] = 0;
            totalSub += sub[l];
        }
    }

    private void solve() {
        int n = sc.nextInt();
        a = sc.nextLongArray(n);

        totalSub = 0; totalAdd = 0;
        add = new long[n]; sub = new long[n];
        for (int i = 1; i < n; ++i) {
            if (a[i] > a[i - 1]) {
                add[i] = a[i] - a[i - 1];
                totalAdd += add[i];
            } else {
                sub[i] = a[i - 1] - a[i];
                totalSub += sub[i];
            }
        }

        out.println(calc(a[0], a[n - 1]));
        int q = sc.nextInt();
        while (q-- > 0) {
            int l = sc.nextInt() - 1;
            int r = sc.nextInt() - 1;
            int x = sc.nextInt();

            if (l == 0) {
                a[0] += x;
            } else {
                update(l, 0, x);
            }

            if (r == n - 1) {
                if (l != r) {
                    a[r] += x;
                }
            } else {
                update(r + 1, x, 0);
            }

            out.println(calc(a[0], a[n - 1]));
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