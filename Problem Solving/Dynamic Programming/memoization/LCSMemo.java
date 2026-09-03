import java.util.HashMap;
import java.util.Map;

public class LCSMemo {
    //Run time O(m*n)
    private static Map<String, Integer> memo;

    public static int lcs(String m, String n) {
        //brute force
        memo = new HashMap<>();
        return lcs(m, n, 0, 0);

    }

    private static int lcs(String m, String n, int i, int j) {
        String key = i + "-" + j;
        if (memo.containsKey(key)) return memo.get(key); // o(1)
        if (i >= m.length() || j >= n.length()) return 0;
        if (m.charAt(i) == n.charAt(j)) {
            int res = 1 + lcs(m, n, i + 1, j + 1);
            memo.put(key, res); //o(1)
            return res;
        }
        int res = Math.max(lcs(m, n, i, j + 1), lcs(m, n, i + 1, j));
        memo.put(key, res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lcs("abcde", "be")); //2
        System.out.println(lcs("AGGTAB", "GXTXAYB")); //GTAB -- 4

    }

}
