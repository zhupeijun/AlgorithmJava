package codeforces._665.F;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = false;

    int N, M, Q;
    int[] R, S, A;
    long[] dat;

    private int reverse(int i, int l, int r) {
        return l + (r - 1 - i);
    }

    private int swap(int i, int l, int mid) {
        return i < mid ? i - l + mid : i - mid + l;
    }

    void update(int k, int l, int r, int i, int v, int lv) {
        if (i <= l && i >= r - 1) {
            dat[k] = v;
            return;
        }

        int mid = (l + r) / 2;
        int kl = k * 2 + 1;
        int kr = k * 2 + 2;

        i = R[lv] == 0 ? i : reverse(i, l, r);
        i = S[lv] == 0 ? i : swap(i, l, mid);

        ++lv;
        if (i < mid) {
            update(kl, l, mid, i, v, lv);
        } else {
            update(kr, mid, r, i, v, lv);
        }

        dat[k] = dat[kl] + dat[kr];
    }

    long sum(int k, int a, int b, int l, int r, int lv) {
        if (a >= b) {
            return 0;
        }

        if (a <= l && b >= r) {
            return dat[k];
        }

        int mid = (l + r) / 2;
        int kl = k * 2 + 1;
        int kr = k * 2 + 2;

        int ra = R[lv] == 0 ? a : reverse(b - 1, l, r);
        int rb = R[lv] == 0 ? b : reverse(a, l, r) + 1;
        int sa = S[lv] == 0 ? ra : swap(ra, l, mid);
        int sb = S[lv] == 0 ? rb : swap(rb, l, mid);

        ++lv;

        if (sa > sb) {
            return sum(kl, l, sb, l, mid, lv) + sum(kr, sa, r, mid, r, lv);
        } else {
            if (sb <= mid) {
                return sum(kl, sa, sb, l, mid, lv);
            } else if (sa >= mid) {
                return sum(kr, sa, sb, mid, r, lv);
            } else {
                return sum(kl, sa, mid, l, mid, lv) + sum(kr, mid, sb, mid, r, lv);
            }
        }
    }

    private void solve() {
        N = sc.nextInt();
        Q = sc.nextInt();
        M = 1 << N;

        R = new int[N + 1];
        S = new int[N + 1];
        A = sc.nextIntArray(M);
        dat = new long[M * 2 - 1];

        for (int i = 0; i < M; i++) {
            update(0, 0, M, i, A[i], 0);
        }

        for (int i = 0; i < Q; i++) {
            int o = sc.nextInt();
            if (o == 1) {
                int x = sc.nextInt() - 1;
                int k = sc.nextInt();
                update(0, 0, M, x, k, 0);
            } else if (o == 2) {
                int k = sc.nextInt();
                R[N - k] ^= 1;
            } else if (o == 3) {
                int k = sc.nextInt();
                S[N - k - 1] ^= 1;
            } else {
                int l = sc.nextInt() - 1;
                int r = sc.nextInt();
                out.println(sum(0, l, r, 0, M, 0));
            }
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