package com.iamroman.algorithms.datastructures;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.NoSuchElementException;
import org.junit.Test;

public class QueueTest {
  private Queue<String> queue = new Queue<>();

  @Test
  public void enqueue_oneItem_success() {
    queue.enqueue("a");

    assertThat(queue.size()).isEqualTo(1);
    assertThat(queue.peek()).isEqualTo("a");
  }

  @Test
  public void enqueue_severalItems_success() {
    queue.enqueue("one");
    queue.enqueue("two");
    queue.enqueue("three");
    queue.enqueue("four");

    assertThat(queue.size()).isEqualTo(4);
    assertThat(queue.peek()).isEqualTo("one");
  }

  @Test
  public void dequeue_oneItem_success() {
    queue.enqueue("1");
    queue.enqueue("2");
    queue.enqueue("3");

    assertThat(queue.dequeue()).isEqualTo("1");
    assertThat(queue.size()).isEqualTo(2);
    assertThat(queue.peek()).isEqualTo("2");
  }

  @Test
  public void dequeue_whenQueueIsEmpty_throwsException() {
    Throwable thrown = catchThrowable(() -> queue.dequeue());

    assertThat(thrown).isInstanceOf(NoSuchElementException.class);
  }

  @Test
  public void peek_success() {
    queue.enqueue("first");
    queue.enqueue("second");
    queue.enqueue("third");
    queue.enqueue("fourth");

    assertThat(queue.peek()).isEqualTo("first");

    queue.dequeue();
    assertThat(queue.peek()).isEqualTo("second");
  }

  @Test
  public void peek_whenQueueIsEmpty_throwsException() {
    Throwable thrown = catchThrowable(() -> queue.peek());

    assertThat(thrown).isInstanceOf(NoSuchElementException.class);
  }
}
