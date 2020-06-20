package com.iamroman.algorithms.datastructures;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PriorityQueueTest {
  PriorityQueue queue = new PriorityQueue();

  @Test
  public void enqueue() {
    queue.enqueue(5);
    queue.enqueue(9);
    queue.enqueue(6);
    queue.enqueue(2);
    queue.enqueue(0);

    assertThat(queue.size()).isEqualTo(5);
    assertThat(queue.peek()).isEqualTo(0);
  }

  @Test
  public void dequeue() {
    queue.enqueue(9);
    queue.enqueue(5);
    queue.enqueue(10);
    queue.enqueue(1);
    queue.enqueue(0);
    queue.enqueue(11);

    assertThat(queue.dequeue()).isEqualTo(0);
    assertThat(queue.size()).isEqualTo(5);
    assertThat(queue.dequeue()).isEqualTo(1);
    assertThat(queue.size()).isEqualTo(4);
    assertThat(queue.dequeue()).isEqualTo(5);
    assertThat(queue.size()).isEqualTo(3);
    assertThat(queue.dequeue()).isEqualTo(9);
    assertThat(queue.size()).isEqualTo(2);
  }
}
