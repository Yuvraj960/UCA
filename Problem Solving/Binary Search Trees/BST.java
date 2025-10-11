public class BST<Key extends Comparable<Key>, Value> {
  private Node root;

  private class Node {
    Key key;
    Value val;
    Node left;
    Node right;

    Node(Key key, Value val) {
      this.key = key;
      this.val = val;
    }
  }

  // Min key
  public Key min() {
    if (root == null) return null; // Tree is empty
    Node x = root;
    while (x.left != null) {
        x = x.left;
    }
    return x.key;
  }

  // Max key
  public Key max() {
    if (root == null) return null; // Tree is empty
    Node x = root;
    while (x.right != null) {
        x = x.right;
    }
    return x.key;
  }
  
  // Floor - largest number just smaller than given
  public Key floor(Key key) {
    Node x = floor(root, key);
    if (x == null) return null;
    return x.key;
  }

  private Node floor(Node x, Key key) {
    if (x == null) return null;

    int cmp = key.compareTo(x.key);
    if (cmp == 0) return x; // Exact match
    if (cmp < 0) return floor(x.left, key); // Search left

    Node t = floor(x.right, key); // Search right
    if (t != null) return t;
    else return x;
  }
  
  // Ceil - Smallest number just greater than given
  public Key ceil(Key key) {
    Node x = ceil(root, key);
    if (x == null) return null;
    return x.key;
  }

  private Node ceil(Node x, Key key) {
    if (x == null) return null;

    int cmp = key.compareTo(x.key);
    if (cmp == 0) return x; // Exact match
    if (cmp > 0) return ceil(x.right, key); // Search right

    Node t = ceil(x.left, key); // Search left
    if (t != null) return t;
    else return x;
  }

  public int rank(Key key) {
    return 0;
  }

  // Get method
  public Value get(Key key) {
    return get(root, key);
  }
  
  private Value get(Node x, Key key) {
    if (x == null) return null;
    
    int cmp = key.compareTo(x.key);

    if (cmp == 0) return x.val;
    else if (cmp < 0) return get(x.left, key);
    else return get(x.right, key);
  }      
  
  // Put method
  public void put(Key key, Value val) {
    root = put(root, key, val);
  }
  
  private Node put(Node x, Key key, Value val) {
    if (x == null) return new Node(key, val);

    int cmp = key.compareTo(x.key);
    
    if (cmp == 0) x.val = val; //overrite the key
    else if (cmp < 0) x.left = put(x.left, key, val);
    else x.right = put(x.right, key, val);
    return x;
  }

  public static void main(String[] args) {
    BST<Integer, String> bst = new BST<Integer, String>();
    
    bst.put(5, "A");
    bst.put(1, "X");
    bst.put(3, "Y");
    bst.put(4, "Z");
    bst.put(7, "A");

    assert bst.get(5).equals("A") : "Test failed for key 5";
    assert bst.get(1).equals("X") : "Test failed for key 5";
    assert bst.get(3).equals("Y") : "Test failed for key 5";
    assert bst.get(4).equals("Z") : "Test failed for key 5";
    assert bst.get(7).equals("A") : "Test failed for key 5";
    assert bst.get(10) == null : "Test failed for key 10 , key missing";
    
    System.out.println("All test cases passed successfully");
    
  }
}