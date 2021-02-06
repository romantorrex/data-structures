package com.iamroman.algorithms.datastructures;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.NoSuchElementException;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class LinkedListTest {
  private LinkedList<String> list;

  @Before
  public void setUp() {
    list = new LinkedList<>();
  }

  @Test
  public void add_oneItem_success() {
    list.add("one");

    assertThat(list.size()).isEqualTo(1);
  }

  @Test
  public void add_severalItems_success() {
    list.add("a");
    list.add("b");
    list.add("c");
    list.add("d");

    assertThat(list.size()).isEqualTo(4);
  }

  @Test
  public void indexOf_success() {
    list.add("w");
    list.add("x");
    list.add("y");
    list.add("z");

    assertThat(list.indexOf("z")).isEqualTo(3);
    assertThat(list.indexOf("w")).isEqualTo(0);
    assertThat(list.indexOf("y")).isEqualTo(2);
  }

  @Test
  public void indexOf_nonExistent_returnsMinusOne() {
    assertThat(list.indexOf("c")).isEqualTo(-1);
    list.add("a");
    list.add("b");
    assertThat(list.indexOf("c")).isEqualTo(-1);
  }

  @Test
  public void delete_firstItem_success() {
    list.add("1");
    list.add("4");
    list.add("0");

    list.delete("1");
    assertThat(list.size()).isEqualTo(2);
    assertThat(list.indexOf("1")).isEqualTo(-1);
  }

  @Test
  public void delete_lastItem_success() {
    list.add("0");
    list.add("5");
    list.add("9");

    list.delete("9");

    assertThat(list.size()).isEqualTo(2);
    assertThat(list.indexOf("9")).isEqualTo(-1);
  }

  @Test
  public void delete_middleItem_success() {
    list.add("4");
    list.add("5");
    list.add("0");
    list.add("10");
    list.add("1");

    list.delete("0");

    assertThat(list.size()).isEqualTo(4);
    assertThat(list.indexOf("0")).isEqualTo(-1);
  }

  @Test
  public void delete_duplicated_success() {
    list.add("a");
    list.add("a");
    list.add("b");

    list.delete("a");

    assertThat(list.size()).isEqualTo(1);
    assertThat(list.indexOf("a")).isEqualTo(-1);
    ;
  }

  @Test
  @Ignore // TODO: define the correct behaviour when the element to be deleted does not exist.
  public void delete_nonExistent_throwsException() {
    list.add("1");
    list.add("10");
    list.add("5");

    Throwable thrown = Assertions.catchThrowable(() -> list.delete("-1"));

    assertThat(thrown).isInstanceOf(NoSuchElementException.class);
  }
}
