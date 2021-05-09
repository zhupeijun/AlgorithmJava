package projecteuler._60;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private List<Integer> prime;

    private boolean checkPrime(long x) {
        for (long k = 2; k * k <= x; ++k) {
            if (x % k == 0) {
                return false;
            }
        }
        return true;
    }

    private void dfs(int u, boolean[][] g, List<Integer> stack) {
        stack.add(u);
        for (int i = 0; i < stack.size(); ++i) {
            for (int j = i + 1; j < stack.size(); ++j) {
                if (!g[stack.get(i)][stack.get(j)]) {
                    stack.remove(stack.size() - 1);
                    return;
                }
            }
        }

        if (stack.size() == 5) {
            System.out.println(stack.stream().map(k -> prime.get(k)).reduce(Integer::sum));
            stack.remove(stack.size() - 1);
            return;
        }

        for (int v = 0; v < g.length; ++v) {
            if (!stack.contains(v) && g[u][v]) {
                dfs(v, g, stack);
            }
        }

        stack.remove(stack.size() - 1);
    }

    private void solve() {
        final int M = 10000;
        prime = new ArrayList<>();
        boolean[] isPrime = new boolean[M];
        Arrays.fill(isPrime, true);
        for (int i = 2; i < M; ++i) {
            if (isPrime[i]) {
                for (int j = 2;  j*i < M; ++j) {
                    isPrime[j*i] = false;
                }
                prime.add(i);
            }
        }

        int n = prime.size();
        boolean[][] g = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                long x = Long.parseLong(prime.get(i) + "" + prime.get(j));
                long y = Long.parseLong(prime.get(j) + "" + prime.get(i));
                if (checkPrime(x) && checkPrime(y)) {
                    g[i][j] = g[j][i] = true;
                }
            }
        }

        for (int i = 0; i < n; ++i) {
            dfs(i, g, new ArrayList<>());
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}
