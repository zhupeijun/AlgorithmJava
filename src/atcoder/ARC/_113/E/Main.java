package atcoder.ARC._113.E;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = true;

    private String sol2(String s) {
        long aCnt = s.chars().filter(c -> c == 'a').count();
        if (aCnt % 2 == 0) {
            return s.replace("a", "");
        } else {
            int aIdx = s.lastIndexOf('a');
            StringBuilder sb = new StringBuilder();
            sb.append(s.substring(0, aIdx).replace("a", ""));
            sb.append(s.substring(aIdx));
            return sb.toString();
        }
    }

    private String sol1(String s) {
        int n = s.length();
        int last = s.lastIndexOf('b');
        if (last == -1) {
            return s;
        }
        int lastCnt = n - last - 1;

        int single = 0;
        for (int i = 0; i < last; ++i) {
            if (s.charAt(i) == 'a') {
                int j = i;
                while (j < last && s.charAt(j) == 'a') {
                    ++j;
                }
                int cnt = j - i;
                if (cnt > 1) {
                    lastCnt += cnt - 2;
                } else {
                    ++single;
                }
                i = j - 1;
            }
        }

        if (single % 2 == 1) {
            --lastCnt;
        }

        int bCnt = 0;
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == 'b') {
                ++bCnt;
            }
        }

        StringBuilder ans = new StringBuilder();
        ans.append("b".repeat(Math.max(0, bCnt)));
        ans.append("a".repeat(Math.max(0, lastCnt)));
        return ans.toString();
    }

    private void solve() {
        String s = sc.next();

        if (s.endsWith("b")) {
            String ans = sol2(s);
            if (s.contains("ba")) {
                int n = s.length();
                int maxCnt = 0;
                int maxStart = -1, maxEnd = -1;
                for (int i = 1; i < n; ++i) {
                    if (s.charAt(i) == 'a' && s.charAt(i-1) == 'b') {
                        int j = i;
                        while (j < n && s.charAt(j) == 'a') {
                            ++j;
                        }
                        int cnt = j - i;
                        if (cnt > maxCnt) {
                            maxCnt = cnt;
                            maxStart = i;
                            maxEnd = j;
                        }
                        i = j - 1;
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append(s.substring(0, maxStart - 1));
                sb.append(new StringBuilder(s.substring(maxStart, s.length() - 1)).reverse().toString());
                String ans2 = sol1(sb.toString());
                if (ans2.compareTo(ans) > 0) {
                    ans = ans2;
                }
                out.println(ans);
            } else {
                out.println(ans);
            }
        } else {
            out.println(sol1(s));
        }
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
