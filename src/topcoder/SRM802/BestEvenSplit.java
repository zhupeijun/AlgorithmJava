// BEGIN CUT HERE
package topcoder.SRM802;
// END CUT HERE

import java.util.*;

public class BestEvenSplit {
    private static final int T = 1 << 15;
    private static final int U = T-1;
    private static final int[] table;
    static {
        table = new int[T];
        for (int i = 0; i < T; ++i) table[i] = Integer.bitCount(i);
    }

    int[] conn;
    int min;
    int ans;

    private int get(int mask, int a) {
        int t = mask & a;
        return table[t>>15] + table[t & U];
    }

    void dfs(int last, int mask, int k, int n, int m, int val) {
        if (k == m) {
            if (val < min) { min = val; ans = 1; }
            else if (val == min) { ++ans; }
            return;
        }

        int need = m - k;
        int o = mask ^ ((1<<n)-1);
        for (int i = last+1; i < n-need+1; ++i) {
            int b = 1<<i;
            dfs(i, mask | b, k+1,n, m, val - get(mask, conn[i]) + get(o, conn[i]));
        }
    }

    public int count(int N, int[] X, int[] Y) {
        int M = X.length;
        conn = new int[N];
        for (int i = 0; i < M; ++i) {
            conn[X[i]] |= 1 << Y[i];
            conn[Y[i]] |= 1 << X[i];
        }

        ans = 0;
        min = Integer.MAX_VALUE;

        dfs(-1, 0, 0, N, N/2, 0);
        return ans / 2;
    }
}
