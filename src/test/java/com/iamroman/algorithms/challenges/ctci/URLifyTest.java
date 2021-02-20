package com.iamroman.algorithms.challenges.ctci;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class URLifyTest {

  @Test
  public void solution() {
    char[] url = "Mr John Smith    ".toCharArray();

    URLify.solution(url, 13);
    assertThat(new String(url)).isEqualTo("Mr%20John%20Smith");
  }
}
