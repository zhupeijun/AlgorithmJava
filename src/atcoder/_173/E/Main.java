package atcoder._173.E;
import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = false;
    private static final int MOD = 1000_000_007;

    private long calc(List<Integer> A, int K, int o, int r) {
        long ans = 1;
        for (int i = 0; i < K; ++i) {
            if (i == o) {
                ans = (ans * A.get(r)) % MOD;
            } else {
                ans = (ans * A.get(i)) % MOD;
            }
        }
        return ans;
    }

    private void solve() {
        int N = sc.nextInt();
        int K = sc.nextInt();
        List<Integer> A = sc.nextList(N);
        A.sort((v1, v2) -> (Math.abs(v2) - Math.abs(v1)));

        long ans = 1;
        for (int i = 0; i < K; ++i) {
            ans = (ans * A.get(i)) % MOD;
        }

        if (ans >= 0) {
            out.println(ans);
            return;
        }

        Integer x1 = null, x2 = null, y1 = null, y2 = null;
        for (int i = 0; i < K; ++i) {
            if (A.get(i) < 0) {
                x1 = i;
            } else {
                x2 = i;
            }
        }

        for (int i = N - 1; i >= K; --i) {
            if (A.get(i) < 0) {
                y1 = i;
            } else {
                y2 = i;
            }
        }

        if (x2 == null) {
            if (y2 != null) {
                ans = calc(A, K, x1, y2);
            }
        } else {
            if (y1 != null && y2 != null) {
                if ((long)A.get(x1) * A.get(y1) < (long)A.get(x2) * A.get(y2)) {
                    ans = calc(A, K, x1, y2);
                } else {
                    ans = calc(A, K, x2, y1);
                }
            } else if (y2 != null) {
                ans = calc(A, K, x1, y2);
            } else if (y1 != null){
                ans = calc(A, K, x2, y1);
            }
        }

        if (ans < 0) {
            ans = 1;
            for (int i = 0; i < K; ++i) {
                ans = (ans * A.get(A.size() - 1 - i)) % MOD;
            }
        }

        out.println((ans + MOD) % MOD);
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
