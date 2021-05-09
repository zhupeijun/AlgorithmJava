package codejam._2021.QR.D;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Solution {
    private static final boolean N_CASE = true;
    private int N;
    private int Q;

    private int ask(int a, int b, int c) {
        out.println(a + " " + b + " " + c);
        out.flush();
        return sc.nextInt();
    }

    private void answer(List<Integer> ans) {
        for (int i = 1; i <= N; ++i) {
            out.print(ans.get(i));
            out.print(i == N ? "\n" : " ");
        }
        out.flush();
        if (sc.nextInt() != 1) {
            System.exit(0);
        }
    }

    private int insert(List<Integer> ans, int x, int i, int j) {
        int len = j - i + 1;
        if (len == 2) {
            return i + 1;
        }

        int yi, zi;
        int seg = len / 3;
        if (len == 3) {
            if (ans.get(i) == -1) {
                yi = i+1;
                zi = i+2;
            } else {
                yi = i;
                zi = i+1;
            }
        } else {
            yi = i + seg;
            zi = i + seg*2;
        }
        int y = ans.get(yi), z = ans.get(zi);
        int ret = ask(x, y, z);
        if (ret == x) {
            return insert(ans, x, yi, zi);
        } else if (ret == y) {
            return insert(ans, x, i, yi);
        } else if (ret == z) {
            return insert(ans, x, zi, j);
        }
        return -1;
    }

    private void solve() {
        List<Integer> ans = new ArrayList<>();
        ans.add(-1);
        ans.add(1);
        ans.add(2);
        ans.add(N+1);

        for (int i = 3; i <= N; ++i) {
            int ret = insert(ans, i, 0, ans.size()-1);
            ans.add(ret, i);
        }

        answer(ans);
    }

    private void run() {
        int T = N_CASE ? sc.nextInt() : 1;
        N = sc.nextInt();
        Q = sc.nextInt();
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
        new Solution().run();
        out.close();
    }
}