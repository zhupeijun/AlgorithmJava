package codeforces._635.C;

import java.io.*;
import java.util.*;

public class Main {
    private int n;
    private int k;
    private List<List<Integer>> g;
    private PriorityQueue<Integer> q;

    private int dfs(int u, int fa, int d) {
        int c = 0;
        for(int v : g.get(u)) {
            if (v != fa) {
                c += dfs(v, u, d + 1);
            }
        }
        q.add(d - c);
        if (q.size() > k) {
            q.poll();
        }
        return c + 1;
    }
    
    private void solve() {
        n = sc.nextInt();
        k = sc.nextInt();

        g = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            g.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            g.get(u).add(v);
            g.get(v).add(u);
        }

        q = new PriorityQueue<>();
        dfs(1, -1, 0);
        long ans = 0;
        for (int v : q) {
            ans += v;
        }
        out.println(ans);
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
