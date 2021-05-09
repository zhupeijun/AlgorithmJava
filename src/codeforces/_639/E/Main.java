package codeforces._639.E;

import java.io.*;
import java.util.*;

public class Main {

    private boolean hasCir(List<List<Integer>> g) {
        int n = g.size();
        int[] d = new int[n];
        for (List<Integer> child : g) {
            for (int v : child) {
                ++d[v];
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int u = 0; u < n; u++) {
            if (d[u] == 0) {
                q.add(u);
            }
        }

        int r = n;
        while (!q.isEmpty()) {
            int u = q.poll();
            --r;
            for (int v : g.get(u)) {
                --d[v];
                if (d[v] == 0) {
                    q.add(v);
                }
            }
        }

        return r != 0;
    }

    private void dfs(int u, char[] ans, List<List<Integer>> g) {
        for (int v : g.get(u)) {
            if (ans[v] == 0) {
                ans[v] = 'E';
                dfs(v, ans, g);
            }
        }
    }

    private void solve() {
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Integer>> go = new ArrayList<>();
        List<List<Integer>> gr = new ArrayList<>();
        for (int u = 0; u < n; ++u) {
            go.add(new ArrayList<>());
            gr.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;

            go.get(u).add(v);
            gr.get(v).add(u);
        }

        if (hasCir(go) || hasCir(gr)) {
            out.println(-1);
            return;
        }

        char[] ao = new char[n];
        char[] ar = new char[n];
        for (int u = 0; u < n; ++u) {
            if (ao[u] == 0) {
                ao[u] = 'A';
                dfs(u, ao, go);
            }

            if (ar[u] == 0) {
                ar[u] = 'A';
                dfs(u, ar, gr);
            }
        }

        char[] ans = new char[n];
        int count = 0;
        for (int u = 0; u < n; u++) {
            ans[u] = ao[u] == 'A' && ar[u] == 'A' ? 'A' : 'E';
            count += ans[u] == 'A' ? 1 : 0;
        }

        out.println(count);
        out.println(new String(ans));
    }

    private static PrintWriter out;
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
    }

    public static void main(String[] args) {
        out = new PrintWriter(new BufferedOutputStream(System.out));
        sc = new MyScanner();
        new Main().solve();
        out.close();
    }
}
