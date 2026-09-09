
import java.util.Arrays;

public class CanConstruct {

    public static boolean canConstruct(String target, String[] dict) {
        boolean[] tab = new boolean[target.length() + 1];
        Arrays.fill(tab, false);
        tab[0] = true;

        for (int i = 0; i <= target.length(); i++) {
            if (tab[i]) {
                for (String e : dict) {
                    String revisedTarget = target.substring(i);
                    if (revisedTarget.startsWith(e)) {
                        tab[i + e.length()] = true;
                    }
                }
            }

        }
        return tab[target.length()];
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("abcd", new String[]{"ab", "abc", "c", "ce", "d"})); //true
        System.out.println(canConstruct("abe", new String[]{"ab", "abc", "c", "ce", "d"})); //false
        System.out.println(canConstruct("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", new String[]{"a", "aa", "aaa", "aaaa"})); //false
    }
}
