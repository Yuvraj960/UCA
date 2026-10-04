
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FIndBestSumTabulation {

    final Map<Integer, List<Integer>> cache;

    public FIndBestSumTabulation() {
        this.cache = new HashMap<>();
    }

    public List<Integer> findSum(int target, int[] a) {
        // O(n^^2 * target)
        List<Integer>[] tab = new List[target+1];
        tab[0] = new ArrayList<>();
        for (int i = 0; i<tab.length; i++) {
            if(tab[i] == null) continue;
            for(int e : a){
                if(i+e> target) continue;
                List<Integer> currentVal = tab[i+e];
                List<Integer> temp = new ArrayList<>(tab[i]);
                temp.add(e);
                if(currentVal == null || temp.size() < currentVal.size() ){
                    tab[i+e] = temp;
                }
            }
        }
        return tab[target];
    }

    public static void main(String[] args) {
        System.out.println(new FIndBestSumTabulation().findSum(7, new int[]{2, 3, 7})); // 7
        System.out.println(new FIndBestSumTabulation().findSum(7, new int[]{2, 4})); // null []
        System.out.println(new FIndBestSumTabulation().findSum(50, new int[]{2, 5, 25})); // [25,25]
        System.out.println(new FIndBestSumTabulation().findSum(100, new int[]{2, 5, 25})); // [25,25,25,25]
    }

}
