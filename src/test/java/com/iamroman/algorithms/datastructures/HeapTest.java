package com.iamroman.algorithms.datastructures;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class HeapTest {

  private Heap heap = new Heap();

  @Test
  public void insert() {

    heap.insert(6);
    heap.insert(4);
    heap.insert(5);
    heap.insert(9);
    heap.insert(1);
    heap.insert(13);

    assertThat(heap.toString()).isEqualTo("[13, 6, 9, 4, 1, 5]");
  }
}
