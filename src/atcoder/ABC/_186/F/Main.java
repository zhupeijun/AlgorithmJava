package atcoder.ABC._186.F;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = false;

    private static class Seg {
        long[] data, datb;
        int n;

        Seg(int m) {
            n = 1;
            while (n < m) n *= 2;
            data = new long[n * 2];
            datb = new long[n * 2];
        }

        void add(int a, int b, long x) {
            add(a, b, x, 0, 0, n);
        }

        long sum(int a, int b) {

            return sum(a, b, 0, 0, n);
        }

        void add(int a, int b, long x, int k, int l, int r) {
            if (a <= l && r <= b) {
                data[k] += x;
            } else if (l < b && a < r) {
                datb[k] += (Math.min(b, r) - Math.max(a, l)) * x;
                add(a, b, x, k * 2 + 1, l, (l+r)/2);
                add(a, b, x, k * 2 + 2, (l+r)/2, r);
            }
        }

        long sum(int a, int b, int k, int l, int r) {
            if (b <= l || r <= a) {
                return 0;
            } else if (a <= l && r <= b) {
                return data[k] * (r - l) + datb[k];
            } else {
                long res = (Math.min(b, r) - Math.max(a, l)) * data[k];
                res += sum(a, b, k * 2 + 1, l, (l+r)/2);
                res += sum(a, b, k * 2 + 2, (l+r)/2, r);
                return res;
            }
        }
    }

    private void solve() {
        int H = sc.nextInt();
        int W = sc.nextInt();
        int M = sc.nextInt();

        int[] yo = new int[W + 1];
        int[] xo = new int[H + 1];

        Arrays.fill(yo, H+1);
        Arrays.fill(xo, W+1);

        List<List<Integer>> r = new ArrayList<>();
        for (int i = 0; i <= H; ++i) {
            r.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            yo[y] = Math.min(x, yo[y]);
            xo[x] = Math.min(y, xo[x]);
            r.get(x).add(y);
        }

        long ans = 0;
        for (int i = 1; i < xo[1]; ++i) {
            ans += yo[i] - 1;
        }

        Seg seg = new Seg(H+1);
        seg.add(xo[1], W+1, 1);
        for (int i = 2; i < yo[1]; ++i) {
            ans += seg.sum(1, xo[i]);
            for (int t : r.get(i)) {
                if (seg.sum(t, t + 1) == 0) {
                    seg.add(t, t + 1, 1);
                }
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