package atcoder._167.D;

import java.io.*;
import java.util.*;

public class Main {
    private void solve() {
        int N = sc.nextInt();
        long K = sc.nextLong();

        int[] A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = sc.nextInt();
        }

        List<Integer> h = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int cur = 1;
        while (!map.containsKey(cur)) {
            map.put(cur, h.size());
            h.add(cur);
            cur = A[cur];
        }

        int start = map.get(cur);
        if (K < h.size()) {
            out.println(h.get((int) K));
        } else {
            int loop = h.size() - start;
            int t = (int)((K - start) % loop);
            out.println(h.get(t + start));
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
        new Main().solve();
        out.close();
    }
}
