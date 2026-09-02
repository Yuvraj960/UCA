
public class BalanceParWays {
    public long bpw(int n) {
        if (n < 2) return 1;
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += bpw(i) * bpw(n - i - 1);
        }
        return res;
    }

    public static void main(String[] args) {
        assert 1 == new BalanceParWays().bpw(0);
        assert 1 == new BalanceParWays().bpw(1);
        assert 2 == new BalanceParWays().bpw(2);
        assert 5 == new BalanceParWays().bpw(3);
        assert 14 == new BalanceParWays().bpw(4);

        for (int i = 5; i < 50; ) {
            System.out.println("bpw of " + i + " = " + new BalanceParWays().bpw(i));
            i += 5;
        }
    }
}
