package atcoder.ABC._176.F;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = false;

    private void solve() {
        int N = sc.nextInt();
        int M = N * 3;
        int[] A = sc.nextIntArray(M);

        int[][] dp = new int[N + 1][N + 1];
        fill(dp, -1);
        dp[A[0]][A[1]] = dp[A[1]][A[0]] = 0;

        int[] local = new int[N + 1];
        fill(local, -1);

        int ans = 0;
        int add = 0;
        for (int i = 2; i < M; i += 3) {
            if (i == M - 1) {
                if (dp[A[i]][A[i]] != -1) {
                    ans = Math.max(ans, dp[A[i]][A[i]] + 1);
                }
            } else {
                if (A[i] == A[i + 1] && A[i] == A[i + 2]) {
                    ++add;
                    continue;
                }

                List<int[]> update = new ArrayList<>();
                for (int j = 0; j < 3; ++j) {
                    int t1 = i + j;
                    if (dp[A[t1]][A[t1]] != -1) {
                        int t2 = i + ((j + 1) % 3);
                        int t3 = i + ((j + 2) % 3);
                        update.add(new int[] { A[t2], A[t3], dp[A[t1]][A[t1]] + 1 });
                    }
                }

                for (int j1 = 0; j1 < 3; ++j1) {
                    int t1 = i + j1;
                    for (int j2 = j1 + 1; j2 < 3; ++j2) {
                        int j3 = 3 - j1 - j2;
                        int t2 = i + j2;
                        int t3 = i + j3;

                        if (A[t1] == A[t2]) {
                            for (int k = 1; k <= N; ++k) {
                                if (dp[k][A[t1]] != -1) {
                                    update.add(new int[] { k, A[t3], dp[k][A[t1]] + 1 });
                                }
                            }
                        }

                        update.add(new int[] { A[t1], A[t2], ans });
                    }

                    for (int k = 1; k <= N; ++k) {
                        update.add(new int[] { k, A[t1], local[k] });
                    }
                }

                for (int[] u : update) {
                    dp[u[0]][u[1]] = dp[u[1]][u[0]] = Math.max(dp[u[0]][u[1]], u[2]);
                    local[u[0]] = Math.max(local[u[0]], dp[u[0]][u[1]]);
                    local[u[1]] = Math.max(local[u[1]], dp[u[0]][u[1]]);
                    ans = Math.max(dp[u[0]][u[1]], ans);
                }
            }
        }

        out.println(ans + add);
    }

    private void run() {
        int T = N_CASE ? sc.nextInt() : 1;
        for (int t = 0; t < T; ++t) {
            solve();
        }
    }

    private static MyWriter out;
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

        int[] nextIntArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        int[][] nextIntArray(int n, int m) {
            int[][] a = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            return a;
        }

        long[] nextLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextLong();
            }
            return a;
        }

        long[][] nextLongArray(int n, int m) {
            long[][] a = new long[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = nextLong();
                }
            }
            return a;
        }

        List<Integer> nextList(int n) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(nextInt());
            }
            return list;
        }

        List<Long> nextLongList(int n) {
            List<Long> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(nextLong());
            }
            return list;
        }

        char[] nextCharArray(int n) {
            return sc.next().toCharArray();
        }

        char[][] nextCharArray(int n, int m) {
            char[][] c = new char[n][m];
            for (int i = 0; i < n; i++) {
                String s = sc.next();
                for (int j = 0; j < m; j++) {
                    c[i][j] = s.charAt(j);
                }
            }
            return c;
        }
    }

    private static class MyWriter extends PrintWriter {
        private MyWriter(OutputStream outputStream) {
            super(outputStream);
        }

        void printArray(int[] a) {
            for (int i = 0; i < a.length; ++i) {
                print(a[i]);
                print(i == a.length - 1 ? '\n' : ' ');
            }
        }

        void printlnArray(int[] a) {
            for (int v : a) {
                println(v);
            }
        }

        void printList(List<Integer> list) {
            for (int i = 0; i < list.size(); ++i) {
                print(list.get(i));
                print(i == list.size() - 1 ? '\n' : ' ');
            }
        }

        void printlnList(List<Integer> list) {
            list.forEach(this::println);
        }
    }

    private <T> List<List<T>> createGraph(int n) {
        List<List<T>> g = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            g.add(new ArrayList<>());
        }
        return g;
    }

    private void fill(int[][] a, int value) {
        for (int[] row : a) {
            fill(row, value);
        }
    }

    private void fill(int[] a, int value) {
        Arrays.fill(a, value);
    }

    public static void main(String[] args) {
        out = new MyWriter(new BufferedOutputStream(System.out));
        sc = new MyScanner();
        new Main().run();
        out.close();
    }
}