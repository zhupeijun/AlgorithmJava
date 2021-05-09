package projecteuler._67;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 100;
        int[][] t = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= i; ++j) {
                t[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[n][n];
        dp[0][0] = t[0][0];
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (j <= i - 1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                }

                if (j - 1 >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]);
                }
                dp[i][j] += t[i][j];
            }
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(dp[n - 1][i], ans);
        }
        System.out.println(ans);
    }
}
