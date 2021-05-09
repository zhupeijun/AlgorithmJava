// BEGIN CUT HERE
package topcoder.SRM803;
// END CUT HERE

import java.util.*;

public class MarriageAndCirclingChallenge {
    private static final int MOD = 1 << 31;

    public long solve(int N, int t, int _s) {

        long s = _s;
        boolean[][] g = new boolean[N][N];
        for (int i = 0; i < N; ++i) {
            for (int j = i+1; j < N; ++j) {
                s = (s * 1103515245 + 12345) % MOD;
                long v = s % 100;
                if (v < t) {
                    g[i][j] = true;
                } else {
                    g[j][i] = true;
                }
            }
        }

        long ans = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = i+1; j < N; ++j) {
                int c1 = 0, c2 = 0;
                for (int k = 0; k < N; ++k) {
                    if (i == k || j == k) continue;
                    if (g[i][k]&&g[k][j]) ++c1;
                    if (g[j][k]&&g[k][i]) ++c2;
                }
                ans += (long)c1 * c2;
            }
        }
        return ans / 2;
    }
}
