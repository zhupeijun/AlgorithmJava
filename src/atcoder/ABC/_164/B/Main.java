package atcoder.ABC._164.B;

import java.util.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private void solve() {
        int th = sc.nextInt();
        int ts = sc.nextInt();
        int ah = sc.nextInt();
        int as = sc.nextInt();

        int turn = 0;
        while (th > 0 && ah > 0) {
            if (turn == 0) {
                ah -= ts;
            } else {
                th -= as;
            }
            turn ^= 1;
        }

        if (ah <= 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}
