package codejam._2020.Round1B.C;


import java.util.*;

class Node {
    public int[] a;
    public List<int[]> op;

    public Node(int[] a, List<int[]> op) {
        this.a = a;
        this.op = op;
    }
}

public class Solution2 {
    private Scanner sc = new Scanner(System.in);

    private Map<Integer, Integer> memo;

    private void swap(int[] a, int k1, int end) {
        int[] tmp = new int[end + 1];
        System.arraycopy(a, k1, tmp, 0, end - k1 + 1);
        System.arraycopy(a, 0, tmp, end - k1 + 1, k1);
        System.arraycopy(tmp, 0, a, 0, end + 1);
    }

    private int getKey(int[] a) {
        int value = 0;
        for (int x : a) {
            value = value * 10 + x;
        }
        return value;
    }

    private boolean check(int[] a, int[] t) {
        int n = a.length;
        for (int i = 0; i < n; ++i) {
            if (a[i] != t[i]) {
                return false;
            }
        }
        return true;
    }

    private List<int[]> helper(int[] a, int[] t) {
        Set<Integer> set = new HashSet<>();
        int n = a.length;
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(a, new ArrayList<>()));
        set.add(getKey(a));
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (check(node.a, t)) {
                return node.op;
            }

            for (int i = 0; i < n; ++i) {
                for (int j = i + 1; j < n; ++j) {
                    int[] b = Arrays.copyOf(node.a, n);
                    swap(b, i + 1, j);

                    int key = getKey(b);
                    if (set.contains(key)) {
                        continue;
                    }

                    List<int[]> op = new ArrayList<>(node.op);
                    op.add(new int[]{i + 1, j - i});

                    q.add(new Node(b, op));
                    set.add(key);
                }
            }
        }
        return null;
    }

    private void solve() {
        int R = sc.nextInt();
        int C = sc.nextInt();

        int[] a = new int[R * C];
        for (int c = 0; c < C; ++c) {
            for (int r = 0; r < R; ++r) {
                a[c * R + r] = r;
            }
        }

        int[] t = new int[R * C];
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                t[r * C + c] = r;
            }
        }

        List<int[]> ans = helper(a, t);
        System.out.println(ans.size());
        for (int[] op : ans) {
            System.out.println(String.format("%d %d", op[0], op[1]));
        }
    }

    private void run() {
        int T = sc.nextInt();
        for (int i = 1; i <= T; ++i) {
            System.out.print(String.format("Case #%d: ", i));
            solve();
        }
    }
    public static void main(String[] args) {
        new Solution2().run();
    }
}