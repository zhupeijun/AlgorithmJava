package atcoder.ARC._113.C;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private void solve() {
        String s = sc.next();
        int n = s.length();
        int[] cnt = new int[26];
        long ans = 0;
        for (int i = n - 1; i > 0; --i) {
            int c = s.charAt(i) - 'a';
            if (s.charAt(i) == s.charAt(i-1)) {
                long sum = 0;
                for (int j = 0; j < 26; ++j) {
                    if (j != c) {
                        sum += cnt[j];
                    }
                }
                ans += sum;
                Arrays.fill(cnt, 0);
                cnt[c] = n - i;
            } else {
                ++cnt[c];
            }
        }
        out.println(ans);
    }

    private void run() {
        int T = N_CASE ? sc.nextInt() : 1;
        for (int t = 0; t < T; ++t) {
            solve();
        }
    }

    private static MyWriter out;
    private static MyScanner sc;
    private static CommonUtils cu;

    public static void main(String[] args) {
        out = new MyWriter(new BufferedOutputStream(System.out));
        sc = new MyScanner();
        cu = new CommonUtils();
        new Main().run();
        out.close();
    }
}
