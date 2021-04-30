package atcoder.ABC._192.B;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private boolean check(String s) {
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (i % 2 == 0) {
                if (!Character.isLowerCase(c)) {
                    return false;
                }
            } else {
                if (!Character.isUpperCase(c)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void solve() {
        out.println(check(sc.next()) ? "Yes" : "No");
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
