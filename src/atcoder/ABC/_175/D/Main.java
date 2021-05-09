package atcoder.ABC._175.D;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = false;

    private static class Node {
        int i;
        long v;

        public Node(int i, long v) {
            this.i = i;
            this.v = v;
        }
    }

    private long getMax(List<Integer> l, int M, int[] C) {
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingLong(v -> v.v));

        long sum = 0;
        long ans = Long.MIN_VALUE;
        q.add(new Node(-1, 0));
        if (M == 0) {
            return ans;
        }
        for (int i = 0; i < l.size(); ++i) {
            while (!q.isEmpty() && i - q.peek().i > M) {
                q.poll();
            }

            sum += C[l.get(i)];

            long min = q.isEmpty() ? 0 : q.peek().v;
            ans = Math.max(ans, sum - min);

            q.add(new Node(i, sum));
        }
        return ans;
    }

    private void solve() {
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] P = sc.nextIntArray(N);
        int[] C = sc.nextIntArray(N);

        boolean[] vis = new boolean[N];
        long a = Long.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if (vis[i]) {
                continue;
            }

            List<Integer> l = new ArrayList<>();
            int cur = i;
            while (!vis[cur]) {
                vis[cur] = true;
                l.add(cur);
                cur = P[cur] - 1;
            }

            long total = 0;
            for (int v : l) {
                total += C[v];
            }

            int L = l.size();
            for (int j = 0; j < L; ++j) {
                l.add(l.get(j));
            }

            if (K >= L) {
                long a1 = getMax(l, K % L, C);
                long a2 = getMax(l, L, C);

                if (total > 0) {
                    a1 += total * (K / L);
                    a2 += total * ((K - L) / L);
                }
                a = Math.max(a, Math.max(a1, a2));
            } else {
                a = Math.max(a, getMax(l, K, C));
            }
        }
        out.println(a);
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
        out = new MyWriter(new BufferedOutputStream(System.out));
        sc = new MyScanner();
        new Main().run();
        out.close();
    }
}