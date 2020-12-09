package codejam._2020.r2.B;

import java.util.Scanner;

public class Solution {

    private Scanner sc = new Scanner(System.in);

    private static int W = 1000000000;
    private static int M = W / 2;
    private static int[][] IN = {{0, 0},{-M, -M},{-M, M},{M, -M},{M, M}};

    private String check(int x, int y) {
        System.out.println(String.format("%d %d", x, y));
        System.out.flush();
        return sc.next();
    }

    private Integer findTop(int v, int left, int right, boolean ver) {
        while (left <= right) {
            int mid = (left + right) / 2;
            String ret = ver ? check(v, mid) : check(mid, v);
            if (ret.equals("CENTER")) {
                return null;
            } else if (ret.equals("HIT")) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    private Integer findBot(int v, int left, int right, boolean ver) {
        while (left <= right) {
            int mid = (left + right) / 2;
            String ret = ver ? check(v, mid) : check(mid, v);
            if (ret.equals("CENTER")) {
                return null;
            } else if (ret.equals("HIT")) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private void solve() {
        int[] cur = null;
        for (int[] p : IN) {
            String ret = check(p[0], p[1]);
            if (ret.equals("CENTER")) {
                return;
            } else if (ret.equals("HIT")) {
                cur = p;
                break;
            }
        }

        if (cur == null) {
            return;
        }

        Integer top = findTop(cur[0], cur[1], W, true);
        if (top == null) {
            return;
        }

        Integer bot = findBot(cur[0], -W, cur[1], true);
        if (bot == null) {
            return;
        }

        int mid = (top + bot) / 2;

        Integer left = findBot(mid, -W, cur[0], false);
        if (left == null) {
            return;
        }

        Integer right = findTop(mid, cur[0], W, false);
        if (right == null) {
            return;
        }

        int X = (left + right) / 2;
        int Y = mid;

        check(X, Y);
    }

    private void run() {
        int T = sc.nextInt();
        long A = sc.nextInt();
        long B = sc.nextInt();
        for (int i = 1; i <= T; ++i) {
            solve();
        }
    }
    public static void main(String[] args) {
        new Solution().run();
    }
}
