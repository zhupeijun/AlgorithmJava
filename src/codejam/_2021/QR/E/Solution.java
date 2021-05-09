package codejam._2021.QR.E;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Solution {
    private static final boolean N_CASE = true;
    private static final int N = 100;
    private static final int M = 10000;
    private static final int[] ANS = {54, 38, 34, 36, 51, 57, 28, 84, 32, 7, 16, 53, 25, 32, 94, 20, 7, 84, 64, 40, 81, 26, 51, 75, 83, 46, 94, 37, 79, 10, 92, 90, 76, 98, 72, 19, 92, 11, 100, 10, 72, 21, 1, 3, 77, 17, 54, 29, 41, 98};
    private static int correct = 0;
    private void solve(int ci) {
        int[] cnt = new int[M];
        String[] a = new String[N];
        for (int i = 0; i < N; i++) {
            String s = sc.next();
            a[i] = s;
            for (int j = 0; j < M; ++j) {
                if (s.charAt(j) == '1') {
                    ++cnt[j];
                }
            }
        }

        double maxScore = 0;
        int ans = 0;
        for (int i = 0; i < N; ++i) {
            int correctAns = 0;
            for (int j = 0; j < M; ++j) {
                if (a[i].charAt(j) == '1') {
                    --cnt[j];
                    ++correctAns;
                }
            }

            double[] rate = new double[M];
            for (int j = 0; j < M; ++j) {
                rate[j] = cnt[j] / 100.0;
            }

            Arrays.sort(rate);
            double score = 0;
            for (int k = 0; k < 500; ++k) {
                score += 1 - rate[k];
                score += rate[M-1-k]*5;
            }

            if (correctAns > 5000 && score > maxScore) {
                maxScore = score;
                ans = i + 1;
            }

            for (int j = 0; j < M; ++j) {
                if (a[i].charAt(j) == '1') {
                    ++cnt[j];
                }
            }
        }
        correct += ans == ANS[ci] ? 1 : 0;
        out.println(ans);
    }

    private void run() {
        int T = N_CASE ? sc.nextInt() : 1;
        int P = sc.nextInt();
        for (int t = 0; t < T; ++t) {
            out.print(String.format("Case #%d: ", t + 1));
            solve(t);
        }
        out.println(correct);
        out.println(1.0 * correct / ANS.length);
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