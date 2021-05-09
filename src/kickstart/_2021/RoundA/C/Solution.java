package kickstart._2021.RoundA.C;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Solution {
    private static final boolean N_CASE = true;
    private static final int[][] DIR = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private void solve() {
        int R = sc.nextInt();
        int C = sc.nextInt();
        int[][] g = sc.nextIntArray(R, C);

        PriorityQueue<int[]> q = new PriorityQueue<>((v1, v2) -> v2[0]-v1[0]);
        for (int i = 0; i < R; ++i) {
            for (int j = 0; j < C; ++j) {
                q.add(new int[] { g[i][j], i, j});
            }
        }

        long ans = 0;
        boolean[][] vis = new boolean[R][C];
        while (!q.isEmpty()) {
            int[] t = q.poll();
            int h = t[0], x = t[1], y = t[2];
            if (vis[x][y]) continue;
            vis[x][y] = true;
            for (int[] d : DIR) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                    if (h > 0) {
                        int to = h - 1;
                        if (g[nx][ny] < to) {
                            int add = to - g[nx][ny];
                            g[nx][ny] = to;
                            ans += add;
                            q.add(new int[] { to, nx, ny });
                        }
                    }
                }
            }
        }
        out.println(ans);
    }

    private void run() {
        int T = N_CASE ? sc.nextInt() : 1;
        for (int t = 0; t < T; ++t) {
            out.print(String.format("Case #%d: ", t + 1));
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