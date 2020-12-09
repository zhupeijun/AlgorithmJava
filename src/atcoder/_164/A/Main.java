package atcoder._164.A;

import java.util.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private void solve() {
        int S = sc.nextInt();
        int W = sc.nextInt();

        if (W >= S) {
            System.out.println("unsafe");
        } else {
            System.out.println("safe");
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}
