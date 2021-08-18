package com.iamroman.algorithms.challenges;

/** Solutions to most common code challenges related to Strings. */
public final class Strings {

  /**
   * Returns {@code true} if the given {@code word} is the same backward as forward. Returns {@code
   * false} otherwise.
   */
  public static boolean isPalindrome(String word) {
    int i = 0;
    int j = word.length() - 1;
    while (i < j) {
      if (word.charAt(i++) != word.charAt(j--)) {
        return false;
      }
    }
    return true;
  }

  private Strings() {}
}
