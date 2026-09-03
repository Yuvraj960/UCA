
public class LCS {

    public static int lcs(String m, String n) {
        //brute force
        //Run time O(2^^n)
        return lcs(m, n, 0, 0);

    }

    private static int lcs(String m, String n, int i, int j) {
        if (i >= m.length() || j >= n.length()) return 0;
        if (m.charAt(i) == n.charAt(j)) return 1 + lcs(m, n, i + 1, j + 1);
        return Math.max(lcs(m, n, i, j + 1), lcs(m, n, i + 1, j));
    }

    public static void main(String[] args) {
        System.out.println(lcs("abcde", "be")); //2
        System.out.println(lcs("AGGTAB", "GXTXAYB")); //GTAB -- 4

    }

}
