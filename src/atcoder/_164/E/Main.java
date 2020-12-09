package atcoder._164.E;

import java.util.*;

class Edge {
    public int v;
    public int A;
    public int B;

    public Edge(int v, int a, int b) {
        this.v = v;
        A = a;
        B = b;
    }
}

class Node implements Comparable<Node> {
    public int u;
    public int coin;
    public long time;

    public Node(int u, int coin, long time) {
        this.u = u;
        this.coin = coin;
        this.time = time;
    }

    @Override
    public int compareTo(Node node) {
        return Long.compare(time, node.time);
    }
}

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private void solve() {
        int N = sc.nextInt();
        int M = sc.nextInt();
        int S = sc.nextInt();

        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < N + 1; ++i) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < M; ++i) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int A = sc.nextInt();
            int B = sc.nextInt();
            adj.get(u).add(new Edge(v, A, B));
            adj.get(v).add(new Edge(u, A, B));
        }

        int[] c = new int[N + 1];
        int[] d = new int[N + 1];

        for (int i = 1; i <= N; ++i) {
            c[i] = sc.nextInt();
            d[i] = sc.nextInt();
        }

        final int MAX_COIN = 50 * N;
        S = Math.min(S, MAX_COIN);
        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(1, S, 0));

        boolean[][] visit = new boolean[N + 1][MAX_COIN + 1];
        long[] ans = new long[N + 1];
        Arrays.fill(ans, Long.MAX_VALUE);
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (visit[node.u][node.coin]) {
                continue;
            }
            visit[node.u][node.coin] = true;
            ans[node.u] = Math.min(ans[node.u], node.time);

            for (Edge e : adj.get(node.u)) {
                int coin = node.coin - e.A;
                if (coin >= 0) {
                    q.add(new Node(e.v, coin, node.time + e.B));
                }
            }

            int coin = Math.min(MAX_COIN, node.coin + c[node.u]);
            q.add(new Node(node.u, coin,node.time + d[node.u]));
        }

        for (int i = 2; i <= N; ++i) {
            System.out.println(ans[i]);
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}
