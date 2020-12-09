package codeforces._637.D;

import java.util.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static final String[] DIGIT = {"1110111", "0010010", "1011101", "1011011", "0111010", "1101011", "1101111", "1010010", "1111111", "1111011"};

    private String[] s;
    private int[][] memo;

    private boolean dp(int n, int k, StringBuilder ans) {
        if (n == 0) {
            return k == 0;
        }

        if (memo[n][k] != 0) {
            return memo[n][k] == 1;
        }

        String t = s[s.length - n];
        for (int l = 9; l >= 0; --l) {
            int need = 0;
            String cur = DIGIT[l];
            for (int i = 0; i < cur.length(); ++i) {
                char c1 = cur.charAt(i);
                char c2 = t.charAt(i);

                if (c2 == '1') {
                    if (c1 == '0') {
                        need = -1;
                        break;
                    }
                } else {
                    if (c1 == '1') {
                        ++need;
                    }
                }
            }

            if (need == -1 || k < need) {
                continue;
            }

            if (dp(n - 1, k - need, ans)) {
                ans.append(l);
                memo[n][k] = 1;
                return true;
            }
        }
        memo[n][k] = 2;
        return false;
    }

    private void solve() {
        int n = sc.nextInt();
        int k = sc.nextInt();

        s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }

        memo = new int[n + 1][k + 1];
        StringBuilder ans = new StringBuilder();
        if (dp(n, k, ans)) {
            ans.reverse();
            System.out.println(ans.toString());
        } else {
            System.out.println("-1");
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}
