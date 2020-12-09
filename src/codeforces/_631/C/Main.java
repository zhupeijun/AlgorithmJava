package codeforces._631.C;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = false;

    private void solve() {
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Integer> a = new ArrayList<>();
        long total = 0;
        for (int i = 0; i < m; i++) {
            int v = sc.nextInt();
            total += v;
            a.add(v);
        }

        if (total < n) {
            out.println(-1);
            return;
        }

        int filled = 0;
        int[] ans = new int[m];
        for (int i = 0, j = 0; i < n; i++) {
            if (i + total >= n) {
                if (i + a.get(j) <= n) {
                    total -= a.get(j);
                    ans[filled++] = i + 1;
                    ++j;
                } else {
                    out.println(-1);
                    return;
                }
            }
        }

        if (filled != m) {
            out.println(-1);
        } else {
            out.printArray(ans);
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