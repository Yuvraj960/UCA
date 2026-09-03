import java.util.HashMap;
import java.util.Map;

public class Fib {

    public static void main(String[] args) {
        System.out.println(new Fib().getFib(6));
        System.out.println(new Fib().getFib(10));
        System.out.println(new Fib().getFib(50));
    }

    private final Map<Integer, Integer> cache;

    public Fib() {
        cache = new HashMap<>();
    }

    private int getFib(int i) {
        if (cache.get(i) != null)
            return cache.get(i);
        if (i == 1 || i == 0)
            return 1;
        int result = getFib(i - 1) + getFib(i - 2);
        cache.put(i, result);
        return result;
    }

}
