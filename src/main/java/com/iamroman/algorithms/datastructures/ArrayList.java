package com.iamroman.algorithms.datastructures;

import java.util.Arrays;
import java.util.NoSuchElementException;

/** An implementation of a dynamic array of strings. */
public final class ArrayList {

  private String[] elements;
  private int count;

  private ArrayList(int capacity) {
    elements = new String[capacity];
    count = 0;
  }

  /** Creates an {@code ArrayList} with the given {@code initialCapacity}. */
  public static ArrayList withCapacity(int initialCapacity) {
    return new ArrayList(initialCapacity);
  }

  /** Returns the current size of this array. */
  public int size() {
    return count;
  }

  /**
   * Adds the {@code element} at the end of this array.
   *
   * <p>If the array is full, a new array is created with twice the length of the previous array.
   */
  public void insert(String element) {
    if (count == elements.length) {
      elements = Arrays.copyOf(elements, elements.length * 2);
    }
    elements[count++] = element;
  }

  /**
   * Returns the position, within this array, of the given {@code element}.
   *
   * @throws NoSuchElementException if the element does not exist within the array.
   */
  public int find(String element) {
    for (int i = 0; i < count; i++) {
      if (elements[i].equals(element)) {
        return i;
      }
    }

    throw new NoSuchElementException(
        String.format("Element %s does not exist within list", element));
  }

  /**
   * Removes the element located at the given {@code index} in this array.
   *
   * @throws IllegalArgumentException if the index is less than zero or greater that the current
   *     size of this array.
   */
  public String removeAt(int index) {
    if (index < 0 || index >= count) {
      throw new IllegalArgumentException(
          "Index has to be greater or equal than 0 but less that the current size.");
    }

    String element = elements[index];
    for (int j = index; j < count - 1; j++) {
      elements[j] = elements[j + 1];
    }
    count--;

    return element;
  }

  /** Returns the size of the longest string in this array. */
  public int maximum() {
    if (size() <= 0) {
      throw new IllegalStateException("Array is empty");
    }

    // the length of a string is not negative.
    int max = elements[0].length();
    for (int i = 1; i < count; i++) {
      if (elements[i].length() > max) {
        max = elements[i].length();
      }
    }

    return max;
  }

  /** Reverses the order of the elements contained in this array. */
  public void reverse() {
    for (int i = 0, j = count - 1; i < j; i++, j--) {
      String tempValue = elements[i];
      elements[i] = elements[j];
      elements[j] = tempValue;
    }
  }

  @Override
  public String toString() {
    return Arrays.toString(Arrays.copyOf(elements, count));
  }
}
