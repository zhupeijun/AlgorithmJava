package codeforces._643.E;

import java.io.*;
import java.util.*;

public class Main {

    private long cal(List<Integer> h, long rh, int A, int R, int M) {
        long top = 0, down = 0;
        for (int hv : h) {
            top += Math.max(0, hv - rh);
            down += Math.max(0, rh - hv);
        }

        if (top > down) {
            return (top - down) * R + M * down;
        } else {
            return (down - top) * A + M * top;
        }
    }

    private void solve() {
        int N = sc.nextInt();
        int A = sc.nextInt();
        int R = sc.nextInt();
        int M = sc.nextInt();

        M = Math.min(M, A + R);

        long top = 0;
        long down = 0;

        List<Integer> h = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            h.add(sc.nextInt());
            top += h.get(i);
        }

        Collections.sort(h);

        long ans = Long.MAX_VALUE;

        ans = Math.min(ans, cal(h, top / N, A, R, M));
        ans = Math.min(ans, cal(h, top / N + 1, A, R, M));

        ans = Math.min(ans,top * R);
        for (int i = 0; i < N; i++) {
            long delta = h.get(i) - (i == 0 ? 0 : h.get(i - 1));
            top -= delta * (N - i);
            down += delta * i;
            if (top > down) {
                ans = Math.min(ans, (top - down) * R + M * down);
            } else {
                ans = Math.min(ans, (down - top) * A + M * top);
            }
        }

        out.println(ans);
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
