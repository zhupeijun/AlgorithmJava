package atcoder.AGC._047.B;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = false;

    private static final int CN = 26;

    private static class Node {
        Node[] nxt;
        int[] cnt;

        Node() {
            nxt = new Node [CN];
            cnt = new int[CN];
        }
    }

    private static class Trie {
        Node root;

        Trie() {
            root = new Node();
        }

        private void insert(String s) {
            int m = s.length();
            int[] cnt = new int[CN];
            for (int i = 0; i < m; ++i) {
                ++cnt[s.charAt(i) - 'a'];
            }

            Node p = root;
            for (int i = 0; i < CN; ++i) {
                if (cnt[i] > 0) {
                    ++p.cnt[i];
                }
            }

            for (int i = m - 1; i >= 0; --i) {
                int j = s.charAt(i) - 'a';
                Node nxt = p.nxt[j];
                if (nxt == null) {
                    nxt = new Node();
                    p.nxt[j] = nxt;
                }
                --cnt[j];
                p = nxt;
                for (int k = 0; k < CN; ++k) {
                    if (cnt[k] > 0) {
                        ++p.cnt[k];
                    }
                }
            }
        }

        private int search(String s) {
            int m = s.length();
            Node p = root;
            for (int i = m - 1; i > 0; --i) {
                int j = s.charAt(i) - 'a';
                p = p.nxt[j];
                if (p == null) {
                    return 0;
                }
            }

            return p.cnt[s.charAt(0) - 'a'];
        }
    }

    private void solve() {
        int N = sc.nextInt();
        List<String> S = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            S.add(sc.next());
        }

        S.sort(Comparator.comparingInt(String::length));

        long ans = 0;
        Trie trie = new Trie();
        for (int i = N - 1; i >= 0; --i) {
            ans += trie.search(S.get(i));
            trie.insert(S.get(i));
        }

        out.println(ans);
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

    public static void main(String[] args) {
        out = new MyWriter(new BufferedOutputStream(System.out));
        sc = new MyScanner();
        new Main().run();
        out.close();
    }
}