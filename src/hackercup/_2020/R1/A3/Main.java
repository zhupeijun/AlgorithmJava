package hackercup._2020.R1.A3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    private static final boolean N_CASE = true;
    private static final long MOD = 1_000_000_007;

    private static class Node implements Comparable<Node> {
        long l;
        long r;

        public Node(long l, long r) {
            this.l = l;
            this.r = r;
        }

        @Override
        public int compareTo(Node node) {
            return Long.compare(l, node.l);
        }
    }

    private long cal(long h, long w) {
        return (h * 2L + w * 2L) % MOD;
    }

    private void solve() {
        int N = sc.nextInt();
        int K = sc.nextInt();

        long[] LL = new long[K];
        for (int i = 0; i < K; i++) {
            LL[i] = sc.nextLong();
        }
        long AL = sc.nextLong();
        long BL = sc.nextLong();
        long CL = sc.nextLong();
        long DL = sc.nextLong();
        long[] WW = new long[K];
        for (int i = 0; i < K; ++i) {
            WW[i] = sc.nextLong();
        }
        long AW = sc.nextLong();
        long BW = sc.nextLong();
        long CW = sc.nextLong();
        long DW = sc.nextLong();
        long[] HH = new long[K];
        for (int i = 0; i < K; i++) {
            HH[i] = sc.nextLong();
        }
        long AH = sc.nextLong();
        long BH = sc.nextLong();
        long CH = sc.nextLong();
        long DH = sc.nextLong();

        long[] L = new long[N];
        long[] W = new long[N];
        long[] H = new long[N];

        for (int i = 0; i < N; i++) {
            if (i < K) {
                L[i] = LL[i];
                W[i] = WW[i];
                H[i] = HH[i];
            } else {
                L[i] = ((AL * L[i - 2] + BL * L[i - 1] + CL) % DL) + 1;
                W[i] = ((AW * W[i - 2] + BW * W[i - 1] + CW) % DW) + 1;
                H[i] = ((AH * H[i - 2] + BH * H[i - 1] + CH) % DH) + 1;
            }
        }

        long ans = 1;
        long P = 0;
        TreeSet<Node> s = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                P = cal(H[0], W[0]);
                s.add(new Node(L[0], L[0] + W[0]));
            } else {
                List<Node> l = new ArrayList<>();
                long cur = L[i] + W[i] + 1;
                while (true) {
                    Node t = s.lower(new Node(cur, 0));
                    if (t == null || t.r < L[i]) {
                        break;
                    } else {
                        l.add(t);
                        s.remove(t);
                        cur = t.l;
                    }
                }

                if (l.isEmpty()) {
                    P = (P + cal(H[i], W[i])) % MOD;
                    s.add(new Node(L[i], L[i] + W[i]));
                } else {
                    long min = L[i];
                    long max = L[i] + W[i];

                    long len = W[i];
                    for (Node node : l) {
                        min = Math.min(min, node.l);
                        max = Math.max(max, node.r);

                        long nl = Math.max(node.l, L[i]);
                        long nr = Math.min(node.r, L[i] + W[i]);

                        len -= nr - nl;
                    }

                    s.add(new Node(min, max));
                    long sub = (l.size() - 1) * H[i] * 2L;
                    P = (((P + len * 2L - sub) % MOD) + MOD) % MOD;
                }
            }
            ans = (ans * P) % MOD;
        }
        out.println(ans);
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
            //out = new MyWriter(new FileOutputStream("output.txt"));
            out = new MyWriter(System.out);
            sc = new MyScanner();
            new Main().run();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}