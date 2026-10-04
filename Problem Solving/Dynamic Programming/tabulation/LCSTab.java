
public class LCSTab {
    private final int[][] tab;
    private final String m;
    private final String n;

    public LCSTab(String m, String n) {
        this.tab = new int[m.length() + 1][n.length() + 1];
        this.m = m;
        this.n = n;
    }

    public int lcs() {

        // if char matches 1+[i-1][j-1]  otherwise max(i,j-1 or i-1,j)
        for (int i = 1; i <= m.length(); i++) {
            for (int j = 1; j <= n.length(); j++) {
                if (m.charAt(i - 1) == n.charAt(j - 1)) {
                    tab[i][j] = 1 + tab[i - 1][j - 1];
                } else {
                    tab[i][j] = Math.max(tab[i - 1][j], tab[i][j - 1]);
                }

            }
        }
        return tab[m.length()][n.length()];
    }

    public String printLCS() {
        StringBuilder sb = new StringBuilder();
        int i = m.length();
        int j = n.length();
        while (i > 0 && j > 0) {
            if (m.charAt(i - 1) == n.charAt(j - 1)) {
                sb.append(m.charAt(i-1));
                i--;
                j--;
            } else if (tab[i - 1][j] > tab[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new LCSTab("abcde", "be").lcs()); //2
        LCSTab l = new LCSTab("AGGTAB", "GXTXAYB"); //GTAB -- 4
        System.out.println(l.lcs()); //4
        System.out.println(l.printLCS()); //GTAB

    }

}
