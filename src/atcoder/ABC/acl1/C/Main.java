package atcoder.ABC.acl1.C;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = false;
    private static final int INF = 1000000;

    private int tot;
    private int N, M;

    private static class Edge {
        int to, cap, cost, rev;

        public Edge(int to, int cap, int cost, int rev) {
            this.to = to;
            this.cap = cap;
            this.cost = cost;
            this.rev = rev;
        }
    }

    private static class QNode {
        long d; int v;

        public QNode(long d, int v) {
            this.d = d;
            this.v = v;
        }
    }

    List<List<Edge>> g;
    boolean[] used;
    long[] h, dist;
    int[] pv, pe;

    private int id(int i, int j) { return i * M + j; }
    private int id(int[] a) { return id(a[0], a[1]); }
    private boolean isValid(int i, int j) { return i >= 0 && i < N && j >= 0 && j < M; }

    private void addEdge(int u, int v, int cap, int cost) {
        g.get(u).add(new Edge(v, cap, cost, g.get(v).size()));
        g.get(v).add(new Edge(u, 0, -cost,g.get(u).size() - 1));
    }

    int maxCostFlow(int s, int t, int f) {
        int res = 0;
        Arrays.fill(h, 0);
        while (f > 0) {
            PriorityQueue<QNode> q = new PriorityQueue<>((v1,v2) -> Long.compare(v2.d, v1.d));
            Arrays.fill(dist, -INF);
            dist[s] = 0;
            boolean update = true;
            while (update) {
                update = false;
                for (int v = 0; v < tot; ++v) {
                    if (dist[v] == -INF) continue;
                    for (int i = 0; i < g.get(v).size(); ++i) {
                        Edge e = g.get(v).get(i);
                        if (e.cap > 0 && dist[e.to] < dist[v] + e.cost) {
                            dist[e.to] = dist[v] + e.cost;
                            pv[e.to] = v;
                            pe[e.to] = i;
                            update = true;
                        }
                    }
                }
            }

            if (dist[t] == -INF) {
                return -1;
            }

            int d = f;
            for (int v = t; v != s; v = pv[v]) {
                d = Math.min(d, g.get(pv[v]).get(pe[v]).cap);
            }

            f -= d;
            res += d * dist[t];
            for (int v = t; v != s; v = pv[v]) {
                Edge e = g.get(pv[v]).get(pe[v]);
                e.cap -= d;
                g.get(v).get(e.rev).cap += d;
            }
        }
        return res;
    }

    private void solve() {
        N = sc.nextInt();
        M = sc.nextInt();
        String[] S = new String[N];
        for (int i = 0; i < N; i++) { S[i] = sc.next(); }

        tot = N*M*2 + 2;
        g = createGraph(tot);
        used = new boolean[tot];
        h = new long[tot]; dist = new long[tot]; pv = new int[tot]; pe = new int[tot];

        final int s = N*M*2, t = N*M*2+1;
        int P = 0;
        boolean[][] vis = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (S[i].charAt(j) == 'o') {
                    for (int k = 0; k < N; ++k) Arrays.fill(vis[k], false);
                    int u = id(i, j) + N*M;
                    ++P;
                    addEdge(s, u, 1, 0);
                    Queue<int[]> q = new ArrayDeque<>();
                    q.add(new int[]{i, j, 0}); vis[i][j] = true;
                    while (!q.isEmpty()) {
                        int[] a = q.poll();
                        int d = a[2], ni = a[0], nj = a[1], v = id(a);
                        addEdge(u, v, 1, d);

                        if (isValid(ni + 1, nj) && S[ni + 1].charAt(nj) != '#' && !vis[ni + 1][nj]) {
                            q.add(new int[] {ni + 1, nj, d + 1});
                            vis[ni + 1][nj] = true;
                        }

                        if (isValid(ni, nj + 1) && S[ni].charAt(nj + 1) != '#' && !vis[ni][nj + 1]) {
                            q.add(new int[] {ni, nj + 1, d + 1 });
                            vis[ni][nj + 1] = true;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                addEdge(id(i, j), t, 1, 0);
            }
        }

        out.println(maxCostFlow(s, t, P));
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