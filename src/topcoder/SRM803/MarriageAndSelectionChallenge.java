// BEGIN CUT HERE
package topcoder.SRM803;
// END CUT HERE

import java.util.*;

public class MarriageAndSelectionChallenge {
    private static final int A = 12;
    private static final int M = 1<<A;

    public String solve(String S) {
        int N = S.length();
        int[][] nxt = new int[N+1][A]; Arrays.fill(nxt[N], -1);
        for (int i = N-1; i >= 0; --i) {
            System.arraycopy(nxt[i+1], 0, nxt[i], 0, A);
            nxt[i][S.charAt(i) - 'a'] = i;
        }

        int[][] dp = new int[N+1][M];
        for (int i = N-1; i>= 0; --i) {
            int c = S.charAt(i) - 'a';
            for (int mask = 0; mask < M; ++mask) {
                if ((mask & 1<<c) == 0) continue;
                for (int last = 0; last < A; ++last) {
                    int pLast = nxt[i+1][last];
                    if (pLast == -1) {
                        if (mask == 1<<c) {
                            dp[i][mask] = Math.max(dp[i][mask], 1);
                        }
                    } else {
                        if (last == c) {
                            dp[i][mask] = Math.max(dp[i][mask], dp[pLast][mask] + 1);
                        } else {
                            dp[i][mask] = Math.max(dp[i][mask], dp[pLast][mask ^ 1<<c] + 1);
                        }
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < N; ++i) {
            for (int mask = 0; mask < M; ++mask) {
                max = Math.max(max, dp[i][mask]);
            }
        }

        StringBuilder ans = new StringBuilder();
        int cur = 0, len = max, present = 0, last = -1;
        while (ans.length() < max) {
            for (int c = 0; c < A; ++c) {
                int pos = nxt[cur][c];
                if (pos == -1) continue;
                boolean exist = false;
                for (int mask = 0; mask < M; ++mask) {
                    if ((present & mask) > 0) continue;
                    if (c == last) {
                        if (dp[pos][mask | 1<<c] == len) {
                            exist = true;
                            break;
                        }
                    } else {
                        if (dp[pos][mask] == len) {
                            exist = true;
                            break;
                        }
                    }
                }
                if (exist) {
                    ans.append((char)(c+'a'));
                    present |= 1 <<c;
                    cur = pos+1;
                    len -= 1;
                    last = c;
                    break;
                }
            }
        }
        return ans.toString();
    }
}
