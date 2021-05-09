package codeforces._633.D;

import java.io.*;
import java.util.*;

public class Main {
    private List<List<Integer>> g;

    private void dfs(int u, int fa, int[] color) {
        for (int v : g.get(u)) {
            if (v != fa && color[v] == -1) {
                color[v] = color[u] ^ 1;
                dfs(v, u, color);
            }
        }
    }

    private void solve() {
        int n = sc.nextInt();
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
        int[] color = new int[n];
        Arrays.fill(color, -1);
        color[0] = 0;
        dfs(0, -1, color);
        boolean[] exist = new boolean[2];
        boolean[] leaf = new boolean[n];
        for (int u = 0; u < n; u++) {
            if (g.get(u).size() == 1) {
                exist[color[u]] = true;
                leaf[u] = true;
            }
        }

        int max = n - 1;
        for (int u = 0; u < n; u++) {
            int c = 0;
            for (int v : g.get(u)) {
                if (leaf[v]) {
                    ++c;
                }
            }

            max -= Math.max(0, c - 1);
        }

        int min = exist[0] && exist[1] ? 3 : 1;
        out.println(String.format("%d %d", min, max));
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
