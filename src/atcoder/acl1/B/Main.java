package atcoder.acl1.B;
import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = false;

    long mod(long a, long m) {
        return (a % m + m) % m;
    }

    long extGcd(long a, long b, long[] r) {
        long px = 1, x = 0, py = 0, y = 1;
        while (b != 0) {
            long q = a / b;
            long nx = px - q * x; px = x; x = nx;
            long ny = py - q * y; py = y; y = ny;
            long na = b; b = a % b; a = na;
        }
        r[0] = px; r[1] = py;
        return a;
    }

    long[] chineseRem(long[] b, long[] m) {
        long r = 0, M = 1;
        int n = b.length;
        for (int i = 0; i < n; ++i) {
            long[] x = new long[2];
            long d = extGcd(M, m[i], x);
            if ((b[i] - r) % d != 0) return new long[] { 0, -1 };
            long y = m[i] / d;
            long t = (b[i] - r) / d * x[0] % y;
            r += M * t;
            M *= y;
        }
        return new long[] { mod(r, M), M };
    }

    private void solve() {
        long[] z = new long[2];
        long y = extGcd(-1, 11, z);
        long N = sc.nextLong();
        N *= 2;
        long ans = Long.MAX_VALUE;
        for (long i = 1; i * i <= N; ++i) {
            if (N % i == 0) {
                long[] ret;
                long[] b = new long[] { 0, -1 };
                ret = chineseRem(b, new long[] { i, N/i });
                if (ret[0] > 0) {
                    ans = Math.min(ans, ret[0]);
                }

                ret = chineseRem(b, new long[] { N/i, i });
                if (ret[0] > 0) {
                    ans = Math.min(ans, ret[0]);
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
