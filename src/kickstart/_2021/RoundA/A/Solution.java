package kickstart._2021.RoundA.A;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Solution {
    private static final boolean N_CASE = true;

    private void solve() {
        int N = sc.nextInt();
        int K = sc.nextInt();

        String s = sc.next();

        int l = 0, r = N-1;
        int cnt = 0;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                ++cnt;
            }
            ++l; --r;
        }

        out.println(Math.abs(K - cnt));
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