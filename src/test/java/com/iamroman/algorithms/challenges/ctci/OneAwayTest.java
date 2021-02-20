package com.iamroman.algorithms.challenges.ctci;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OneAwayTest {

  @Test
  public void solution() {
    Assertions.assertThat(OneAway.solution("pale", "ple")).isTrue();
    assertThat(OneAway.solution("pales", "pale")).isTrue();
    assertThat(OneAway.solution("pale", "bale")).isTrue();
    assertThat(OneAway.solution("pale", "bake")).isFalse();
  }
}
