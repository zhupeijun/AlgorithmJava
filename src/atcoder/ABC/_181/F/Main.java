package atcoder.ABC._181.F;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = false;

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

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean intersect(Point o, double r) {
            double dx = x - o.x, dy = y - o.y;
            return dx*dx + dy *dy < 4*r*r;
        }
    }

    private boolean check(List<Point> nails, double r) {
        int n = nails.size();
        UnionSet us = new UnionSet(n + 2);
        Point top = new Point(0, 100);
        Point bot = new Point(0, -100);
        for (int i = 0; i < n; ++i) {
            Point u = nails.get(i);
            for (int j = i + 1; j < n; ++j) {
                Point v = nails.get(j);
                if (u.intersect(v, r)) {
                    us.union(i, j);
                }
            }
            top.x = u.x; bot.x = u.x;
            if (u.intersect(top, r)) {
                us.union(i, n);
            }

            if (u.intersect(bot, r)) {
                us.union(i, n + 1);
            }
        }
        return us.find(n) != us.find(n+1);
    }

    private void solve() {
        int N = sc.nextInt();
        List<Point> nails = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            nails.add(new Point(sc.nextInt(), sc.nextInt()));
        }

        double l = 0, r = 200;
        while (r - l >= 1e-5) {
            double mid = (l + r) * 0.5;
            if (check(nails, mid)) {
                l = mid;
            } else {
                r = mid;
            }
        }

        out.println((l + r) * 0.5);
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

        int[] nextIntArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        int[][] nextIntArray(int n, int m) {
            int[][] a = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            return a;
        }

        long[] nextLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextLong();
            }
            return a;
        }

        long[][] nextLongArray(int n, int m) {
            long[][] a = new long[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = nextLong();
                }
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

        List<Long> nextLongList(int n) {
            List<Long> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(nextLong());
            }
            return list;
        }

        char[] nextCharArray(int n) {
            return sc.next().toCharArray();
        }

        char[][] nextCharArray(int n, int m) {
            char[][] c = new char[n][m];
            for (int i = 0; i < n; i++) {
                String s = sc.next();
                for (int j = 0; j < m; j++) {
                    c[i][j] = s.charAt(j);
                }
            }
            return c;
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

        void printArray(long[] a) {
            for (int i = 0; i < a.length; ++i) {
                print(a[i]);
                print(i == a.length - 1 ? '\n' : ' ');
            }
        }

        void println(int[] a) {
            for (int v : a) {
                println(v);
            }
        }

        void print(List<Integer> list) {
            for (int i = 0; i < list.size(); ++i) {
                print(list.get(i));
                print(i == list.size() - 1 ? '\n' : ' ');
            }
        }

        void println(List<Integer> list) {
            list.forEach(this::println);
        }
    }

    private <T> List<List<T>> createGraph(int n) {
        List<List<T>> g = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            g.add(new ArrayList<>());
        }
        return g;
    }

    private void fill(int[][] a, int value) {
        for (int[] row : a) {
            fill(row, value);
        }
    }

    private void fill(int[] a, int value) {
        Arrays.fill(a, value);
    }

    public static void main(String[] args) {
        out = new MyWriter(new BufferedOutputStream(System.out));
        sc = new MyScanner();
        new Main().run();
        out.close();
    }
}