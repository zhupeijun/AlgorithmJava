package atcoder.ARC._115.E;

import java.io.*;
import java.util.*;

import library.algorithm.Mint;
import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;
    private static final Mint Mt = new Mint(()->998244353);

    private void solve() {
        int N = sc.nextInt();
        int[] A = sc.nextIntArray(N);

        Deque<long[]> stack = new ArrayDeque<>();
        long[] dp = new long[N+1]; dp[0] = -1;
        long val = 0;
        for (int i = 0; i < N; ++i) {
            long num = -dp[i];
            while (!stack.isEmpty() && stack.peek()[0] > A[i]) {
                long[] x = stack.pop();
                val = Mt.sub(val, Mt.mul(x[1], x[0]));
                num = Mt.add(num, x[1]);
            }
            stack.push(new long[] { A[i], num });
            val = Mt.add(val, Mt.mul(A[i], num));
            dp[i+1] = val;
        }
        out.println(Mt.add(0, N % 2 == 0 ? -dp[N] : dp[N]));
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