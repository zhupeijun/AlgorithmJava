package atcoder.ABC._174.F;
import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = false;

    private static class BIT {
        int n;
        int[] bit;

        BIT(int n) {
            this.n = n;
            bit = new int[n + 1];
        }

        int sum(int i) {
            int s = 0;
            while (i > 0) {
                s += bit[i];
                i -= i & -i;
            }
            return s;
        }

        void add(int i, int x) {
            while (i <= n) {
                bit[i] += x;
                i += i & -i;
            }
        }
    }

    private static class Query implements Comparable<Query> {
        int i;
        int l, r;

        Query(int i, int l, int r) {
            this.i = i;
            this.l = l;
            this.r = r;
        }

        @Override
        public int compareTo(Query query) {
            return query.r - r;
        }
    }

    private void solve() {
        int N = sc.nextInt();
        int Q = sc.nextInt();

        int[]c = new int[N + 1];
        for (int i = 1; i <= N; ++i) {
            c[i] = sc.nextInt();
        }

        List<Query> qs = new ArrayList<>();
        for (int i = 0; i < Q; i++) {
            qs.add(new Query(i, sc.nextInt(), sc.nextInt() ));
        }

        Collections.sort(qs);

        Map<Integer, LinkedList<Integer>> mp = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            LinkedList<Integer> list = mp.computeIfAbsent(c[i], k -> new LinkedList<>());
            list.addFirst(i);
        }

        BIT bit = new BIT(N);
        for (LinkedList<Integer> list : mp.values()) {
            bit.add(list.get(0), 1);
        }

        int[] ans = new int[Q];
        for (int i = 0, cur = N; i < Q; ++i) {
            Query q = qs.get(i);

            while (cur > q.r) {
                LinkedList<Integer> list = mp.get(c[cur]);
                if (!list.isEmpty()) {
                    list.pollFirst();
                    if (!list.isEmpty()) {
                        bit.add(list.getFirst(), 1);
                    }
                }
                --cur;
            }

            ans[q.i] = bit.sum(q.r) - bit.sum(q.l - 1);
        }

        for (int v : ans) {
            out.println(v);
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