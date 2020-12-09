package codeforces._634.E;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = true;
    private static final int M = 200;

    private void solve() {
        int n = sc.nextInt();
        int[] a = sc.nextArray(n);

        int[] cnt = new int[M + 1];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ++cnt[a[i]];
            ans = Math.max(ans, cnt[a[i]]);
        }

        int[] ri = new int[n];
        int[] len = new int[n];
        Arrays.fill(ri, -1);

        for (int k = 1; k <= M; k++) {
            int left = 0, right = n - 1, l = 0;
            while (left < right) {
                while (left < n && a[left] != k) {
                    ++left;
                }
                while (right >= 0 && a[right] != k) {
                    --right;
                }

                l += 2;
                if (left < right) {
                    ri[left] = right;
                    len[left] = l;
                }
                ++left;
                --right;
            }
        }

        int[][] suf = new int[n][M + 1];
        for (int i = n - 1; i >= 0; --i) {
            if (i < n - 1) {
                System.arraycopy(suf[i + 1], 1, suf[i], 1, M);
            }
            ++suf[i][a[i]];
        }

        int[] pre = new int[M + 1];
        for (int i = 0; i < n; i++) {
            ++pre[a[i]];
            if (ri[i] != -1) {
                for (int k = 1; k <= M; ++k) {
                    ans = Math.max(ans, len[i] + cnt[k] - pre[k] - suf[ri[i]][k]);
                }
            }
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