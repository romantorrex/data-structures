package com.iamroman.algorithms.challenges.ctci;

public class URLify {
  public static void solution(char[] url, int n) {
    int positions = url.length - n;

    int i = n - 1;
    while (positions > 0) {
      if (url[i] != ' ') {
        url[i + positions] = url[i];
        i--;
        continue;
      }

      positions -= 2;
      url[i + positions] = '%';
      url[i + positions + 1] = '2';
      url[i + positions + 2] = '0';
      i--;
    }
  }
}
