package codeforces._646.E;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = false;

    private List<List<Integer>> g;
    private int[] a;
    private int[] b;
    private int[] c;
    private long ans = 0;

    private void update(int u, int fa) {
        if (fa != -1) {
            a[u] = Math.min(a[u], a[fa]);
        }

        for (int v : g.get(u)) {
            if (v != fa) {
                update(v, u);
            }
        }
    }

    private int[] dfs(int u, int fa) {
        int[] cnt = new int[] { 0, 0 };
        for (int v : g.get(u)) {
            if (v != fa) {
                int[] r = dfs(v, u);
                cnt[0] += r[0];
                cnt[1] += r[1];
            }
        }

        if (b[u] != c[u]) {
            ++cnt[b[u]];
        }

        int pick = Math.min(cnt[0], cnt[1]);
        ans += (long)pick * a[u] * 2;
        cnt[0] -= pick;
        cnt[1] -= pick;
        return cnt;
    }

    private void solve() {
        int n = sc.nextInt();
        a = new int[n];
        b = new int[n];
        c = new int[n];

        int sumB = 0, sumC = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            c[i] = sc.nextInt();
            sumB += b[i];
            sumC += c[i];
        }

        g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            g.get(u).add(v);
            g.get(v).add(u);
        }

        if (sumB != sumC) {
            out.println(-1);
            return;
        }

        update(0, -1);
       // System.out.println(Arrays.toString(a));

        dfs(0, -1);
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