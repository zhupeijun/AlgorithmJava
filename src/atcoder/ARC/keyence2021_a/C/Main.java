package atcoder.ARC.keyence2021_a.C;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static final boolean N_CASE = false;

    private static final int MOD = 998244353;
    private int add(int a, int b) { return (((a + b) % MOD + MOD) % MOD);}
    private int mul(int a, int b) { return (int)(((long)a * b) % MOD); }

    private void solve() {
        int H = sc.nextInt();
        int W = sc.nextInt();
        int K = sc.nextInt();

        Character[][] g = new Character[H][W];
        for (int i = 0; i < K; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            String c = sc.next();

            g[x][y] = c.charAt(0);
        }

        int[][] cw = new int[H+1][W+1];
        for (int j = W - 1; j >= 0; --j) {
            for (int i = 0; i < H; ++i) {
                cw[i][j] = cw[i][j+1] + (g[i][j] == null ? 1 : 0);
            }
        }

        int[][] ch = new int[H+1][W+1];
        for (int i = H - 1; i >= 0; --i) {
            for (int j = 0; j < W; ++j) {
                ch[i][j] = ch[i+1][j] + (g[i][j] == null ? 1 : 0);
            }
        }

        int M = Math.max(H, W);
        int[] p3 = new int[M+1]; p3[0] = 1;
        for (int i = 1; i <= M; i++) {
            p3[i] = mul(p3[i-1], 3);
        }

        int[][] dp = new int[H + 1][W + 1];
        dp[0][0] = 1;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (g[i][j] == null) {
                    dp[i + 1][j] = add(dp[i + 1][j], mul(dp[i][j], p3[cw[i][j + 1]]));
                    dp[i][j + 1] = add(dp[i][j + 1], mul(dp[i][j], p3[ch[i + 1][j]]));
                    dp[i + 1][j] = add(dp[i + 1][j], mul(dp[i][j], p3[cw[i][j + 1]]));
                    dp[i][j + 1] = add(dp[i][j + 1], mul(dp[i][j], p3[ch[i + 1][j]]));
                } else if (g[i][j] == 'R') {
                    dp[i][j + 1] = add(dp[i][j + 1], mul(dp[i][j], p3[ch[i + 1][j]]));
                } else if (g[i][j] == 'D') {
                    dp[i + 1][j] = add(dp[i + 1][j], mul(dp[i][j], p3[cw[i][j + 1]]));
                } else {
                    dp[i + 1][j] = add(dp[i + 1][j], mul(dp[i][j], p3[cw[i][j + 1]]));
                    dp[i][j + 1] = add(dp[i][j + 1], mul(dp[i][j], p3[ch[i + 1][j]]));
                }
            }
        }
        out.println(mul(dp[H-1][W-1], g[H-1][W-1] == null ? 3 : 1));
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