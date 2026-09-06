
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FIndBestSum {

    final Map<Integer, List<Integer>> cache;

    public FIndBestSum() {
        this.cache = new HashMap<>();
    }

    public List<Integer> findSum(int target, int[] a) {
        // O(n^^2 * target)
        if (cache.get(target) != null) return cache.get(target);

        if (target == 0) return new ArrayList<>();
        if (target < 0) return null;
        List<Integer> result = null;
        for (int i : a) {
            List<Integer> r = findSum(target - i, a);
            if (r != null) {
                List<Integer> temp = new ArrayList<>(r); // copy of list  n time
                temp.add(i);
                if (result == null || result.size() > temp.size()) {
                    result = temp;
                }
            }
        }
        cache.put(target, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new FIndBestSum().findSum(7, new int[]{2, 3, 7})); // 7
        System.out.println(new FIndBestSum().findSum(7, new int[]{2, 4})); // null []
        System.out.println(new FIndBestSum().findSum(50, new int[]{2, 5, 25})); // [25,25]
        System.out.println(new FIndBestSum().findSum(100, new int[]{2, 5, 25})); // [25,25,25,25]
    }

}
