package hdu._1402;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = true;

    public void add(double[] a, double[] b, double[] c) {
        double x = a[0] + b[0];
        double y = a[1] + b[1];
        c[0] = x; c[1] = y;
    }

    public void sub(double[] a, double[] b, double[] c) {
        double x = a[0] - b[0];
        double y = a[1] - b[1];
        c[0] = x; c[1] = y;
    }

    public void mul(double[] a, double[] b, double[] c) {
        double x = a[0] * b[0] - a[1] * b[1];
        double y = a[0] * b[1] + a[1] * b[0];
        c[0] = x; c[1] = y;
    }

    public void set(double[] a, double[] b) {
        a[0] = b[0]; a[1] = b[1];
    }

    private void dft(double[][] f, double[][] tmp, int l, int r, int inv, double[] cur, double[] step) {
        int n = r - l;
        if (n == 1) return;

        int m = (l + r) / 2;
        for (int i = l; i < r; ++i)  set(tmp[i], f[i]);
        for (int i = l, j1 = l, j2 = m; i < r; ++i) {
            if (i % 2 == 0) {
                set(f[j1++], tmp[i]);
            } else {
                set(f[j2++], tmp[i]);
            }
        }

        dft(f, tmp, l, m, inv, cur, step);
        dft(f, tmp, m, r, inv, cur, step);

        cur[0] = 1; cur[1] = 0;
        step[0] = Math.cos(Math.PI * 2 / n); step[1] = Math.sin(Math.PI * 2 * inv / n);
        for (int i1 = l, i2 = m; i1 < m; ++i1, ++i2) {
            double[] a = tmp[i1]; set(a, cur); mul(a, f[i2], a); add(f[i1], a, a);
            double[] b = tmp[i2]; set(b, cur); mul(b, f[i2], b); sub(f[i1], b, b);
            mul(cur, step, cur);
        }

        for (int i = l; i < r; ++i) set(f[i], tmp[i]);
    }

    private int[] convolution(int[] a_, int[] b_) {
        int maxLen = Math.max(a_.length, b_.length) << 1;
        int len = 1; while (len < maxLen) len <<= 1;
        double[][] a = new double[len][2];
        double[][] b = new double[len][2];
        double[][] t = new double[len][2];

        for (int i = 0; i < a_.length; ++i) a[i][0] = a_[i];
        for (int i = 0; i < b_.length; ++i) b[i][0] = b_[i];

        dft(a, t,0, len,1, new double[2], new double[2]);
        dft(b, t,0, len,1, new double[2], new double[2]);

        double[][] c = new double[len][2];
        for (int i = 0; i < len; ++i)  mul(a[i], b[i], c[i]);

        dft(c, t, 0, len, -1, new double[2], new double[2]);

        int[] ret = new int[len];
        for (int i = 0; i < len; ++i) ret[i] = (int)(c[i][0] / len + 0.5);
        return ret;
    }

    private void solve(String sa, String sb) {
        int[] a = new int[sa.length()];
        int[] b = new int[sb.length()];
        for (int i = 0; i < sa.length(); ++i) a[i] = sa.charAt(sa.length() - 1 - i) - '0';
        for (int i = 0; i < sb.length(); ++i) b[i] = sb.charAt(sb.length() - 1 - i) - '0';


        int[] r = convolution(a, b);
        List<Integer> flat = new ArrayList<>();
        int cur = 0;
        for (int x : r) { cur += x; flat.add(cur % 10); cur /= 10; }
        if (cur > 0) flat.add(cur);
        int n = flat.size() - 1; while (n >= 0 && flat.get(n) == 0) { --n; };
        StringBuilder ans = new StringBuilder();
        while (n >= 0) ans.append(flat.get(n--));
        if (ans.length() == 0) ans.append(0);
        out.println(ans);
    }

    private void run() {
        try {
            while (true) {
                String sa = sc.br.readLine();
                if (sa != null) {
                    String sb = sc.br.readLine();
                    solve(sa, sb);
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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