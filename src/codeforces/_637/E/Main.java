package codeforces._637.E;

import java.io.*;
import java.util.*;

public class Main {

    class Node implements Comparable<Node> {
        public int i;
        public int g;
        public int t;

        public Node(int i, int g, int t) {
            this.i = i;
            this.g = g;
            this.t = t;
        }

        @Override
        public int compareTo(Node node) {
            return t - node.t;
        }
    }

    private void solve() {
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] d = new int[m];
        for (int i = 0; i < m; ++i) {
            d[i] = sc.nextInt();
        }

        Arrays.sort(d);

        int g = sc.nextInt();
        int r = sc.nextInt();

        boolean[][] visit = new boolean[m + 1][g + 1];
        Deque<Node> q = new ArrayDeque<>();
        q.addFirst(new Node(0, g, 0));

        int ans = -1;
        while (!q.isEmpty()) {
            Node u = q.pollFirst();
            if (u.i == m - 1) {
                int dist = u.t * (r + g) + (u.g == 0 ? -r : (g - u.g));
                if (ans == -1 || ans > dist) {
                    ans = dist;
                }
            }

            if (visit[u.i][u.g]) {
                continue;
            }
            visit[u.i][u.g] = true;

            if (u.i - 1 >= 0) {
                int t = d[u.i] - d[u.i - 1];
                int rg = (u.g == 0 ? g : u.g) - t;
                if (rg > 0) {
                    q.addFirst(new Node(u.i - 1, rg, u.t));
                } else if (rg == 0) {
                    q.addLast(new Node(u.i - 1, rg, u.t + 1));
                }
            }

            if (u.i + 1 < m) {
                int t = d[u.i + 1] - d[u.i];
                int rg = (u.g == 0 ? g : u.g) - t;
                if (rg > 0) {
                    q.addFirst(new Node(u.i + 1, rg, u.t));
                } else if (rg == 0){
                    q.addLast(new Node(u.i + 1, rg, u.t + 1));
                }
            }
        }

        out.println(ans);
    }

    private void run() {
        int T =  1;//sc.nextInt();
        for (int t = 0; t < T; ++t) {
            solve();
        }
    }

    private static PrintWriter out;
    private static MyScanner sc;

    private static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        private MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    public static void main(String[] args) {
        out = new PrintWriter(new BufferedOutputStream(System.out));
        sc = new MyScanner();
        new Main().run();
        out.close();
    }
}