package atcoder.ARC._116.D;

import java.io.*;

import library.algorithm.Mint;
import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;
    private static final int B = 13;
    private static final int CN = 5005;
    private static final Mint Mt = new Mint(()->998244353);

    private void solve() {
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] c = new int[CN][CN];
        for (int i = 0; i < CN; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (i == 0 || j == 0) c[i][j] = 1;
                else c[i][j] = (int)Mt.add(c[i-1][j-1], c[i-1][j]);
            }
        }

        int[][] dp = new int[B+1][M+1];
        dp[0][0] = 1;
        for (int i = 0; i < B; ++i) {
            for (int j = 0; j <= M; ++j) {
                for (int k = 0; k <= M; k += 2) {
                    int add = k * (1<<i);
                    if (j + add > M) break;
                    dp[i+1][j+add] = (int)Mt.add(dp[i+1][j+add], Mt.mul(dp[i][j], c[N][k]));
                }
            }
        }
        out.println(dp[B][M]);
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
        new Main().run();
        out.close();
    }
}