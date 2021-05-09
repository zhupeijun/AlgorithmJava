package atcoder.ABC._164.C;

import java.util.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private void solve() {
        int N = sc.nextInt();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; ++i) {
            set.add(sc.next());
        }
        System.out.println(set.size());
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}
