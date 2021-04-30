package topcoder.SRM800;

public class TIEFighterAssembly {
    public int assemble(String s) {
        int c1 = 0, c2 = 0, c3 = 0;
        for (char c : s.toCharArray()) {
            if (c == '|') {
                ++c1;
            } else if (c == 'O') {
                ++c2;
            } else if (c == '-') {
                ++c3;
            }
        }

        return Math.min(c1/2, Math.min(c2, c3 / 2));
    }
}
