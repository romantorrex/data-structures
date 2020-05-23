package com.iamroman.algorithms.challenges.ctci;

public class OneAway {
  public static boolean solution(String a, String b) {
    boolean replace = a.length() == b.length();
    if (b.length() > a.length()) {
      String temp = a;
      a = b;
      b = temp;
    }

    if (b.length() < a.length() - 1) {
      return false;
    }

    int differences = 0;
    int i = 0;
    int j = 0;

    while (differences <= 1 && i < a.length() && j < b.length()) {
      if (a.charAt(i) != b.charAt(j)) {
        differences++;
        if (!replace) {
          i++;
          continue;
        }
      }
      i++;
      j++;
    }

    return differences <= 1;
  }
}
