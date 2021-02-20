package com.iamroman.algorithms.datastructures;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/** List implementation with an aarray. */
public class ArrayListTest {

  @Test
  public void withCapacity_success() {
    ArrayList list = ArrayList.withCapacity(5);

    assertThat(list.size()).isEqualTo(0);
  }

  @Test
  public void insert_success() {
    ArrayList list = ArrayList.withCapacity(5);

    list.insert("one");
    assertThat(list.size()).isEqualTo(1);
  }

  @Test
  public void insert_whenCapacityIsFull_success() {
    ArrayList list = ArrayList.withCapacity(2);

    list.insert("one");
    list.insert("two");
    list.insert("three");
    list.insert("four");

    assertThat(list.size()).isEqualTo(4);
  }

  @Test
  public void find_success() {
    ArrayList list = ArrayList.withCapacity(5);

    list.insert("one");
    list.insert("two");
    list.insert("three");
    list.insert("four");
    list.insert("five");

    assertThat(list.find("four")).isEqualTo(3);
  }

  @Test
  public void find_whenElementDoesNotExist_throwsException() {
    ArrayList list = ArrayList.withCapacity(3);
    list.insert("one");
    list.insert("two");
    list.insert("three");

    Throwable thrown = catchThrowable(() -> list.find("four"));

    assertThat(thrown).isInstanceOf(NoSuchElementException.class);
  }

  @Test
  public void removeAt_success() {

    ArrayList list = ArrayList.withCapacity(3);
    list.insert("one");
    list.insert("two");
    list.insert("three");

    assertThat(list.removeAt(1)).isEqualTo("two");
    assertThat(list.size()).isEqualTo(2);
    assertThat(list.toString()).isEqualTo("[one, three]");
  }

  @Test
  public void removeAt_whenEmpty_throwsException() {
    ArrayList list = ArrayList.withCapacity(3);

    Throwable thrown = catchThrowable(() -> list.removeAt(2));

    assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void removeAt_whenIndexEqualToSize_throwsException() {
    ArrayList list = ArrayList.withCapacity(3);

    list.insert("one");
    list.insert("two");

    Throwable thrown = catchThrowable(() -> list.removeAt(2));

    assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void removeAt_whenIndexIsNegative_throwsException() {
    ArrayList list = ArrayList.withCapacity(3);

    list.insert("one");
    list.insert("two");

    Throwable thrown = catchThrowable(() -> list.removeAt(-1));

    assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void maximum_success() {
    ArrayList array = ArrayList.withCapacity(10);

    array.insert("aaab");
    array.insert("a");
    array.insert("");
    array.insert("bbbbb");
    array.insert("ba");

    assertThat(array.maximum()).isEqualTo(5);
  }

  // TODO add test to fail for maximum()

  @Test
  public void reverse() {
    ArrayList array = ArrayList.withCapacity(10);

    array.insert("one");
    array.insert("two");
    array.insert("three");

    array.reverse();
    assertThat(array.toString()).isEqualTo("[three, two, one]");
  }

  @Test
  public void reverse_singleElement() {
    ArrayList array = ArrayList.withCapacity(1);
    array.insert("one");

    array.reverse();
    assertThat(array.toString()).isEqualTo("[one]");
  }

  // TODO: Fix failing unit test.
  @Test
  @Disabled
  public void getKthLargestElement_success() {
    int[] numbers = {6, 2, 0, 15, 4, 20, 13};

    assertThat(MaxHeap.getKthLargestElement(numbers, 2)).isEqualTo(15);
    assertThat(MaxHeap.getKthLargestElement(numbers, 1)).isEqualTo(20);
    assertThat(MaxHeap.getKthLargestElement(numbers, 4)).isEqualTo(10);
  }
}
