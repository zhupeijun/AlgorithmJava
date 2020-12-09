package codeforces._645.E;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = false;

    private void solve() {
        int n = sc.nextInt();
        int m = (n + 1) / 2;
        int[] a = sc.nextArray(m);
        int x = sc.nextInt();

        long[] p = new long[m];
        for (int i = 0; i < m; ++i) {
            p[0] += a[i];
        }
        p[0] += n % 2 == 0 ? x : 0;

        for (int i = 1; i < m; i++) {
            p[i] = p[i - 1] + x - a[i - 1];
        }

        long[] min = new long[m];
        for (int i = 0; i < m; ++i) {
            min[i] = i == 0 ? p[i] : Math.min(p[i], min[i - 1]);
        }

        long cur = 0;
        for (int i = m - 1, k = n % 2 == 0 ? 1 : 0; i >= 0; --i, ++k) {
            if (min[i] + cur > 0) {
                out.println(m + k);
                return;
            }
            cur += x;
        }
        out.println(-1);
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

        int[] nextArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
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