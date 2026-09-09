
public class BalanceParWaysCatalan {

    public long bpw(int n) {
        if (n < 2) return 1;
        long[] tab = new long[n + 1];
        tab[0] = 1;
        tab[1] = 1;
        for (int i = 2; i <= n; i++) {
            tab[i] = (4L * i - 2) * tab[i - 1] / (i + 1);
        }
        return tab[n];
    }

    public static void main(String[] args) {
        assert 1 == new BalanceParWaysCatalan().bpw(0);
        assert 1 == new BalanceParWaysCatalan().bpw(1);
        assert 2 == new BalanceParWaysCatalan().bpw(2);
        assert 5 == new BalanceParWaysCatalan().bpw(3);
        assert 14 == new BalanceParWaysCatalan().bpw(4);

        for (int i = 5; i < 50; ) {
            System.out.println("bpw of " + i + " = " + new BalanceParWaysCatalan().bpw(i));
            assert new BalanceParWaysCatalan().bpw(i) == new BalanceParWaysMemo().bpw(i);
            i += 5;
        }
    }
}
