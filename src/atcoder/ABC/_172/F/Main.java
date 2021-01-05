package atcoder.ABC._172.F;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = false;

    private void solve() {
        int N = sc.nextInt();
        long[] A = sc.nextLongArray(N);
        long a = A[0];
        long s = A[0] + A[1];
        long x = 0;
        for (int i = 2; i < N; ++i) { x ^= A[i]; }

        int K = 42;
        long[][][] dp = new long[K + 1][2][2];
        fill(dp, -1);
        dp[0][0][0] = 0;
        for (int i = 0; i < K; ++i) {
            long ca = a & 1;
            long cs = s & 1;
            long cx = x & 1;

            for (int j = 0; j < 2; ++j) {
                for (int k = 0; k < 2; ++k) {
                    if (dp[i][j][k] == -1) continue;
                    for (int ba = 0; ba < 2; ++ba) {
                        for (int bb = 0; bb < 2; ++bb) {
                            int ns = ba + bb + j;
                            if (ns % 2 != cs) continue;
                            if ((ba ^ bb) != cx) continue;
                            int ni = i + 1;
                            int nj = ns >> 1;
                            int nk = ca < ba ? 1 : (ca == ba ? k : 0);

                            dp[ni][nj][nk] = Math.max(dp[ni][nj][nk], dp[i][j][k] + ((long)ba << i));
                        }
                    }
                }
            }

            a >>= 1;
            s >>= 1;
            x >>= 1;
        }

        long ans = dp[K - 1][0][0];
        if (ans == -1 || ans == 0) {
            out.println(-1);
            return;
        }

        ans = A[0] - ans;
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

    private void fill(int[][][] a, int value) { for (int[][] x : a) { fill(x, value); } }
    private void fill(int[][] a, int value) { for (int[] x : a) { fill(x, value); } }
    private void fill(int[] a, int value) {  Arrays.fill(a, value); }
    private void fill(long[][][] a, long value) { for (long[][] x : a) { fill(x, value); } }
    private void fill(long[][] a, long value) { for (long[] x : a) { fill(x, value); } }
    private void fill(long[] a, long value) {  Arrays.fill(a, value); }

    public static void main(String[] args) {
        out = new MyWriter(new BufferedOutputStream(System.out));
        sc = new MyScanner();
        new Main().run();
        out.close();
    }
}