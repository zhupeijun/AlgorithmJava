package hackercup._2020.R2;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = true;

    private long[] cal(long[] s, long[] p, int N, int K) {
        long[] ans = new long[N];
        for (int i = 0; i < N; i++) {
            if (i < K) {
                ans[i] = s[i];
            } else {
                ans[i] = (p[0] * ans[i - 2] + p[1] * ans[i - 1] + p[2]) % p[3];
            }
        }
        return ans;
    }

    private void solve() {
        int N = sc.nextInt();
        int K = sc.nextInt();

        long[] S = cal(sc.nextLongArray(K), sc.nextLongArray(4), N, K);
        long[] X = cal(sc.nextLongArray(K), sc.nextLongArray(4), N, K);
        long[] Y = cal(sc.nextLongArray(K), sc.nextLongArray(4), N, K);

        for (int i = 0; i < N; i++) {
            Y[i] += X[i];
        }

        long U = 0, D = 0, UI = 0, DI = 0, MU = 0, MD = 0;
        for (int i = 0; i < N; i++) {
            if (S[i] > Y[i]) {
                U += S[i] - Y[i];
                UI += Y[i] - X[i];
            } else if (S[i] < X[i]) {
                D += X[i] - S[i];
                DI += Y[i] - X[i];
            } else {
                MU += Y[i] - S[i];
                MD += S[i] - X[i];
            }
        }

        if (U == D) {
            out.println(U);
        } else if (U > D) {
            if (U - D > DI) {
                if (U - D - DI > MU) {
                    out.println(-1);
                } else {
                    out.println(U);
                }
            } else {
                out.println(U);
            }
        } else {
            if (D - U > UI) {
                if (D - U - UI > MD) {
                    out.println(-1);
                } else {
                    out.println(D);
                }
            } else {
                out.println(D);
            }
        }
    }

    private void run() {
        int T = N_CASE ? sc.nextInt() : 1;
        for (int t = 0; t < T; ++t) {
            out.print(String.format("Case #%d: ", t + 1));
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
        try {
            out = new MyWriter(new FileOutputStream("output.txt"));
            //out = new MyWriter(new BufferedOutputStream(System.out));
            sc = new MyScanner();
            new Main().run();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}