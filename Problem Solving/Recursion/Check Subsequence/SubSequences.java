public class SubSequences {
  /**
   * If S and T are strings, we say that S is a subsequence of T if all
   * letters of S appear in T in the same order (not necessarily consecutively).
   * For example, "ace" is a subsequence of "abcde" while "aec" is not.
   * Given two strings S and T, checks whether S is a subsequence of T.
   * 
   * Constraints:
   * 1. Your solution should be recursive and not use any loops.
   * 2. 0 <= len(S), len(T) <= 1000
   * 3. Strings are case-sensitive and contain only English letters.
   *
   * @param S The subsequence string.
   * @param T The target string.
   * @return True if S is a subsequence of T, otherwise false.
   */
  public boolean isSubsequence(String S, String T) {
    return checkSubsequence(S, T, 0, 0);
  }

  /**
   * Recursively checks if S is a subsequence of T starting from given indices.
   * Compares characters one by one and makes recursive decisions.
   * 
   * @param S The subsequence string.
   * @param T The target string.
   * @param sIndex Current index in string S.
   * @param tIndex Current index in string T.
   * @return True if remaining part of S is subsequence of remaining part of T.
   */
  private boolean checkSubsequence(String S, String T, int sIndex, int tIndex) {
    // Base case: found all characters of S
    if (sIndex == S.length()) {
      return true;
    }
    
    // Base case: reached end of T but S is not complete
    if (tIndex == T.length()) {
      return false;
    }
    
    // If characters match, move both pointers
    if (S.charAt(sIndex) == T.charAt(tIndex)) {
      return checkSubsequence(S, T, sIndex + 1, tIndex + 1);
    }
    
    // If characters don't match, move only T pointer
    return checkSubsequence(S, T, sIndex, tIndex + 1);
  }

    /**
     * Main method for testing the SubSequences class.
     */
    public static void main(String[] args) {
        SubSequences subsequences = new SubSequences();
        assert subsequences.isSubsequence("ace", "abcde") == true : "Test case 1 failed";
        assert subsequences.isSubsequence("aec", "abcde") == false : "Test case 2 failed";
        assert subsequences.isSubsequence("", "abcde") == true : "Test case 3 failed";
        assert subsequences.isSubsequence("abc", "") == false : "Test case 4 failed";
        assert subsequences.isSubsequence("abc", "ahbgdc") == true : "Test case 5 failed";
        assert subsequences.isSubsequence("axc", "ahbgdc") == false : "Test case 6 failed";
    }
}