package codeforces._651.C;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = true;

    private List<Integer> prime;
    private static final int M = 40000;

    private void sieve() {
        prime = new ArrayList<>();
        boolean[] isPrime = new boolean[M];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i < M; i++) {
            if (isPrime[i]) {
                prime.add(i);
                for (int j = 2; j * i < M; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
    }

    private void add(int[] c, int p) {
        if (p % 2 == 0) {
            ++c[0];
        } else {
            ++c[1];
        }
    }

    private void solve() {
        int n = sc.nextInt();
        boolean ans = true;

        if (n == 1) {
            ans = false;
        } else if (n != 2) {
            int x = n;
            int[] c = new int[2];
            for (int p : prime) {
                if (x % p == 0) {
                    while (x % p == 0) {
                        x /= p;
                        add(c, p);
                    }
                }
            }

            if (x > 1) {
                add(c, x);
            }

//            System.out.println(c[0] + " " + c[1]);
            if (c[1] == 0 || (c[1] == 1 && c[0] == 1)) {
                ans = false;
            }
        }

        out.println(ans ? "Ashishgup" : "FastestFinger");
    }

    private void run() {
        sieve();
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