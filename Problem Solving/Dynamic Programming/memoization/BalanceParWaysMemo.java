
import java.util.HashMap;
import java.util.Map;

public class BalanceParWaysMemo {
    private Map<Integer, Long> memo = new HashMap<>();

    public long bpw(int n) {
        if (memo.containsKey(n)) return memo.get(n);
        if (n < 2) return 1;
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += bpw(i) * bpw(n - i - 1);
        }
        memo.put(n, res);
        return res;
    }

    public static void main(String[] args) {
        assert 1 == new BalanceParWaysMemo().bpw(0);
        assert 1 == new BalanceParWaysMemo().bpw(1);
        assert 2 == new BalanceParWaysMemo().bpw(2);
        assert 5 == new BalanceParWaysMemo().bpw(3);
        assert 14 == new BalanceParWaysMemo().bpw(4);

        for (int i = 5; i < 50; ) {
            System.out.println("bpw of " + i + " = " + new BalanceParWaysMemo().bpw(i));
            i += 5;
        }
    }
}
