package atcoder.ABC._183.F;

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

    private void solve() {
        int N = sc.nextInt();
        int Q = sc.nextInt();
        int[] C = sc.nextIntArray(N);

        List<Map<Integer, Integer>> cz = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            HashMap<Integer, Integer> cnt = new HashMap<>();
            cnt.put(C[i] - 1, 1);
            cz.add(cnt);
        }

        UnionSet us = new UnionSet(N);
        for (int i = 0; i < Q; i++) {
            int cmd = sc.nextInt();
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            if (cmd == 1) {
                int pa = us.find(a);
                int pb = us.find(b);
                if (pa != pb) {
                    us.union(pa, pb);
                    int from = pa, to = pb;
                    if (cz.get(pa).size() > cz.get(pb).size()) {
                        from = pb; to = pa;
                    }

                    Map<Integer, Integer> toMap = cz.get(to);
                    for (Map.Entry<Integer, Integer> e : cz.get(from).entrySet()) {
                        toMap.put(e.getKey(), toMap.getOrDefault(e.getKey(), 0) + e.getValue());
                    }
                    cz.set(us.find(pa), toMap);
                }
            } else {
                out.println(cz.get(us.find(a)).getOrDefault(b, 0));
            }
        }
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