package codejam._2020.Round1B.C;

import java.util.*;

public class Solution {
    private Scanner sc = new Scanner(System.in);

    private void swap(int[] a, int end, int mid) {
        int n = a.length;
        int[] tmp = new int[n];
        System.arraycopy(a, mid, tmp, 0,end - mid + 1);
        System.arraycopy(a, 0, tmp, end - mid + 1, mid);
        System.arraycopy(tmp, 0, a, 0, end + 1);
    }

    private int[] adjust(int[] a) {
        int n = a.length;
        for (int k = 1; k < n - 1; ++k) {
            if (a[k] == a[0] && a[k] != a[k + 1]) {
                for (int i = k - 1; i >= 0; --i) {
                    if (a[i] == a[k + 1]) {
                        swap(a, k, i + 1);
                        return new int[] { i + 1, k - i };
                    }
                }
            }
        }

        for (int i = 0; i < n - 1; ++i) {
            if (a[i] != a[n - 1]) {
                swap(a, n - 2, i);
                return new int[] { i, n - 1 - i};
            }
        }
        return null;
    }

    private boolean check(int[] a) {
        for (int i = 1; i < a.length; ++i) {
            if (a[i] < a[i - 1]) {
                return false;
            }
        }
        return true;
    }

    private void solve() {
        int R = sc.nextInt();
        int C = sc.nextInt();

        int n = R * C;
        int[] a = new int[n];
        for (int i = 0; i < C; ++i) {
            for (int j = 0; j < R; ++j) {
                a[i * R + j] = j + 1;
            }
        }

        List<int[]> ans = new ArrayList<>();
        while (!check(a)) {
            ans.add(adjust(a));
        }

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
        new Solution().run();
    }
}