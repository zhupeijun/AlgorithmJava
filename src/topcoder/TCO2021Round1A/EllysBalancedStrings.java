// BEGIN CUT HERE
package topcoder.TCO2021Round1A;
// END CUT HERE

import java.util.*;

public class EllysBalancedStrings {
    private static final String V = "AEIOU";

    public int getMin(String S) {
        int N = S.length();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            char c = S.charAt(i);
            if (V.contains(String.valueOf(c))) {
                a.add(1);
            } else {
                int min = Integer.MAX_VALUE;
                for (char t : V.toCharArray()) {
                    int move = Math.abs((int)t - (int)c);
                    min = Math.min(move, min);
                }
                b.add(min);
            }
        }

        int na = a.size(), nb = b.size();
        if (na == nb) return 0;
        else {
            int m = Math.abs(nb - na)/2;
            Collections.sort(b);
            List<Integer> t;
            if (na > nb) t = a;
            else t = b;
            int ans = 0;
            for (int i = 0; i < m; ++i) {
                ans += t.get(i);
            }
            return ans;
        }
    }
}
