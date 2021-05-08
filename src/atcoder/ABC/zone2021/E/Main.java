package atcoder.ABC.zone2021;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;
    private static final int[][] DIR = {{0,1},{0,-1},{1,0},{-1,0}};

    private static class Node implements Comparable<Node> {
        int x, y, c, a;
        public Node(int x, int y, int c, int a) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.a = a;
        }

        @Override
        public int compareTo(Node o) {
            return c - o.c;
        }
    }

    private void solve() {
        int R = sc.nextInt();
        int C = sc.nextInt();

        int[][] A = sc.nextIntArray(R, C-1);
        int[][] B = sc.nextIntArray(R-1, C);

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(0, 0, 0, 0));

        boolean[][][] vis = new boolean[R][C][2];
        while (!q.isEmpty()) {
            Node u = q.poll();
            if (vis[u.x][u.y][u.a]) continue;
            vis[u.x][u.y][u.a] = true;
            if (u.x == R-1 && u.y == C-1) {
                out.println(u.c);
                return;
            }

            for (int di = 0; di < 4; ++di) {
                int[] d = DIR[di];
                int nx = u.x + d[0];
                int ny = u.y + d[1];

                if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                    int nc = 1, na = 0;
                    if (di == 0) nc = A[u.x][u.y];
                    else if (di == 1) nc = A[u.x][u.y-1];
                    else if (di == 2) nc = B[u.x][u.y];
                    else {
                        na = u.a;
                        if (u.a == 0) {
                            na = 1;
                            ++nc;   
                        }
                    }

                    q.add(new Node(nx, ny, u.c + nc, na));  
                }
            }
        }
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
        cu = new CommonUtils();
        new Main().run();
        out.close();
    }
}
