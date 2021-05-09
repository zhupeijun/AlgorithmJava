// BEGIN CUT HERE
package topcoder.TCO2021Round1A;
// END CUT HERE

import java.util.*;

public class EllysRansom {
    int V;
    int[] match;
    boolean[] used;
    List<List<Integer>> g;

    private void addEdge(int u, int v) {
        g.get(u).add(v);
        g.get(v).add(u);
    }

    boolean dfs(int v) {
        used[v] = true;
        for (int i = 0; i < g.get(v).size(); ++i) {
            int u = g.get(v).get(i), w = match[u];
            if (w < 0 || !used[w] && dfs(w)) {
                match[v] = u;
                match[u] = v;
                return true;
            }
        }
        return false;
    }

    int bMatch() {
        int res = 0;
        Arrays.fill(match, -1);
        for (int v = 0; v < V; ++v) {
            if (match[v] < 0) {
                Arrays.fill(used, false);
                if (dfs(v)) {
                    ++res;
                }
            }
        }
        return res;
    }

    public String getRansom(String A, String B, String T) {
        int N = A.length();
        int M = T.length();

        V = N+M+2;
        match = new int[V];
        used = new boolean[V];
        g = new ArrayList<>();
        for (int i = 0; i < V; ++i) {
            g.add(new ArrayList<>());
        }

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                int u = i;
                int v = N + j;

                if (A.charAt(i) == T.charAt(j) || B.charAt(i) == T.charAt(j)) {
                    addEdge(u, v);
                }
            }
        }

        int ans = bMatch();
        if (ans < M) return "NO SOLUTION";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; ++i) {
            int j = match[i];
            if (j == -1) {
                sb.append("_");
            } else {
                sb.append(T.charAt(j-N));
            }
        }
        return sb.toString();
    }
}
