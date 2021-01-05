package atcoder.ABC._171.F;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = false;


    private static class ModInt {
        private static final int MOD = 1000000007;

        private long pow(long a, int n) {
            long ret = 1;
            long base = a;
            while (n > 0) {
                if ((n & 1) > 0) {
                    ret = (ret * base) % MOD;
                }
                n >>= 1;
                base = (base * base) % MOD;
            }
            return ret;
        }

        private long inv(long a) {
            return pow(a, MOD - 2);
        }

        long value;

        ModInt(long value) {
            this.value = value;
        }

        public ModInt mul(ModInt o) {
            return new ModInt((value * o.value) % MOD);
        }

        public ModInt add(ModInt o) {
            return new ModInt((value + o.value) % MOD);
        }

        public ModInt div(ModInt o) {
            return new ModInt((value * inv(o.value)) % MOD);
        }

        public ModInt sub(ModInt o) {
            return new ModInt((value - o.value + MOD) % MOD);
        }

        public ModInt pow(int n) {
            return new ModInt(pow(value, n));
        }
    }

    private void solve() {
        int k = sc.nextInt();
        String s = sc.next();
        int n = s.length();
        int m = n + k;

        ModInt[] a = new ModInt[m + 1];
        a[0] = a[1] = new ModInt(1);
        for (int i = 2; i <= m; ++i) {
            a[i] = new ModInt(i).mul(a[i - 1]);
        }

        ModInt ans = new ModInt(0);
        ModInt x = new ModInt(25);
        ModInt y = new ModInt(26);
        for (int i = n; i <= m; ++i) {
            ModInt v = new ModInt(1).mul(a[i - 1]).div(a[n - 1]).div(a[i - n]).mul(y.pow(m - i)).mul(x.pow(i - n));
            ans = ans.add(v);
        }

        out.println(ans.value);
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