package atcoder.ABC._201;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private void solve() {
        String s = sc.next();

        int ans = 0;
        for (int i = 0; i <= 9999; ++i) {
            char[] t = new char[10];
            Arrays.fill(t, 'x');
            int x = i;
            for (int j = 0; j < 4; ++j) {
                t[x % 10] = 'o'; x /= 10;
            }

            boolean ok = true;
            for (int j = 0; j < 10; ++j) {
                if (s.charAt(j) == '?') continue;
                if (s.charAt(j) != t[j]) {
                    ok = false;
                    break;
                }
            }

            if (ok) ++ans;
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
