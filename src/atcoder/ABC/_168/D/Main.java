package atcoder.ABC._168.D;

import java.io.*;
import java.util.*;

public class Main {
    private void solve() {
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            g.get(u).add(v);
            g.get(v).add(u);
        }

        boolean[] vis = new boolean[n + 1];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        vis[1] = true;
        int[] ans = new int[n + 1];
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : g.get(u)) {
                if (!vis[v]) {
                    ans[v] = u;
                    vis[v] = true;
                    q.add(v);
                }
            }
        }

        boolean ok = true;
        for (int u = 2; u <= n; ++u) {
            if (ans[u] == 0) {
                ok = false;
                break;
            }
        }

        if (ok) {
            out.println("Yes");
            for (int u = 2; u <= n; ++u) {
                out.println(ans[u]);
            }
        } else {
            out.println("No");
        }
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
