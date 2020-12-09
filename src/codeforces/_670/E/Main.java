package codeforces._670.E;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = false;

    private void solve() {
        int n = sc.nextInt();
        List<Integer> prime = new ArrayList<>();
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i <= n; ++i) {
            if (isPrime[i]) {
                prime.add(i);
                for (int j = 2; j * i <= n; ++j) {
                    isPrime[i * j] = false;
                }
            }
        }

        boolean[] vis = new boolean[n + 1];
        int gSize = (int)Math.sqrt(prime.size());
        int m = prime.size();
        int cur = n;
        List<Integer> fac = new ArrayList<>();
        boolean getFirst = false;
        for (int i = 0; i < m; ++i) {
            int x = prime.get(i);
            int rm = 0;
            for (int j = x; j <= n; j +=x) {
                if (!vis[j]) {
                    ++rm;
                    vis[j] = true;
                }
            }

            out.println(String.format("B %d", x));
            out.flush();
            int ret = sc.nextInt();
            if (rm != ret) {
                fac.add(x);
            }

            cur -= rm;
            if (i == m - 1 || i % gSize == gSize - 1) {
                if (!getFirst) {
                    out.println("A 1");
                    out.flush();
                    ret = sc.nextInt();
                    if (ret != cur) {
                        getFirst = true;
                        for (int j = i / gSize * gSize; j <= i; ++j) {
                            out.println(String.format("A %d", prime.get(j)));
                            out.flush();
                            ret = sc.nextInt();
                            if (ret != 0) {
                                fac.add(prime.get(j));
                                break;
                            }
                        }
                    }
                }
            }
        }

        int ans = 1;
        for (int x : fac) {
            long v = x;
            while (v * x <= n) { v *= x; }
            while (v > 1) {
                out.println(String.format("A %d", v));
                out.flush();
                int ret = sc.nextInt();
                if (ret == 1) {
                    ans *= v;
                    break;
                }
                v /= x;
            }
        }
        out.println(String.format("C %d", ans));
        out.flush();
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