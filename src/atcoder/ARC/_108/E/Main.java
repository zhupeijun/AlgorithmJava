package atcoder.ARC._108.E;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = false;

    private static final int MOD = 1000_000_007;
    private static long add(long a, long b) { return (((a + b) % MOD + MOD) % MOD);}
    private static long sub(long a, long b) { return (((a - b) % MOD + MOD) % MOD); }
    private static long mul(long a, long b) { return (((a * b) % MOD + MOD) % MOD); }
    private static long div(long a, long b) { return (((a * inv(b)) % MOD + MOD) % MOD); }
    private static long inv(long a) { return pow(a, MOD - 2); }
    private static long pow(long a, int n) {
        long ret = 1;
        while (n > 0) {
            if ((n & 1) > 0) { ret = mul(ret, a); }
            a = mul(a, a);
            n >>= 1;
        }
        return ret;
    }

    private static class BIT {
        long[] dat;
        int n;

        BIT(int n) {
            this.n = n;
            this.dat = new long[n + 1];
        }

        long sum(int i) {
            long s = 0;
            while (i > 0) {
                s = add(s, dat[i]);
                i -= (i & -i);
            }
            return s;
        }

        void addX(int i, long x) {
            while (i <= n) {
                dat[i] = add(dat[i], x);
                i += (i & -i);
            }
        }
    }

    private void solve() {
        int N = sc.nextInt();
        int M = N + 2;
        int[] a = new int[M];
        a[0] = 0; a[N + 1] = N + 1;
        for (int i = 1; i <= N; ++i) {
            a[i] = sc.nextInt();
        }

        BIT[] cs = new BIT[M];
        BIT[] dl = new BIT[M];
        BIT[] dr = new BIT[M];
        for (int i = 0; i < M; i++) {
            cs[i] = new BIT(M + 1);
            dl[i] = new BIT(M + 1);
            dr[i] = new BIT(M + 1);
        }

        long[][] dp = new long[M][M];
        for (int w = 2; w <= M; ++w) {
            for (int l = 0; l < M; ++l) {
                int r = l + w - 1;
                if (r >= M) {
                    break;
                }

                long e = 0;
                e = add(e, dl[l].sum(a[r] + 1) - dl[l].sum(a[l]));
                e = add(e, dr[r].sum(a[r] + 1) - dr[r].sum(a[l]));

                long cnt = cs[l].sum(a[r] + 1) - cs[l].sum(a[l]);
                if (cnt > 0) {
                    e = div(e, cnt);
                    e = add(e, 1);
                }
                dp[l][r] = e;

                cs[l].addX(a[r] + 1, 1L);
                dl[l].addX(a[r] + 1, e);
                dr[r].addX(a[l] + 1, e);
            }
        }

        out.println(dp[0][M - 1]);
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