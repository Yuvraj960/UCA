package dp.brute_force;

public class Fib {

    public static void main(String[] args) {
        System.out.println(new Fib().getFib(6));
        System.out.println(new Fib().getFib(10));
        // System.out.println(new Fib().getFib(50));
    }

    private int getFib(int i) {
        if (i == 1 || i == 0)
            return 1;
        return getFib(i - 1) + getFib(i - 2);
    }

}
