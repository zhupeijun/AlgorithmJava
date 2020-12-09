package codeforces._646.B;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = true;

    private void solve() {
        String s = sc.next();

        int n = s.length();
        int[] pre = new int[n];
        for (int i = 0; i < n; i++) {
            pre[i] += s.charAt(i) - '0';
            pre[i] += i > 0 ? pre[i - 1] : 0;
        }

        int[] suf = new int[n];
        for (int i = n - 1; i >= 0; --i) {
            suf[i] += s.charAt(i) - '0';
            suf[i] += i < n - 1 ? suf[i + 1] : 0;
        }

        int ans = n;
        for (int i = 0; i < n; i++) {
            int t = i + 1 - pre[i];
            t += i + 1 < n ? suf[i + 1] : 0;
            ans = Math.min(ans, t);

            t = pre[i];
            t += i + 1 < n ? n - 1 - i - suf[i + 1] : 0;
            ans = Math.min(ans, t);
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