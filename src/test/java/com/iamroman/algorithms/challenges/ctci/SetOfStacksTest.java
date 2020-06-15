package com.iamroman.algorithms.challenges.ctci;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.NoSuchElementException;
import org.junit.Test;

public class SetOfStacksTest {
  private SetOfStacks stacks;

  @Test
  public void push_moreThanCapacity_success() {
    stacks = new SetOfStacks(/* capacityForEachStack= */ 2);

    stacks.push(1);
    stacks.push(2);
    stacks.push(3);
    stacks.push(4);
    stacks.push(5);

    assertThat(stacks.size()).isEqualTo(5);
  }

  @Test
  public void pop() {
    stacks = new SetOfStacks(2);
    stacks.push(6);
    stacks.push(5);
    stacks.push(4);

    assertThat(stacks.pop()).isEqualTo(4);
    assertThat(stacks.pop()).isEqualTo(5);
  }

  @Test
  public void popAt() {
    stacks = new SetOfStacks(2);
    stacks.push(1);
    stacks.push(2);
    stacks.push(3);
    stacks.push(4);
    stacks.push(5);

    assertThat(stacks.popAt(0)).isEqualTo(2);
    assertThat(stacks.popAt(1)).isEqualTo(4);
    assertThat(stacks.size()).isEqualTo(3);
  }

  @Test
  public void popAt_invalidIndex_throwsException() {
    stacks = new SetOfStacks(3);
    stacks.push(2);

    Throwable exception = catchThrowable(() -> stacks.popAt(2));

    assertThat(exception).isInstanceOf(NoSuchElementException.class);
  }

  @Test
  public void popAt_indexWithEmptyStack_throwsException() {
    stacks = new SetOfStacks(2);
    // set of 3 stacks with 2 items each
    stacks.push(1);
    stacks.push(2);
    stacks.push(3);
    stacks.push(4);
    stacks.push(5);
    stacks.push(6);

    assertThat(stacks.popAt(1)).isEqualTo(4);
    assertThat(stacks.popAt(1)).isEqualTo(3);
    // stack at idex 1 is already empty
    Throwable exception = catchThrowable(() -> stacks.popAt(1));
    assertThat(exception).isInstanceOf(NoSuchElementException.class);
  }
}
