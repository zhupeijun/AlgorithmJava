package atcoder.ABC._164.F;import java.math.BigInteger;
import java.util.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final int M = 64;
    private static final int OR1 = 0;
    private static final int AND0 = 1;
    private static final int AND1 = 2;
    private static final int OR0 = 3;

    private int[] S;
    private int[] T;
    private long[][] U;
    private long[][] V;
    private int[][][] mat;
    private long[][][] ans;
    private int N;
    private int[][] rowType;
    private int[][] colType;

    private void read(int[] v, int N) {
        for (int i = 0; i < N; i++) {
            v[i] = sc.nextInt();
        }
    }

    private void read(BigInteger[] v, int N) {
        for (int i = 0; i < N; i++) {
            v[i] = new BigInteger(sc.next());
        }
    }

    private boolean bit(long[] v, int k) {
        if (k < 32) {
            return (v[1] & (1L << k)) > 0;
        } else {
            k -= 32;
            return (v[0] & (1L << k)) > 0;
        }
    }

    private boolean isAND1(int v1, long[] v2, int k) {
        return v1 == 0 && bit(v2, k);
    }

    private boolean isOR1(int v1, long[] v2, int k) {
        return v1 == 1 && bit(v2, k);
    }

    private boolean isAND0(int v1, long[] v2, int k) {
        return v1 == 0 && !bit(v2, k);
    }

    private void fail() {
        System.out.println("-1");
        System.exit(0);
    }

    private void fill(int k) {
        // AND1 row
        for (int r = 0; r < N; r++) {
            if (rowType[k][r] == AND1) {
                for (int c = 0; c < N; c++) {
                    mat[k][r][c] = 1;
                }
            }
        }

        // AND1 col
        for (int c = 0; c < N; c++) {
            if (colType[k][c] == AND1) {
                for (int r = 0; r < N; r++) {
                    mat[k][r][c] = 1;
                }
            }
        }

        int[] sumR = new int[N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                sumR[r] += mat[k][r][c];
            }
        }

        int[] sumC = new int[N];
        for (int c = 0; c < N; c++) {
            for (int r = 0; r < N; r++) {
                sumC[c] += mat[k][r][c];
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                // OR1 OR1
                if (rowType[k][r] == OR1 && colType[k][c] == OR1) {
                    mat[k][r][c] = 1;
                    ++sumR[r];
                    ++sumC[c];
                } else

                // AND0 OR1
                if (rowType[k][r] == AND0 && colType[k][c] == OR1) {
                    if (mat[k][r][c] == 0 && sumC[c] == 0 && sumR[r] < N - 1) {
                        mat[k][r][c] = 1;
                        ++sumR[r];
                        ++sumC[c];
                    }
                } else

                // OR1 AND0
                if (rowType[k][r] == OR1 && colType[k][c] == AND0) {
                    if (mat[k][r][c] == 0 && sumR[r] == 0 && sumC[c] < N - 1) {
                        mat[k][r][c] = 1;
                        ++sumR[r];
                        ++sumC[c];
                    }
                }

                if (mat[k][r][c] == 1) {
                    if (rowType[k][r] == OR0 || colType[k][c] == OR0) {
                        fail();
                    }
                }
            }
        }
    }

    private boolean check() {
        for (int r = 0; r < N; r++) {
            long[] tmp = new long[2];
            tmp[0] = ans[r][0][0];
            tmp[1] = ans[r][0][1];
            for (int c = 1; c < N; c++) {
                if (S[r] == 0) {
                    tmp[0] &= ans[r][c][0];
                    tmp[1] &= ans[r][c][1];
                } else {
                    tmp[0] |= ans[r][c][0];
                    tmp[1] |= ans[r][c][1];
                }
            }

            if (tmp[0] != U[r][0] || tmp[1] != U[r][1]) {
                return false;
            }
        }

        for (int c = 0; c < N; c++) {
            long[] tmp = new long[2];
            tmp[0] = ans[0][c][0];
            tmp[1] = ans[0][c][1];
            for (int r = 1; r < N; r++) {
                if (T[c] == 0) {
                    tmp[0] &= ans[r][c][0];
                    tmp[1] &= ans[r][c][1];
                } else {
                    tmp[0] |= ans[r][c][0];
                    tmp[1] |= ans[r][c][1];
                }
            }

            if (tmp[0] != V[c][0] || tmp[1] != V[c][1]) {
                return false;
            }
        }
        return true;
    }

    private void solve() {
        N = sc.nextInt();
        S = new int[N]; T = new int[N];
        BigInteger[] IU = new BigInteger[N];
        BigInteger[] IV = new BigInteger[N];
        read(S, N); read(T, N); read(IU, N); read(IV, N);
        mat = new int[M][N][N];

        U = new long[N][2];
        V = new long[N][2];
        for (int i = 0; i < N; ++i) {
            for (int k = M - 1; k >= 0; --k) {
                if (k >= 32) {
                    U[i][0] = (U[i][0] << 1) | (IU[i].testBit(k) ? 1 : 0);
                    V[i][0] = (V[i][0] << 1) | (IV[i].testBit(k) ? 1 : 0);
                } else {
                    U[i][1] = (U[i][1] << 1) | (IU[i].testBit(k) ? 1 : 0);
                    V[i][1] = (V[i][1] << 1) | (IV[i].testBit(k) ? 1 : 0);
                }
            }
        }

        rowType = new int[M][N];
        colType = new int[M][N];
        for (int k = 0; k < M; ++k) {
            for (int r = 0; r < N; r++) {
                if (isOR1(S[r], U[r], k)) {
                    rowType[k][r] = OR1;
                } else if (isAND0(S[r], U[r], k)) {
                    rowType[k][r] = AND0;
                } else if (isAND1(S[r], U[r], k)) {
                    rowType[k][r] = AND1;
                } else {
                    rowType[k][r] = OR0;
                }
            }

            for (int c = 0; c < N; c++) {
                if (isOR1(T[c], V[c], k)) {
                    colType[k][c] = OR1;
                } else if (isAND0(T[c], V[c], k)) {
                    colType[k][c] = AND0;
                } else if (isAND1(T[c], V[c], k)) {
                    colType[k][c] = AND1;
                } else {
                    colType[k][c] = OR0;
                }
            }
        }

        for (int k = 0; k < M; k++) {
            fill(k);
        }

        ans = new long[N][N][2];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                for (int k = M - 1; k >= 0; k--) {
                    if (k >= 32) {
                        ans[r][c][0] = (ans[r][c][0] << 1) | mat[k][r][c];
                    } else {
                        ans[r][c][1] = (ans[r][c][1] << 1) | mat[k][r][c];
                    }
                }
            }
        }

        if (check()) {
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    System.out.print(BigInteger.valueOf(ans[r][c][0]).shiftLeft(32).add(BigInteger.valueOf(ans[r][c][1])));
                    System.out.print(c == N - 1 ? "\n" : " ");
                }
            }
        } else {
            System.out.println("-1");
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}
