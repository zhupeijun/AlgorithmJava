package codeforces._632.D;
import java.io.*;
import java.util.*;

public class Main {
    private void swap(char[] a, int i, int j) {
        char tmp = a[i]; a[i] = a[j]; a[j] = tmp;
    }

    private void solve() {
        int n = sc.nextInt();
        int k = sc.nextInt();

        String s = sc.next();
        char[] a = s.toCharArray();
        int total = 0;
        int last = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (a[i] == 'R') {
                total += last - i;
                --last;
            }
        }

        if (total < k) {
            out.println(-1);
            return;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n - 1; i++) {
            if (a[i] == 'R' && a[i + 1] == 'L') {
                q.add(i);
            }
        }

        List<Integer> next = new ArrayList<>();
        List<Integer> move = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        while (k > 0) {
            next.clear();
            move.clear();
            while (!q.isEmpty() && total >= k) {
                int u = q.poll();
                move.add(u);
                swap(a, u, u + 1);
                if (u + 2 < n && a[u + 2] == 'L') {
                    next.add(u + 1);
                }

                if (u - 1 >= 0 && a[u - 1] == 'R') {
                    next.add(u - 1);
                }
                --total;
            }
            --k;
            ans.add(move.size());
            ans.addAll(move);
            q.addAll(next);
        }

        if (total != k) {
            out.println(-1);
        } else {
            int i = 0;
            while (i < ans.size()) {
                int ni = ans.get(i++);
                out.print(ni);
                for (int j = 0; j < ni; ++j) {
                    out.print(' ');
                    out.print(ans.get(i++) + 1);
                }
                out.println();
            }
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

        int[] nextArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }
    }

    public static void main(String[] args) {
        out = new PrintWriter(new BufferedOutputStream(System.out));
        sc = new MyScanner();
        new Main().solve();
        out.close();
    }
}
