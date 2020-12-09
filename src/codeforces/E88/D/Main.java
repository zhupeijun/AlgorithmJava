package codeforces.E88.D;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = false;
    private static final int M = 30;

    private void solve() {
        int n = sc.nextInt();
        int[] a = sc.nextArray(n);

        int[][] pre = new int[n][M + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= M; j++) {
                if (j >= a[i]) {
                    if (i > 0) {
                        pre[i][j] = Math.max(0, pre[i - 1][j] + a[i]);
                    } else {
                        pre[i][j] = Math.max(0, a[i]);
                    }
                } else {
                    pre[i][j] = 0;
                }
            }
        }

        int[][] suf = new int[n][M + 1];
        for (int i = n - 1; i >= 0; --i) {
            for (int j = 0; j <= M; ++j) {
                if (j >= a[i]) {
                    if (i + 1 < n) {
                        suf[i][j] = Math.max(0, suf[i + 1][j] + a[i]);
                    } else {
                        suf[i][j] = Math.max(0, a[i]);
                    }
                } else {
                    suf[i][j] = 0;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] < 0) {
                continue;
            }

            int left = i == 0 ? 0 : pre[i - 1][a[i]];
            int right = i == n - 1 ? 0 : suf[i + 1][a[i]];

            ans = Math.max(ans, left + right);
        }
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