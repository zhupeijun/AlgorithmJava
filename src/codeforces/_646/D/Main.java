package codeforces._646.D;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = true;

    private void solve() {
        int n = sc.nextInt();
        int k = sc.nextInt();

        List<List<Integer>> s = new ArrayList<>();
        Set<Integer> vis = new HashSet<>();
        for (int i = 0; i < k; i++) {
            int c = sc.nextInt();
            List<Integer> si = new ArrayList<>();
            for (int j = 0; j < c; j++) {
                int v = sc.nextInt();
                si.add(v);
                vis.add(v);
            }
            s.add(si);
        }

        List<Integer> last = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!vis.contains(i)) {
                last.add(i);
            }
        }

        if (last.size() > 0) {
            s.add(last);
        }

        // query max
        out.print("? " + n);
        for (int i = 1; i <= n; i++) {
            out.print(' ');
            out.print(i);
        }
        out.println();
        out.flush();

        int max = sc.nextInt();

        // find where max is
        int left = 0, right = s.size() - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            int total = 0;
            for (int i = 0; i <= mid; ++i) {
                total += s.get(i).size();
            }
            out.print("? " + total);
            for (int i = 0; i <= mid; ++i) {
                for (int v : s.get(i)) {
                    out.print(' ');
                    out.print(v);
                }
            }
            out.println();
            out.flush();
            int r = sc.nextInt();
            if (r == max) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        // set right has max, all others should be max,
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            if (i != right) {
                ans[i] = max;
            }
        }

        // query set right's max
        if (right < k) {
            out.print("? " + (n - s.get(right).size()));
            for (int i = 0; i < s.size(); i++) {
                if (right != i) {
                    for (int v : s.get(i)) {
                        out.print(' ');
                        out.print(v);
                    }
                }
            }
            out.println();
            out.flush();
            ans[right] = sc.nextInt();
        }

        out.print("!");
        for (int i = 0; i < k; i++) {
            out.print(' ');
            out.print(ans[i]);
        }
        out.println();
        out.flush();

        String correct = sc.next();
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

        int[] nextArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
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

    public static void main(String[] args) {
        out = new MyWriter(new BufferedOutputStream(System.out));
        sc = new MyScanner();
        new Main().run();
        out.close();
    }
}