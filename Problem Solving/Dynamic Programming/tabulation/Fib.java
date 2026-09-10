public class Fib {

    public static void main(String[] args) {
        System.out.println(new Fib().getFib(6));
        System.out.println(new Fib().getFib(10));
        System.out.println(new Fib().getFib(50));
    }

    private int getFib(int i) {
        int[] cache = new int[i+1];
        cache[0] = 1;
        cache[1] = 1;
        for(int j = 2;j<=i;j++)
            cache[j] = cache[j-1] + cache[j-2];
        return cache[i];
    }

}
