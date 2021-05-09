package atcoder.ABC._194.E;

import java.io.*;
import java.util.*;

import library.algorithm.BIT;
import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private void solve() {
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] A = sc.nextIntArray(N);


        BIT bit = new BIT(N+5);
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < M; ++i) {
            if (cnt.getOrDefault(A[i], 0) == 0) {
                bit.add(A[i]+1, 1);
            }

            cnt.put(A[i], cnt.getOrDefault(A[i], 0) + 1);
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= N - M; ++i) {
            int l = 0, r = N;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (bit.sum(mid+1) < mid + 1) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            ans = Math.min(ans, l);

            cnt.put(A[i], cnt.get(A[i]) - 1);
            if (cnt.get(A[i]) == 0) {
                bit.add(A[i] + 1, -1);
            }

            if (i + M < N) {
                if (cnt.getOrDefault(A[i+M], 0) == 0) {
                    bit.add(A[i+M]+1, 1);
                }

                cnt.put(A[i+M], cnt.getOrDefault(A[i+M], 0) + 1);
            }
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
        new Main().run();
        out.close();
    }
}