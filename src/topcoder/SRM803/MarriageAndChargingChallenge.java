// BEGIN CUT HERE
package topcoder.SRM803;
// END CUT HERE

import java.util.*;

public class MarriageAndChargingChallenge {
    public int solve(int m, int[] r, int[] g) {
        int n = r.length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            long bat = 0;
            boolean ok = true;
            for (int j = 0; j < n; ++j) {
                int k = (i+j) % n;
                bat += g[k];
                int cur = r[k];
                int nxt = r[(k+1)%n];
                if (nxt > cur) {
                    bat -= (nxt - cur);
                } else {
                    bat -= (long)m-cur+nxt;
                }
                if (bat < 0) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                ++ans;
            }
        }
        return ans;
    }
}
