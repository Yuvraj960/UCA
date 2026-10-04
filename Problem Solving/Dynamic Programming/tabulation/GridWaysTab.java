
import java.util.HashMap;
import java.util.Map;

public class GridWaysTab {
    private static Map<String, Integer> cache = new HashMap<>();

    public static int findways(int r, int c) {
        int[][] tab = new int[r + 1][c + 1];
        tab[1][1] = 1;

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (i == 1 && j == 1) continue;
                tab[i][j] = tab[i - 1][j] + tab[i][j - 1];
            }
        }
        return tab[r][c];

    }

    public static void main(String[] args) {
        System.out.println(findways(3, 3)); // 6
        System.out.println(findways(1, 1)); // 1
        System.out.println(findways(2, 3)); // 3
        System.out.println(findways(3, 2)); // 3
        System.out.println(findways(20, 20)); // 985525432

    }
}
