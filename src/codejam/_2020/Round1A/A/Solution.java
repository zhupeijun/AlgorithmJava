package codejam._2020.Round1A.A;

import java.util.Scanner;

public class Solution {

    private Scanner sc = new Scanner(System.in);

    private String merge(String s1, String s2) {
        String p1 = s1.substring(0, s1.indexOf("*"));
        String f1 = s1.substring(s1.lastIndexOf("*") + 1);

        String p2 = s2.substring(0, s2.indexOf("*"));
        String f2 = s2.substring(s2.lastIndexOf("*") + 1);

        String pref = null;
        if (p2.equals("") || p1.startsWith(p2)) {
            pref = p1;
        } else if (p1.equals("") || p2.startsWith(p1)) {
            pref = p2;
        }

        if (pref == null) {
            return null;
        }

        String suf = null;
        if (f2.equals("") || f1.endsWith(f2)) {
            suf = f1;
        } else if (f1.equals("") || f2.endsWith(f1)){
            suf = f2;
        }

        if (suf == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(pref);
        sb.append(s1, s1.indexOf("*"), s1.lastIndexOf("*"));
        sb.append("*");
        sb.append(s2, s2.indexOf("*"), s2.lastIndexOf("*"));
        sb.append("*");
        sb.append(suf);
        return sb.toString();
    }

    private void solve() {
        int N = sc.nextInt();
        String[] s = new String[N];
        for (int i = 0; i < N; ++i) {
            s[i] = sc.next();
        }

        String current = s[0];
        for (int i = 1; i < N; ++i) {
            current = merge(current, s[i]);
            if (current == null) {
                current = "*";
                break;
            }
        }

        //System.out.println(current);
        if (!current.equals("*")) {
            current = current.replaceAll("\\*", "");
        }
        System.out.println(current);
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
