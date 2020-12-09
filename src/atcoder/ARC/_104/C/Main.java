package atcoder.ARC._104.C;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = false;

    private boolean in(int x, int i, int j) {
        return x > i && x <= j;
    }

    private void solve() {
        int N = sc.nextInt();
        int[] A = new int[N], B = new int[N];
        for (int i = 0; i < N; ++i) {
            A[i] = sc.nextInt(); B[i] = sc.nextInt();
        }

        int M = N * 2;
        boolean[] dp = new boolean[M + 1];
        dp[0] = true;
        for (int i = 0; i < M; ++i) {
            if (dp[i]) {
                for (int j = i + 2; j <= M; j += 2) {
                    boolean ok = true;
                    int w = (j - i) / 2;
                    boolean[] fixed = new boolean[M + 1];
                    for (int k = 0; k < N; ++k) {
                        boolean a = in(A[k], i, j);
                        boolean b = in(B[k], i, j);
                        if (A[k] != -1 && B[k] != -1) {
                            if (a && b) {
                                if (w != B[k] - A[k]) { ok = false; break; }
                                else {
                                    if (fixed[A[k]] || fixed[B[k]]) { ok = false; break; }
                                    fixed[A[k]] = fixed[B[k]] = true;
                                }
                            } else if (a || b) {
                                ok = false; break;
                            }
                        } else if (A[k] == -1) {
                            if (b) {
                                int x = B[k] - w;
                                if (!in(x, i, j)) { ok = false; break; }
                                if (fixed[x] || fixed[B[k]]) { ok = false; break; }
                                fixed[x] = fixed[B[k]] = true;
                            }
                        } else if (B[k] == -1) {
                            if (a) {
                                int y = A[k] + w;
                                if (!in(y, i, j)) { ok = false; break; }
                                if (fixed[A[k]] || fixed[y]) { ok = false; break; }
                                fixed[A[k]] = fixed[y] = true;
                            }
                        }
                    }
                    if (ok) {
                        dp[j] = true;
                    }
                }
            }
        }
        out.println(dp[M] ? "Yes" : "No");
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