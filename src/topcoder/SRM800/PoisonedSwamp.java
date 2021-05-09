// BEGIN CUT HERE
package topcoder.SRM800;
// END CUT HERE

import java.util.*;

public class PoisonedSwamp {
    private static final int[][] DIR = {{0,1},{1,0},{-1,0},{0,-1}};

    private boolean isValid(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public String cross(String[] g) {
        int n = g.length;
        int m = g[0].length();

        boolean[][][] vis = new boolean[n][m][10];
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[] { 0, 0, 0 });
        vis[0][0][0] = true;
        while (!q.isEmpty()) {
            int[] t = q.poll();

            for (int[] d : DIR) {
                int nx = t[0] + d[0];
                int ny = t[1] + d[1];

                if (isValid(nx, ny, n, m)) {
                    char c = g[nx].charAt(ny);

                    if (c != '#') {
                        int np = t[2];
                        if (c == 'S') np = 0;
                        else if (Character.isDigit(c)) {
                            np += c - '0';
                        }

                        if (np < 10) {
                            if (!vis[nx][ny][np]) {
                                vis[nx][ny][np] = true;
                                q.add(new int[] { nx, ny, np });
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 10; ++i) {
            if (vis[n-1][m-1][i]) {
                return "possible";
            }
        }
        return "impossible";
    }
}
