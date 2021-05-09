package codejam._2021.Round1A.A;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Solution {
    private static final boolean N_CASE = true;

    private void solve() {
        int N = sc.nextInt();
        long[] X = sc.nextLongArray(N);
        String[] s = new String[N];
        for (int i = 0; i < N; ++i) {
            s[i] = String.valueOf(X[i]);
        }

        int ans = 0;
        for (int i = 1; i < N; ++i) {
            String pre = s[i-1];
            String cur = s[i];

            int pn = pre.length();
            int cn = cur.length();
            if (cn > pn) {
                continue;
            }

            StringBuilder t = new StringBuilder();
            int cmp = cur.compareTo(pre.substring(0, cn));
            if (cmp > 0) {
                t.append(cur);
                for (int j = cn; j < pn; ++j) t.append("0");
                ans += pn-cn;
            } else if (cmp < 0) {
                t.append(cur);
                for (int j = cn; j < pn; ++j) t.append("0");
                t.append("0");
                ans += pn-cn+1;
            } else {
                if (cn == pn) {
                    t.append(pre);
                    t.append("0");
                    ans += pn-cn+1;
                } else {
                    int last = -1;
                    for (int j = pn-1; j >= cn; --j) {
                        if (pre.charAt(j) != '9') {
                            last = j; break;
                        }
                    }

                    if (last == -1) {
                       // t.append(pre);
                        t.append(cur);
                        for (int j = cn; j < pn; ++j) t.append("0");
                        t.append("0");
                        ans += pn-cn+1;
                    } else {
                        t.append(cur);
                        for (int j = cn; j < last; ++j) t.append(pre.charAt(j));
                        t.append((char)(pre.charAt(last) + 1));
                        for (int j = last + 1; j < pn; ++j) t.append("0");
                        ans += pn-cn;
                    }
                }
            }
           s[i] = t.toString();
        }
//        System.out.println(Arrays.toString(s));
        out.println(ans);
    }

    private void run() {
        int T = N_CASE ? sc.nextInt() : 1;
        for (int t = 0; t < T; ++t) {
            out.print(String.format("Case #%d: ", t + 1));
            solve();
        }
    }

    private static MyWriter out;
    private static MyScanner sc;
    private static CommonUtils cu;

    public static void main(String[] args) {
        out = new MyWriter(new BufferedOutputStream(System.out));
        sc = new MyScanner();
        new Solution().run();
        out.close();
    }
}