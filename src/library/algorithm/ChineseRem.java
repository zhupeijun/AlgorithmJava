package library.algorithm;

public class ChineseRem {
    long mod(long a, long m) {
        return (a % m + m) % m;
    }

    long extGcd(long a, long b, long[] r) {
        long px = 1, x = 0, py = 0, y = 1;
        while (b != 0) {
            long q = a / b;
            long nx = px - q * x; px = x; x = nx;
            long ny = py - q * y; py = y; y = ny;
            long na = b; b = a % b; a = na;
        }
        r[0] = px; r[1] = py;
        return a;
    }

    long[] chineseRem(long[] b, long[] m) {
        long r = 0, M = 1;
        int n = b.length;
        for (int i = 0; i < n; ++i) {
            long[] x = new long[2];
            long d = extGcd(M, m[i], x);
            if ((b[i] - r) % d != 0) return new long[] { 0, -1 };
            long y = m[i] / d;
            long t = (b[i] - r) / d * x[0] % y;
            r += M * t;
            M *= y;
        }
        return new long[] { mod(r, M), M };
    }
}
