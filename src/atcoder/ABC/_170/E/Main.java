package atcoder.ABC._170.E;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = false;
    private static final int M = 200005;

    private static class MultiSet {
        private TreeMap<Integer, Integer> set;

        public MultiSet() {
            set = new TreeMap<>();
        }

        public Integer last() {
            return set.lastKey();
        }

        public Integer first() {
            return set.firstKey();
        }

        public void add(Integer v) {
            set.put(v, set.getOrDefault(v, 0) + 1);
        }

        public void remove(Integer v) {
            if (set.containsKey(v)) {
                int count = set.get(v);
                if (count > 0) {
                    set.put(v, count - 1);
                }
                if (set.get(v) == 0) {
                    set.remove(v);
                }
            }
        }

        public boolean isEmpty() {
            return set.isEmpty();
        }
    }

    private void solve() {
        int n = sc.nextInt();
        int q = sc.nextInt();

        PriorityQueue<Integer> x = new PriorityQueue<>();
        x.remove(1);

        int[] a = new int[n + 1];
        int[] b = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        List<MultiSet> k = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            k.add(new MultiSet());
        }

        for (int i = 1; i <= n; ++i) {
            k.get(b[i]).add(a[i]);
        }

        MultiSet m = new MultiSet();
        for (int i = 0; i < M; ++i) {
            if (!k.get(i).isEmpty()) {
                m.add(k.get(i).last());
            }
        }

        for (int i = 0; i < q; ++i) {
            int c = sc.nextInt();
            int d = sc.nextInt();

            m.remove(k.get(b[c]).last());
            if (!k.get(d).isEmpty()) {
                m.remove(k.get(d).last());
            }

            k.get(b[c]).remove(a[c]);
            k.get(d).add(a[c]);

            if (!k.get(b[c]).isEmpty()) {
                m.add(k.get(b[c]).last());
            }
            m.add(k.get(d).last());
            b[c] = d;
            out.println(m.first());
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

    public static void main(String[] args) {
        out = new MyWriter(new BufferedOutputStream(System.out));
        sc = new MyScanner();
        new Main().run();
        out.close();
    }
}