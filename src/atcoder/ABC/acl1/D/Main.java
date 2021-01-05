package atcoder.ABC.acl1.D;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = false;

    private static class Doubling {
        private static final int D = 18;
        int[][] d, last;
        long[][] s;

        Doubling(int[] a, int K, boolean inv) {
            int n = a.length;
            d = new int[D][n+1]; s = new long[D][n+1];
            last = new int[D][n + 1];
            for (int i = 0; i < D; ++i) { Arrays.fill(d[i], n); Arrays.fill(last[i], n);}
            for (int i = n - 1, j = n; i >= 0; --i) {
                if (inv) {
                    while (a[i] - K >= a[j - 1]) --j;
                    d[0][i] = j;
                    last[0][i] = i;
                    s[0][i] = n - 1 - i;
                } else {
                    while (a[i] + K <= a[j - 1]) --j;
                    d[0][i] = j;
                    last[0][i] = i;
                    s[0][i] = i;
                }
            }

            for (int i = 0; i < D - 1; ++i) {
                for (int j = 0; j < n; ++j) {
                    d[i+1][j] = d[i][d[i][j]];
                    last[i+1][j] = last[i][d[i][j]];
                    s[i+1][j] = s[i][j] + s[i][d[i][j]];
                }
            }
        }

        private long[] get(int l, int r) {
            int j = l;
            long ret = 0;
            long cnt = 0;
            long w = 1 << D;
            for (int i = D - 1; i >= 0; --i) {
                w >>= 1;
                if (last[i][j] > r) continue;
                ret += s[i][j];
                cnt += w;
                j = d[i][j];
            }
            return new long[]{ ret, cnt };
        }
    }

    private void solve() {
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] X = sc.nextIntArray(N);
        Doubling dl = new Doubling(X, K, false);
        X = reverse(X);
        Doubling dr = new Doubling(X, K, true);

        int Q = sc.nextInt();
        while (Q-- > 0) {
            int L = sc.nextInt() - 1, R = sc.nextInt() - 1;
            long[] ret = dl.get(L, R);
            long lv = ret[0];
            long rv = dr.get(N - 1 - R, N - 1 - L)[0];
            out.println(rv - lv + ret[1]);
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
    private int max(int[] a) {
        int max = Integer.MIN_VALUE;
        for (int x : a) { max = Math.max(max, x); }
        return max;
    }

    private int[] reverse(int[] a) {
        int i = 0, j = a.length - 1;
        while (i < j) { int tmp = a[i]; a[i] = a[j]; a[j] = tmp; ++i; --j; }
        return a;
    }

    public static void main(String[] args) {
        out = new MyWriter(new BufferedOutputStream(System.out));
        sc = new MyScanner();
        new Main().run();
        out.close();
    }
}