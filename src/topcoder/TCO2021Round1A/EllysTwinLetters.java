// BEGIN CUT HERE
package topcoder.TCO2021Round1A;
// END CUT HERE

import java.util.*;

public class EllysTwinLetters {

    private static final int MAX = 20000;
    public int getMin(String S) {
        int N = S.length();

        int[][][] dp = new int[N][26][2];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < 26; ++j) {
                Arrays.fill(dp[i][j], MAX);
            }
        }

        for (int i = 0; i < 26; ++i) {
            int c = S.charAt(0) - 'A';
            dp[0][i][0] = Math.abs(c - i);
        }

        for (int i = 1; i < N; ++i) {
            int x = S.charAt(i) - 'A';
            for (int y = 0; y < 26; ++y) {
                int move = Math.abs(y - x);
                for (int p = 0; p < 26; ++p) {
                    if (p == y) {
                        dp[i][y][1] = Math.min(dp[i][y][1], dp[i-1][p][0] + move);
                        dp[i][y][1] = Math.min(dp[i][y][1], dp[i-1][p][1] + move);
                    } else {
                        dp[i][y][0] = Math.min(dp[i][y][0], dp[i-1][p][1] + move);
                    }
                }
            }
        }

        int ans = MAX;
        for (int x = 0; x < 26; ++x) {
            ans = Math.min(ans, dp[N-1][x][1]);
        }
        return ans;
    }
}
