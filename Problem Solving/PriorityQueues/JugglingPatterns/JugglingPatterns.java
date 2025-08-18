import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Main Juggling Pattern Class defining all the main functions to solve the problem.
*/

public class JugglingPatterns {
  /**
   * Main Function.
   *
   * @params String[] args.
  */
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextLine()) {
      String pattern = sc.nextLine().trim();
      if (pattern.isEmpty()) {
        continue; // Skip empty lines
      }
      String result = validatePattern(pattern);
      System.out.println(pattern + ": " + result);
    }
    sc.close();
  }

  /**
   * Validates a juggling siteswap pattern.
   *
   * @param pattern The string of digits representing the pattern.
   * @return A string indicating if the pattern is valid, invalid due to ball count,
   *     or invalid due to throw/catch collisions.
  */
  private static String validatePattern(String pattern) {
    int n = pattern.length();
    int sum = 0;
    for (char c : pattern.toCharArray()) {
      sum += (c - '0');
    }

    // 1. Check if the average number of balls is an integer.
    // If the sum of throws is not perfectly divisible by the pattern length,
    // the number of balls is not an integer.
    if (sum % n != 0) {
      return "invalid # of balls";
    }
    int balls = sum / n;

    // 2. Check for collisions using a PriorityQueue as requested.
    // A collision occurs if two different throws land at the same time (modulo n).
    PriorityQueue<Integer> landingTimes = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      int throwHeight = pattern.charAt(i) - '0';
      int landingSite = (i + throwHeight) % n;
      landingTimes.add(landingSite);
    }

    // 3. Check for duplicates by polling from the sorted queue.
    // If two consecutive elements are the same, it means there's a collision.
    if (landingTimes.isEmpty()) {
      // An empty pattern is technically valid with 0 balls.
      return "valid with " + balls + " balls";
    }

    int previousSite = landingTimes.poll();
    while (!landingTimes.isEmpty()) {
      int currentSite = landingTimes.poll();
      if (currentSite == previousSite) {
        return "invalid pattern"; // Collision detected!
      }
      previousSite = currentSite;
    }

    // If we get here, all landing sites were unique. The pattern is valid.
    return "valid with " + balls + " balls";
  }
}
