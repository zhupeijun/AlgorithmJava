package codeforces._636.D;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = true;

    private void solve() {
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = sc.nextArray(n);

        int m = k * 2 + 2;
        int[] cnt = new int[m];

        int max = k * 2;
        int n2 = n / 2;
        for (int i = 0; i < n2; i++) {
            int x = a[i];
            int y = a[n - 1 - i];

            int s = x + y;
            int l = Math.min(x, y) + 1;
            int r = Math.max(x, y) + k;

            if (2 < l) {
                cnt[2] += 2;
                cnt[l] -= 2;
            }

            if (l < s) {
                ++cnt[l];
                --cnt[s];
            }

            if (s < r) {
                ++cnt[s + 1];
                --cnt[r + 1];
            }

            if (r < max) {
                cnt[r + 1] += 2;
                cnt[max + 1] -= 2;
            }
        }

        int ans = n * 2;
        int cur = 0;
        for (int i = 2; i <= max; ++i) {
            cur += cnt[i];
            ans = Math.min(ans, cur);
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