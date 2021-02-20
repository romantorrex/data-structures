package com.iamroman.algorithms.challenges.ctci;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StackMinTest {
  private StackMin stackMin;

  @BeforeEach
  public void setUp() {
    stackMin = StackMin.create();
  }

  @Test
  public void min_success() {
    stackMin.push(1);
    stackMin.push(15);
    stackMin.push(0);
    stackMin.push(9);

    assertThat(stackMin.min()).isEqualTo(0);
    assertThat(stackMin.peek()).isEqualTo(9);
    assertThat(stackMin.size()).isEqualTo(4);
  }

  @Test
  public void min_afterPop_success() {
    stackMin.push(13);
    stackMin.push(20);
    stackMin.push(5);
    assertThat(stackMin.min()).isEqualTo(5);

    int deletedData = stackMin.pop();
    assertThat(stackMin.min()).isEqualTo(13);
    assertThat(deletedData).isEqualTo(5);
    assertThat(stackMin.size()).isEqualTo(2);
    assertThat(stackMin.peek()).isEqualTo(20);
  }

  @Test
  public void min_oneElement_success() {
    stackMin.push(5);
    stackMin.push(3);
    stackMin.push(0);
    assertThat(stackMin.min()).isEqualTo(0);

    stackMin.pop();
    stackMin.pop();
    assertThat(stackMin.min()).isEqualTo(5);
    assertThat(stackMin.size()).isEqualTo(1);
  }

  @Test
  public void min_whenIsEmpty_throwsException() {
    Throwable thrown = catchThrowable(() -> stackMin.min());

    assertThat(thrown).isInstanceOf(NoSuchElementException.class);
  }
}
