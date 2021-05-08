package atcoder.ABC.zone2021;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private void solve() {
        String S = sc.next();
        Deque<Character> q = new ArrayDeque<>();
        int dir = 0;
        for (char c : S.toCharArray()) {
            if (c == 'R') {
                dir ^= 1;
            } else {
                if (dir == 0) {
                    q.addLast(c);
                } else {
                    q.addFirst(c);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            char c;
            if (dir == 0) {
                c = q.pollFirst();
            }  else {
                c = q.pollLast();
            }

            int sz = sb.length();
            if (sz != 0 && sb.charAt(sz-1) == c) {
                sb.setLength(sz-1);
            } else {
                sb.append(c);
            }
        }
        out.println(sb.toString());
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
