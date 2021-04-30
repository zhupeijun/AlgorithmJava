package atcoder.ABC._189.E;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = false;

    private void solve() {
        int N = sc.nextInt();
        int[] X = new int[N+1];
        int[] Y = new int[N+1];
        for (int i = 1; i <= N; ++i) {
            X[i] = sc.nextInt();
            Y[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        long[] a = new long[M+1];
        long[] b = new long[M+1];
        long[] ap = new long[M+1];
        long[] bp = new long[M+1];
        int[] sw = new int[M+1];
        a[0] = 1;
        b[0] = 1;
        int swap = 0;
        for (int i = 1; i <= M; i++) {
            int op = sc.nextInt();
            a[i] = a[i-1];
            ap[i] = ap[i-1];
            b[i] = b[i-1];
            bp[i] = bp[i-1];
            if (op == 1) {
                if (swap == 0) {
                    a[i] = -a[i];
                    ap[i] = -ap[i];
                } else {
                    b[i] = -b[i];
                    bp[i] = -bp[i];
                }
                swap ^= 1;
            } else if (op == 2) {
                if (swap == 0) {
                    b[i] = -b[i];
                    bp[i] = -bp[i];
                } else {
                    a[i] = -a[i];
                    ap[i] = -ap[i];
                }
                swap ^= 1;
            } else if (op == 3) {
                int p = sc.nextInt();
                if (swap == 0) {
                    a[i] = -a[i];
                    ap[i] = -ap[i] + 2L * p;
                } else {
                    b[i] = -b[i];
                    bp[i] = -bp[i] + 2L * p;
                }
            } else if (op == 4) {
                int p = sc.nextInt();
                if (swap == 0) {
                    b[i] = -b[i];
                    bp[i] = -bp[i] + 2L * p;
                } else {
                    a[i] = -a[i];
                    ap[i] = -ap[i] + 2L * p;
                }
            }
            sw[i] = swap;
        }

        int Q = sc.nextInt();
        while (Q-- > 0) {
            int tj = sc.nextInt();
            int ti = sc.nextInt();

            long ax = X[ti] * a[tj] + ap[tj];
            long ay = Y[ti] * b[tj] + bp[tj];
            if (sw[tj] == 0) {
                out.println(ax + " " + ay);
            } else {
                out.println(ay + " " + ax);
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
            String s = next();
            int v = 0;
            boolean neg = false;
            if (s.charAt(0) == '-') {
                neg = true;
            } else {
                v = s.charAt(0) - '0';
            }
            for (int i = 1; i < s.length(); ++i) {
                v = v * 10 + s.charAt(i) - '0';
            }
            return neg ? -v : v;
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