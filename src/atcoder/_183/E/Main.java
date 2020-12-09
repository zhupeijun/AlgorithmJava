package atcoder._183.E;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = false;
    private static final int MOD = 1000_000_007;
    private long add(long a, long b) { return (((a + b) % MOD + MOD) % MOD);}
    private long sub(long a, long b) { return (((a - b) % MOD + MOD) % MOD); }
    private long mul(long a, long b) { return (((a * b) % MOD + MOD) % MOD); }
    private long div(long a, long b) { return (((a * inv(b)) % MOD + MOD) % MOD); }
    private long inv(long a) { return pow(a, MOD - 2); }
    private long pow(long a, int n) {
        long ret = 1;
        while (n > 0) {
            if ((n & 1) > 0) { ret = mul(ret, a); }
            a = mul(a, a);
            n >>= 1;
        }
        return ret;
    }

    private void solve() {
        int H = sc.nextInt();
        int W = sc.nextInt();
        char[][] g = sc.nextCharArray(H, W);
        long[][] dp = new long[H+1][W+1];
        long[][][] sum = new long[H+1][W+1][3];
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= W; j++) {
                if (i == 1 && j == 1) {
                    dp[i][j] = 1;
                    sum[i][j][0] = sum[i][j][1] = sum[i][j][2] = 1;
                    continue;
                }

                if (g[i-1][j-1] == '.') {
                    dp[i][j] = add(dp[i][j], sum[i-1][j][0]);
                    dp[i][j] = add(dp[i][j], sum[i][j-1][1]);
                    dp[i][j] = add(dp[i][j], sum[i-1][j-1][2]);
                    sum

                            [i][j][0] = add(sum[i-1][j][0], dp[i][j]);
                    sum[i][j][1] = add(sum[i][j-1][1], dp[i][j]);
                    sum[i][j][2] = add(sum[i-1][j-1][2], dp[i][j]);
                }
            }
        }
        out.println(dp[H][W]);
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