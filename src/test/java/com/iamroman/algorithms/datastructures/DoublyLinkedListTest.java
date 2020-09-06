package com.iamroman.algorithms.datastructures;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class DoublyLinkedListTest {
  DoublyLinkedList<Integer> list;

  @Test
  public void addLast_whenListIsEmpty() {
    list = new DoublyLinkedList<>();

    list.addLast(10);

    assertThat(list.size()).isEqualTo(1);
    assertThat(list.toString()).isEqualTo("[10]");
  }

  @Test
  public void addLast_whenListIsNotEmpty() {
    list = new DoublyLinkedList<>();
    list.addLast(5);

    list.addLast(12);
    list.addLast(0);

    assertThat(list.size()).isEqualTo(3);
    assertThat(list.toString()).isEqualTo("[5, 12, 0]");
  }
}
