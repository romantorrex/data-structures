package com.iamroman.algorithms.datastructures;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MaxHeapTest {

  private MaxHeap maxHeap;

  @BeforeEach
  public void setUp() {
    maxHeap = new MaxHeap();
    maxHeap.insert(6);
    maxHeap.insert(4);
    maxHeap.insert(5);
    maxHeap.insert(9);
    maxHeap.insert(1);
    maxHeap.insert(13);
  }

  @Test
  public void insert() {
    assertThat(maxHeap.toString()).isEqualTo("[13, 6, 9, 4, 1, 5]");
  }

  @Test
  public void remove() {
    assertThat(maxHeap.remove()).isEqualTo(13);
    assertThat(maxHeap.toString()).isEqualTo("[9, 6, 5, 4, 1]");

    assertThat(maxHeap.remove()).isEqualTo(9);
    assertThat(maxHeap.toString()).isEqualTo("[6, 4, 5, 1]");

    assertThat(maxHeap.remove()).isEqualTo(6);
    assertThat(maxHeap.toString()).isEqualTo("[5, 4, 1]");
  }

  @Test
  public void heapify_success() {
    int[] array = {3, 6, 0, 10, 4, 2, 1};

    MaxHeap.heapify(array);
    assertThat(array).containsExactly(10, 6, 2, 3, 4, 0, 1);
  }
}
