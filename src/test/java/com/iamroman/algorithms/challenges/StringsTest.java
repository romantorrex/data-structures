package com.iamroman.algorithms.challenges;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public final class StringsTest {

  @Test
  public void isPalindrome() {
    assertThat(Strings.isPalindrome("abba")).isTrue();
  }
}
