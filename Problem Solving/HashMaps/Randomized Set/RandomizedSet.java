import java.util.*;

/**
 * RandomizedSet provides insert, remove, and getRandom operations in average constant time.
 * Uses HashMap for O(1) lookup and ArrayList for O(1) random access.
 */
public class RandomizedSet {
  private Map<Integer, Integer> map;
  private List<Integer> list;
  private Random rand;

  /**
   * Constructs an empty RandomizedSet.
   */
  public RandomizedSet() {
    map = new HashMap<>();
    list = new ArrayList<>();
    rand = new Random();
  }

  /**
   * Inserts a value to the set. Returns true if the set did not already contain the specified element.
   *
   * @param val the value to insert
   * @return true if inserted, false if already present
   */
  public boolean insert(int val) {
    if (map.containsKey(val)) {
      return false;
    }
    list.add(val);
    map.put(val, list.size() - 1);
    return true;
  }

  /**
   * Removes a value from the set. Returns true if the set contained the specified element.
   *
   * @param val the value to remove
   * @return true if removed, false if not present
   */
  public boolean remove(int val) {
    if (!map.containsKey(val)) {
      return false;
    }
    int idx = map.get(val);
    int lastVal = list.get(list.size() - 1);

    list.set(idx, lastVal);
    map.put(lastVal, idx);

    list.remove(list.size() - 1);
    map.remove(val);

    return true;
  }

  /**
   * Gets a random element from the set.
   *
   * @return a random element
   */
  public int getRandom() {
    int idx = rand.nextInt(list.size());
    return list.get(idx);
  }

  /**
   * Main method to test RandomizedSet functionality with 5 test cases including edge cases.
   */
  public static void main(String[] args) {
    RandomizedSet set = new RandomizedSet();

    // Test case 1: Insert and check return value
    assert set.insert(10) : "Insert 10 should return true";
    assert !set.insert(10) : "Insert duplicate 10 should return false";

    // Test case 2: Remove and check return value
    assert set.remove(10) : "Remove 10 should return true";
    assert !set.remove(10) : "Remove non-existent 10 should return false";

    // Test case 3: Insert multiple and getRandom
    set.insert(20);
    set.insert(30);
    set.insert(40);
    int randVal = set.getRandom();
    assert (randVal == 20 || randVal == 30 || randVal == 40) : "getRandom should return one of the inserted values";

    // Test case 4: Remove last element and getRandom edge case
    set.remove(40);
    randVal = set.getRandom();
    assert (randVal == 20 || randVal == 30) : "After removing 40, getRandom should return 20 or 30";

    // Test case 5: Edge case - getRandom on single element
    set.remove(30);
    randVal = set.getRandom();
    assert (randVal == 20) : "After removing all but 20, getRandom should return 20";

    System.out.println("All test cases passed.");
  }
}
