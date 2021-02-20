package com.iamroman.algorithms.challenges.ctci;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class TwoStackQueueTest {
  private TwoStackQueue<String> queue = new TwoStackQueue();

  @Test
  public void enqueue() {
    queue.enqueue("a");
    queue.enqueue("a");
    queue.enqueue("a");

    assertThat(queue.peek()).isEqualTo("a");
    assertThat(queue.size()).isEqualTo(3);
  }

  @Test
  public void dequeue() {
    queue.enqueue("1");
    queue.enqueue("2");
    queue.enqueue("3");

    assertThat(queue.dequeue()).isEqualTo("1");
    assertThat(queue.size()).isEqualTo(2);
    assertThat(queue.dequeue()).isEqualTo("2");
    assertThat(queue.size()).isEqualTo(1);

    queue.enqueue("4");
    assertThat(queue.dequeue()).isEqualTo("3");
    assertThat(queue.size()).isEqualTo(1);
    assertThat(queue.dequeue()).isEqualTo("4");
    assertThat(queue.size()).isEqualTo(0);
  }
}
