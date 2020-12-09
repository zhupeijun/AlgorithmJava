package atcoder._165.F;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private List<List<Integer>> g;
    private int[] a;
    private int[] ans;

    private int bs(List<Integer> list, int t) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (list.get(mid) >= t) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private void dfs2(int u, int fa, List<Integer> buf) {
        for (int v : g.get(u)) {
            if (v != fa) {
                dfs(v, u, buf);
            }
        }
    }

    private void dfs(int u, int fa, List<Integer> buf) {
        int t = bs(buf, a[u]);
        if (t == buf.size() - 1) {
            buf.add(a[u]);
            ans[u] = buf.size();
            dfs2(u, fa, buf);
            buf.remove(buf.size() - 1);
        } else {
            int tmp = buf.get(t + 1);
            if (a[u] < tmp) {
                buf.set(t + 1, a[u]);
                dfs2(u, fa, buf);
                buf.set(t + 1, tmp);
            } else {
                dfs2(u, fa, buf);
            }
            ans[u] = buf.size();
        }
    }

    private void solve() {
        int n = sc.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
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

        ans = new int[n];
        dfs(0, -1, new ArrayList<>());

        Arrays.stream(ans).forEach(out::println);
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
