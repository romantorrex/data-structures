package com.iamroman.algorithms.datastructures;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class HeapTest {

  private Heap heap;

  @Before
  public void setUp() {
    heap = new Heap();
    heap.insert(6);
    heap.insert(4);
    heap.insert(5);
    heap.insert(9);
    heap.insert(1);
    heap.insert(13);
  }

  @Test
  public void insert() {
    assertThat(heap.toString()).isEqualTo("[13, 6, 9, 4, 1, 5]");
  }

  @Test
  public void remove() {
    assertThat(heap.remove()).isEqualTo(13);
    assertThat(heap.toString()).isEqualTo("[9, 6, 5, 4, 1]");

    assertThat(heap.remove()).isEqualTo(9);
    assertThat(heap.toString()).isEqualTo("[6, 4, 5, 1]");

    assertThat(heap.remove()).isEqualTo(6);
    assertThat(heap.toString()).isEqualTo("[5, 4, 1]");
  }
}
