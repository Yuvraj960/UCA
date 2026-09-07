
import java.util.HashMap;
import java.util.Map;

public class GridWaysMemo {
    private static Map<String, Integer> cache = new HashMap<>();

    public static int findways(int r, int c){

        // O(n+m)   O(2^^(n+m))
        String key = r + "--" + c;
        if(cache.containsKey(key)) return cache.get(key);
        if(r==0 || c == 0) return 0;
        if(r==1 && c==1) return 1;
        int res =  findways(r-1, c) + findways(r, c-1);
        cache.put(key, res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findways(3,3)); // 6
        System.out.println(findways(1,1)); // 1
        System.out.println(findways(2,3)); // 3
        System.out.println(findways(3,2)); // 3
        System.out.println(findways(20,20)); // lot of time 2^^40 is huge

    }
}
