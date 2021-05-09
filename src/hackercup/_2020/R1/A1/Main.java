package hackercup._2020.R1.A1;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = true;
    private static final long MOD = 1_000_000_007;

    private static class Node implements Comparable<Node> {
        long i;
        long h;

        public Node(long i, long h) {
            this.i = i;
            this.h = h;
        }

        @Override
        public int compareTo(Node node) {
            return Long.compare(node.h, h);
        }
    }

    private void solve() {
        int N = sc.nextInt();
        int K = sc.nextInt();
        long W = sc.nextLong();

        long[] LL = new long[K];
        for (int i = 0; i < K; i++) {
            LL[i] = sc.nextLong();
        }
        long AL = sc.nextLong();
        long BL = sc.nextLong();
        long CL = sc.nextLong();
        long DL = sc.nextLong();
        long[] HH = new long[K];
        for (int i = 0; i < K; i++) {
            HH[i] = sc.nextLong();
        }
        long AH = sc.nextLong();
        long BH = sc.nextLong();
        long CH = sc.nextLong();
        long DH = sc.nextLong();

        long[] L = new long[N];
        long[] H = new long[N];

        for (int i = 0; i < N; i++) {
            if (i < K) {
                L[i] = LL[i];
                H[i] = HH[i];
            } else {
                L[i] = ((AL * L[i - 2] + BL * L[i - 1] + CL) % DL) + 1;
                H[i] = ((AH * H[i - 2] + BH * H[i - 1] + CH) % DH) + 1;
            }
        }

        long ans = 1;
        long P = 0;
        PriorityQueue<Node> q = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            while (!q.isEmpty() && q.peek().i < L[i]) {
                q.poll();
            }

            if (i == 0) {
                P = (W * 2L + H[i] * 2L) % MOD;
            } else {
                if (L[i - 1] + W < L[i]) {
                    P = (P + (W * 2L + H[i] * 2L)) % MOD;
                } else {
                    P = (P + (L[i] - L[i - 1]) * 2L) % MOD;
                    long MAXH = q.isEmpty() ? 0 : q.peek().h;
                    if (H[i] >= MAXH) {
                        P = (P + (H[i] - MAXH) * 2L) % MOD;
                    }
                }
            }
            ans = (ans * P) % MOD;
            q.add(new Node(L[i] + W, H[i]));
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