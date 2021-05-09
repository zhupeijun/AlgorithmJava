package library.algorithm;

import java.util.*;

public class Matrix {
    private Mint Mt;

    public Matrix(Mint mt) {
        this.Mt = mt;
    }

    public long[] mul(long[] a, long[][] b) {
        int N = a.length;
        long[] ret = new long[N];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                ret[i] = Mt.add(ret[i], Mt.mul(a[j], b[i][j]));
            }
        }
        return ret;
    }

    public long[][] mul(long[][] a, long[][] b) {
        int A = a.length;
        int B = b.length == 0 ? 0 : b[0].length;
        int C = A == 0 ? 0 : a[0].length;

        long[][] ret = new long[A][B];
        for (int r = 0; r < A; ++r) {
            for (int c = 0; c < B; ++c) {
                for (int i = 0; i < C; ++i) {
                    ret[r][c] = Mt.add(ret[r][c], Mt.mul(a[r][i], b[i][c]));
                }
            }
        }
        return ret;
    }

    public long[][] pow(long[][] a, int n) {
        int N = a.length;
        long[][] ret = new long[N][N];
        unit(ret);

        while (n > 0) {
            if ((n&1) > 0) {
                ret = mul(ret, a);
            }
            a = mul(a, a);
            n >>= 1;
        }
        return ret;
    }

    public void copy(long[][] a, long[][] b) {
        int N = a.length;
        int M = N == 0 ? 0 : a[0].length;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                b[i][j] = a[i][j];
            }
        }
    }

    public void unit(long[][] a) {
        int N = a.length;
        for (int i = 0; i < N; ++i) {
            a[i][i] = 1;
        }
    }

    public void set(long[][] a, long val) {
        int N = a.length;
        for (int i = 0; i < N; ++i) {
            Arrays.fill(a[i], val);
        }
    } 
}