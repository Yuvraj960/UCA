/*
 * This is the Modified version of the Leetcode Question All O'One (Hard)
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class Wishlist {
  public static void main (String[] args) throws java.lang.Exception {
    ProductTracker pt = new ProductTracker();
    pt.wishlit("a");
    pt.wishlit("a");
    pt.wishlit("a");
    pt.wishlit("b");
    pt.wishlit("b");
    System.out.println("MAX : " + pt.getMaxProduct());
    System.out.println("MIN : " + pt.getMinProduct());

    pt.delist("a");
    pt.delist("a");
    System.out.println("MAX : " + pt.getMaxProduct());
    System.out.println("MIN : "  + pt.getMinProduct());

    pt.delist("a");
    pt.delist("a");

    System.out.println("MAX : " + pt.getMaxProduct());
    System.out.println("MIN : " + pt.getMinProduct());
  }
}

class ProductTracker {
  Map<String, Integer> productCounter;
  PriorityQueue<String> maxHeap;
  PriorityQueue<String> minHeap;

  public ProductTracker() {
    productCounter = new HashMap<>();
    maxHeap = new PriorityQueue<String>((a,b) -> {
      return Integer.compare(productCounter.getOrDefault(b, 0), productCounter.getOrDefault(a, 0));
    });

    minHeap = new PriorityQueue<String>((a,b)-> {
      return Integer.compare(productCounter.getOrDefault(a, 0), productCounter.getOrDefault(b, 0));
    });
  }

  public void wishlit(String productName) {
    if (productCounter.containsKey(productName)) {
      maxHeap.remove(productName); // logN
      minHeap.remove(productName); // logN
    }
    productCounter.merge(productName, 1, Integer::sum); // 0(1)
    maxHeap.add(productName); // logN 
    minHeap.add(productName); // logN
  }

  public void delist(String productName)  {
    if (productCounter.containsKey(productName)) {
      maxHeap.remove(productName); // logN
      minHeap.remove(productName); // logN
      int currCount = productCounter.merge(productName, -1, Integer::sum);
      if (currCount == 0) {
        productCounter.remove(productName);
      } else {
        maxHeap.add(productName); // logN
        minHeap.add(productName); // lo
      }
    }
  }

  public String getMaxProduct()  {
    return maxHeap.peek();
  }

  public String getMinProduct()  {
    return minHeap.peek();
  }
}
