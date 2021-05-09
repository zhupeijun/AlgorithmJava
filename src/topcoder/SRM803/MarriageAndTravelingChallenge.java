// BEGIN CUT HERE
package topcoder.SRM803;
// END CUT HERE

import java.util.*;

public class MarriageAndTravelingChallenge {
    public String solve(String S) {
        int n = S.length();
        StringBuilder ans = new StringBuilder();
        int i = 0, len = 1;
        while (i < n) {
            ans.append(S.charAt(i));
            i += len;
            ++len;
        }
        return ans.toString();
    }
}
