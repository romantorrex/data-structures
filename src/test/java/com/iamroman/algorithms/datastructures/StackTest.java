package com.iamroman.algorithms.datastructures;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.NoSuchElementException;
import org.junit.Before;
import org.junit.Test;

public class StackTest {
  private Stack<String> stack;

  @Before
  public void setUp() {
    stack = new Stack();
  }

  @Test
  public void push_success() {
    stack.push("one");
    stack.push("two");

    assertThat(stack.size()).isEqualTo(2);
    assertThat(stack.peek()).isEqualTo("two");
  }

  @Test
  public void pop_success() {
    stack.push("x");
    stack.push("y");
    stack.push("z");

    assertThat(stack.pop()).isEqualTo("z");
  }

  @Test
  public void pop_whenStackIsEmpty_throwsException() {
    Throwable thrown = catchThrowable(() -> stack.pop());

    assertThat(thrown).isInstanceOf(NoSuchElementException.class);
  }

  @Test
  public void peek_success() {
    stack.push("x");
    stack.push("y");
    stack.push("z");

    assertThat(stack.peek()).isEqualTo("z");
  }

  @Test
  public void peek_afterPop_success() {
    stack.push("a");
    stack.push("b");
    stack.push("c");

    stack.pop();

    assertThat(stack.peek()).isEqualTo("b");
  }

  @Test
  public void peek_whenStackIsEmpty_throwsException() {
    Throwable thrown = catchThrowable(() -> stack.peek());

    assertThat(thrown).isInstanceOf(NoSuchElementException.class);
  }

  @Test
  public void size_success() {
    assertThat(stack.size()).isEqualTo(0);

    stack.push("1");
    stack.push("2");
    stack.push("3");
    stack.push("4");

    assertThat(stack.size()).isEqualTo(4);
  }
}
