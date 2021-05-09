package library.algorithm;

public class FFT {
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
}
