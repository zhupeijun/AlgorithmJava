package codeforces.G7.D;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = true;
    private static final long B = 256;
    private static final long M = 1000000000007L;

    private char[] reverse(char[] c) {
        int n = c.length;
        char[] d = new char[n];
        for (int i = 0; i < n; ++i) {
            d[i] = c[n - i - 1];
        }
        return d;
    }

    private void solve() {
        char[] c = sc.nextCharArray();
        char[] d = reverse(c);
        int n = c.length;

        int i = 0, j = n - 1;
        while (i <= j && c[i] == c[j]) {
            ++i;
            --j;
        }

        if (j < i) {
            out.println(new String(c));
            return;
        }

        long ah = 0;
        long bh = 0;
        int m1 = i;
        long t = 1;
        for (int k = i; k <= j; ++k) {
            ah = (ah + (c[k] - 'a') * t) % M;
            bh = (bh * B + (d[j - (k - i)] - 'a')) % M;
            t = (t * B) % M;
            if (ah == bh) {
                m1 = k;
            }
        }

        ah = 0;
        bh = 0;
        int m2 = j;
        t = 1;
        for (int k = j; k >= i; --k) {
            ah = (ah + (d[i + (j - k)] - 'a') * t) % M;
            bh = (bh * B + (c[k] - 'a')) % M;
            t = (t * B) % M;
            if (ah == bh) {
                m2 = k;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int l = 0; l < i; ++l) {
            sb.append(c[l]);
        }
        if (m1 - i > j - m2) {
            for (int l = i; l <= m1; ++l) {
                sb.append(c[l]);
            }
        } else {
            for (int l = m2; l <= j; ++l) {
                sb.append(c[l]);
            }
        }

        for (int l = j + 1; l < n; ++l) {
            sb.append(c[l]);
        }
        out.println(sb.toString());
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

        char[] nextCharArray() {
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

    public static void main(String[] args) {
        out = new MyWriter(new BufferedOutputStream(System.out));
        sc = new MyScanner();
        new Main().run();
        out.close();
    }
}