package hackercup._2020.D2;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = true;
    private List<List<Integer>> g;
    private int N;
    private int M;
    private int[] dfn;
    private int tot;
    private int[] dep;
    private int[] pos;

    private static class Node implements Comparable<Node> {
        int i;
        long c;
        int d;

        public Node(int i, long c, int d) {
            this.i = i;
            this.c = c;
            this.d = d;
        }

        @Override
        public int compareTo(Node node) {
            return Long.compare(c, node.c);
        }
    }

    private static class RMQ {
        int n;
        int[] dat;

        RMQ(int n_) {
            n = 1;
            while (n < n_) n <<= 1;
            dat = new int[2 * n];
            for (int i = 0; i < 2 * n - 1; ++i) {
                dat[i] = Integer.MAX_VALUE;
            }
        }

        void update(int k, int a) {
            k += n - 1;
            dat[k] = a;

            while (k > 0) {
                k = (k - 1) / 2;
                dat[k] = Math.min(dat[k * 2 + 1], dat[k * 2 + 2]);
            }
        }

        int query(int a, int b) {
            if (a > b) {
                return query(b, a, 0, 0, n);
            } else {
                return query(a, b, 0, 0, n);
            }
        }

        int query(int a, int b, int k, int l, int r) {
            if (r <= a || b <= l) return Integer.MAX_VALUE;
            if (a <= l && r <= b) return dat[k];
            else {
                int vl = query(a, b, k * 2 + 1, l, (l + r) / 2);
                int vr = query(a, b, k * 2 + 2, (l + r) / 2, r);
                return Math.min(vl, vr);
            }
        }
    }

    private void dfs(int u, int fa, int d) {
        pos[u] = tot;
        dfn[tot++] = u;
        dep[u] = d;
        for (int v : g.get(u)) {
            if (v != fa) {
                dfs(v, u, d + 1);
                dfn[tot++] = u;
            }
        }
    }

    private void solve() {
        N = sc.nextInt();
        M = sc.nextInt();
        int A = sc.nextInt() - 1;
        int B = sc.nextInt() - 1;

        int[] P = new int[N];
        int[] C = new int[N];

        for (int i = 0; i < N; i++) {
            P[i] = sc.nextInt() - 1;
            C[i] = sc.nextInt();
        }

        g = createGraph(N);
        for (int i = 0; i < N; i++) {
            if (P[i] != -1) {
                g.get(i).add(P[i]);
                g.get(P[i]).add(i);
            }
        }

        dfn = new int[N * 2 - 1];
        pos = new int[N];
        dep = new int[N];
        tot = 0;
        dfs(0, -1, 0);

        RMQ rmq = new RMQ(N * 2 - 1);
        for (int i = 0; i < tot; i++) {
            rmq.update(i, pos[dfn[i]]);
        }

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(A, 0, 0));

        long[] ans = new long[N];
        Arrays.fill(ans, -1);
        ans[A] = 0;
        Queue<Integer> l = new ArrayDeque<>();
        l.add(A);
        while (!q.isEmpty()) {
            Node node = q.poll();
            int cd = node.d;

            System.out.println(Arrays.toString(ans));
        }

        out.println(ans[B]);
    }

    private void run() {
        int T = N_CASE ? sc.nextInt() : 1;
        for (int t = 0; t < T; ++t) {
            out.print(String.format("Case #%d: ", t + 1));
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

    private <T> List<List<T>> createGraph(int n) {
        List<List<T>> g = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            g.add(new ArrayList<>());
        }
        return g;
    }

    public static void main(String[] args) {
        try {
            out = new MyWriter(new FileOutputStream("output.txt"));
            sc = new MyScanner();
            new Main().run();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}