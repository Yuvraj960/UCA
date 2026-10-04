
public class BalanceParWaysTab {

    public long bpw(int n) {
        if(n<2) return 1;
        long[] tab = new long[n+1];
        tab[0] = 1;
        tab[1] = 1;
        for (int i = 2; i <= n; i++) {
            long res = 0;
            for (int j = 0; j < i; j++) {
                res += tab[j] * tab[i - 1 - j];
            }
            tab[i] = res;
        }
        return tab[n];
    }

    public static void main(String[] args) {
        assert 1 == new BalanceParWaysTab().bpw(0);
        assert 1 == new BalanceParWaysTab().bpw(1);
        assert 2 == new BalanceParWaysTab().bpw(2);
        assert 5 == new BalanceParWaysTab().bpw(3);
        assert 14 == new BalanceParWaysTab().bpw(4);

        for (int i = 5; i < 50; ) {
            System.out.println("bpw of " + i + " = " + new BalanceParWaysTab().bpw(i));
            assert new BalanceParWaysTab().bpw(i) == new BalanceParWaysMemo().bpw(i);
            i += 5;
        }
    }
}
