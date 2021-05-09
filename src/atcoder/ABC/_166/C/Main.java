package atcoder.ABC._166.C;

import java.util.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private void run() {
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] H = new int[N];

        for (int i = 0; i < N; i++) {
            H[i] = sc.nextInt();
        }

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int count = 0;
        for (int u = 0; u < N; u++) {
            boolean ok = true;
            for (int v : adj.get(u)) {
                if (H[v] >= H[u]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                ++count;
            }
        }

        System.out.println(count);
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
