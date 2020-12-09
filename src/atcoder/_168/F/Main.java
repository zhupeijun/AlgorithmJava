package atcoder._168.F;

import java.io.*;
import java.util.*;

public class Main {

    static class UnionSet {
        int[] count;
        int[] rank;
        int[] parent;

        UnionSet(int n) {
            count = new int[n];
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                count[i] = 1;
                rank[i] = 1;
            }
        }

        int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int x, int y) {
            x = find(x);
            y = find(y);

            if (x != y) {
                if (rank[x] > rank[y]) {
                    parent[y] = x;
                    count[x] += count[y];
                } else {
                    parent[x] = y;
                    count[y] += count[x];
                    if (rank[x] == rank[y]) {
                        ++rank[x];
                    }
                }
            }
        }
    }

    private void solve() {
        int n = sc.nextInt();
        int m = sc.nextInt();

        Integer[] A = new Integer[n], B = new Integer[n], C = new Integer[n];
        Integer[] D = new Integer[m], E = new Integer[m], F = new Integer[m];

        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
            B[i] = sc.nextInt();
            C[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            D[i] = sc.nextInt();
            E[i] = sc.nextInt();
            F[i] = sc.nextInt();
        }

        Set<Integer> xs = new HashSet<>(Arrays.asList(Integer.MIN_VALUE, Integer.MAX_VALUE, 0));
        xs.addAll(Arrays.asList(A));
        xs.addAll(Arrays.asList(B));
        xs.addAll(Arrays.asList(D));

        Set<Integer> ys = new HashSet<>(Arrays.asList(Integer.MIN_VALUE, Integer.MAX_VALUE, 0));
        ys.addAll(Arrays.asList(C));
        ys.addAll(Arrays.asList(E));
        ys.addAll(Arrays.asList(F));

        List<Integer> xl = new ArrayList<>(xs);
        List<Integer> yl = new ArrayList<>(ys);

        Collections.sort(xl);
        Collections.sort(yl);

        Map<Integer, Integer> xinv = new HashMap<>();
        for (int x : xl) {
            xinv.put(x, xinv.size());
        }

        Map<Integer, Integer> yinv = new HashMap<>();
        for (int y : yl) {
            yinv.put(y, yinv.size());
        }

        int xn = xs.size() - 1;
        int yn = ys.size() - 1;

        boolean[][] cy = new boolean[xn][yn];
        for (int i = 0; i < n; i++) {
            int y = yinv.get(C[i]);
            for (int x = 1; x < xn; ++x) {
                if (xl.get(x - 1) >= A[i] && xl.get(x) <= B[i]) {
                    cy[x - 1][y - 1] = true; // (x,y) (x, y + 1)
                }
            }
        }

        boolean[][] cx = new boolean[xn][yn];
        for (int i = 0; i < m; ++i) {
            int x = xinv.get(D[i]);
            for (int y = 1; y < yn; ++y) {
                if (yl.get(y - 1) >= E[i] && yl.get(y) <= F[i]) {
                    cx[x - 1][y - 1] = true; // (x, y) (x + 1, y)
                }
            }
        }

        UnionSet us = new UnionSet(xn * yn);
        for (int x = 0; x < xn; ++x) {
            for (int y = 0; y < yn; ++y) {
                if (y + 1 < yn && !cy[x][y]) {
                    us.union(x * yn + y, x * yn + y + 1);
                }

                if (x + 1 < xn && !cx[x][y]) {
                    us.union(x * yn + y, (x + 1) * yn + y);
                }
            }
        }

        int ox = xinv.get(0), oy = yinv.get(0);

        for (int x = 0; x < xn; ++x) {
            for (int y = 0; y < yn; ++y) {
                if (x == 0 || x == xn - 1 || y == 0 || y == yn - 1) {
                    if (us.find(x * yn + y) == us.find(ox * yn + oy)) {
                        out.println("INF");
                        return;
                    }
                }
            }
        }

        long ans = 0;
        for (int x = 0; x < xn; ++x) {
            for (int y = 0; y < yn; ++y) {
                if (us.find(x * yn + y) == us.find(ox * yn + oy)) {
                    long xd = xl.get(x + 1) - xl.get(x);
                    long yd = yl.get(y + 1) - yl.get(y);

                    ans += xd * yd;
                }
            }
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
