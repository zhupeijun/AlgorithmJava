package codeforces.E87.E;

import java.io.*;
import java.util.*;

public class Main {

    private List<List<Integer>> g;
    private List<Map<Integer, Integer>> sg;
    private boolean[] vis;
    private List<int[]> cnt;
    private int n;
    private int m;
    private int n1;
    private int n2;
    private int n3;
    private Boolean[][] memo;

    private boolean div(int root) {
        Queue<Integer> q = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] c = new int[2];

        q.add(root);
        map.put(root, 0);
        while (!q.isEmpty()) {
            int u = q.poll();
            vis[u] = true;
            ++c[map.get(u)];
            for (int v : g.get(u)) {
                if (map.containsKey(v)) {
                    if (map.get(u).equals(map.get(v))) {
                        return false;
                    }
                } else {
                    map.put(v, map.get(u) ^ 1);
                    q.add(v);
                }
            }
        }
        sg.add(map);
        cnt.add(c);
        return true;
    }

    private boolean dp(int i, int r2, int total, List<Integer> sol) {
        if (i == cnt.size()) {
            return true;
        }

        if (memo[i][r2] != null) {
            return memo[i][r2];
        }

        int m1 = cnt.get(i)[0];
        int m2 = cnt.get(i)[1];

        int r1 = total - r2;
        total += m1 + m2;

        if (m2 + r2 <= n2 && m1 + r1 <= n1 + n3) {
            sol.add(0);
            if (dp(i + 1, r2 + m2, total, sol)) {
                memo[i][r2] = true;
                return memo[i][r2];
            }
            sol.remove(sol.size() - 1);
        }

        if (m2 + r1 <= n1 + n3 && m1 + r2 <= n2) {
            sol.add(1);
            if (dp(i + 1, r2 + m1, total, sol)) {
                memo[i][r2] = true;
                return memo[i][r2];
            }
            sol.remove(sol.size() -1);
        }
        memo[i][r2] = false;
        return memo[i][r2];
    }

    private void fill(int[] c, List<Integer> ans) {
        for (int i = 0; i < ans.size(); ++i) {
            for (Map.Entry<Integer, Integer> e : sg.get(i).entrySet()) {
                int u = e.getKey();
                int v = e.getValue() ^ ans.get(i);

                if (v == 0) {
                    if (n1 > 0) {
                        c[u] = 1;
                        --n1;
                    } else {
                        c[u] = 3;
                        --n3;
                    }
                } else {
                    c[u] = 2;
                    --n2;
                }
            }
        }
    }

    private void solve() {
        n = sc.nextInt();
        m = sc.nextInt();

        n1 = sc.nextInt();
        n2 = sc.nextInt();
        n3 = sc.nextInt();

        g = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            g.get(u).add(v);
            g.get(v).add(u);
        }

        sg = new ArrayList<>();
        cnt = new ArrayList<>();
        vis = new boolean[n + 1];

        for (int u = 1; u <= n; u++) {
            if (!vis[u]) {
                if (!div(u)) {
                    out.println("NO");
                    return;
                }
            }
        }

        memo = new Boolean[sg.size()][n + 1];

        List<Integer> ans = new ArrayList<>();
        if (!dp(0, 0, 0, ans)) {
            out.println("NO");
        } else {
            out.println("YES");
            int[] c = new int[n + 1];
            fill(c, ans);
            StringBuilder sb = new StringBuilder();
            for (int u = 1; u <= n; ++u) {
                sb.append(c[u]);
            }
            out.println(sb.toString());
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
