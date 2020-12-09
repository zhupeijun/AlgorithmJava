package codeforces._665.E;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = false;
    private static final int M = 1000005;

    private static class BIT {
        int[] dat;
        int n;

        BIT(int n) {
            this.n = n;
            this.dat = new int[n + 1];
        }

        int sum(int i) {
            int s = 0;
            while (i > 0) {
                s += dat[i];
                i -= (i & -i);
            }
            return s;
        }

        void add(int i, int x) {
            while (i <= n) {
                dat[i] += x;
                i += (i & -i);
            }
        }
    }

    private void solve() {
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] y = new int[n];
        int[] lx = new int[n];
        int[] rx = new int[n];
        for (int i = 0; i < n; i++) {
            y[i] = sc.nextInt();
            lx[i] = sc.nextInt();
            rx[i] = sc.nextInt();
        }

        int[] x = new int[m];
        int[] ly = new int[m];
        int[] ry = new int[m];
        for (int i = 0; i < m; i++) {
            x[i] = sc.nextInt();
            ly[i] = sc.nextInt();
            ry[i] = sc.nextInt();
        }

        long ans = 1;
        BIT bit = new BIT(M);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (lx[i] == 0 && rx[i] == 1000000) {
                bit.add(y[i], 1);
                ++ans;
            } else if (lx[i] == 0) {
                left.add(i);
                bit.add(y[i], 1);
            } else if (rx[i] == 1000000) {
                right.add(i);
            }
        }

        left.sort(Comparator.comparingInt(i -> rx[i]));
        right.sort(Comparator.comparingInt(i -> lx[i]));

        List<Integer> vl = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            vl.add(i);
        }
        vl.sort(Comparator.comparingInt(i -> x[i]));

        int li = 0, ri = 0;
        for (int i = 0; i < m; i++) {
            int up = ry[vl.get(i)];
            int down = ly[vl.get(i)];
            int vx = x[vl.get(i)];

            while (li < left.size() && rx[left.get(li)] < vx) {
                bit.add(y[left.get(li)], -1);
                ++li;
            }

            while (ri < right.size() && lx[right.get(ri)] <= vx) {
                bit.add(y[right.get(ri)], 1);
                ++ri;
            }

            ans += bit.sum(up) - bit.sum(down - 1);
            if (up == 1000000 && down == 0) {
                ++ans;
            }
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