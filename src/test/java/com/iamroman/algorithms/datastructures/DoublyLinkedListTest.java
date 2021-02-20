package com.iamroman.algorithms.datastructures;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.jupiter.api.Test;

public class DoublyLinkedListTest {
  private DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

  @Test
  public void addLast_whenListIsEmpty() {
    list.addLast(10);

    assertThat(list.size()).isEqualTo(1);
    assertThat(list.toString()).isEqualTo("[10]");
  }

  @Test
  public void addLast_whenListIsNotEmpty() {
    list.addLast(5);

    list.addLast(12);
    list.addLast(0);

    assertThat(list.size()).isEqualTo(3);
    assertThat(list.toString()).isEqualTo("[5, 12, 0]");
  }

  @Test
  public void addFirst_whenListIsEmpty() {
    list.addFirst(1);

    assertThat(list.size()).isEqualTo(1);
    assertThat(list.toString()).isEqualTo("[1]");
  }

  @Test
  public void addFirst_whenListIsNotEmpty() {
    list.addFirst(1);

    list.addFirst(0);
    list.addFirst(-1);
    assertThat(list.size()).isEqualTo(3);
    assertThat(list.toString()).isEqualTo("[-1, 0, 1]");
  }

  @Test
  public void removeFirst_whenListIsEmpty() {
    Throwable throwable = catchThrowable(() -> list.removeFirst());

    assertThat(throwable).isInstanceOf(IllegalStateException.class);
  }

  @Test
  public void removeFirst_whenListHasOneNode() {
    list.addFirst(10);

    int value = list.removeFirst();

    assertThat(value).isEqualTo(10);
    assertThat(list.size()).isEqualTo(0);
    assertThat(list.toString()).isEqualTo("[]");
  }

  @Test
  public void removeFirst_whenListHasManyNodes() {
    list.addLast(3);
    list.addLast(2);
    list.addLast(1);

    int value = list.removeFirst();

    assertThat(value).isEqualTo(3);
    assertThat(list.size()).isEqualTo(2);
    assertThat(list.toString()).isEqualTo("[2, 1]");
  }

  @Test
  public void removeLast_whenListIsEmpty_throwsException() {
    Throwable throwable = catchThrowable(() -> list.removeLast());

    assertThat(throwable).isInstanceOf(IllegalStateException.class);
  }

  @Test
  public void removeLast_whenListHasOneNode() {
    list.addFirst(10);

    int value = list.removeLast();

    assertThat(value).isEqualTo(10);
    assertThat(list.size()).isEqualTo(0);
    assertThat(list.toString()).isEqualTo("[]");
  }

  @Test
  public void removeLast_whenListHasManyNodes() {
    list.addLast(3);
    list.addLast(2);
    list.addLast(1);

    int value = list.removeLast();

    assertThat(value).isEqualTo(1);
    assertThat(list.size()).isEqualTo(2);
    assertThat(list.toString()).isEqualTo("[3, 2]");
  }
}
