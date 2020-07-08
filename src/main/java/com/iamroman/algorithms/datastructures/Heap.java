package com.iamroman.algorithms.datastructures;

import java.util.Arrays;

/** Implementation of a binary max heap using an array */
public class Heap {
  private int[] items = new int[128];
  private int size = 0;

  public void insert(int item) {
    items[size++] = item;
    int child = size - 1;
    int parent = (child - 1) / 2;

    while (parent >= 0 && items[child] > items[parent]) {
      swap(parent, child);
      child = parent;
      parent = (child - 1) / 2;
    }
  }

  public int remove() {
    return 0;
  }

  @Override
  public String toString() {
    return Arrays.toString(Arrays.copyOf(items, size));
  }

  private void swap(int first, int second) {
    int temp = items[first];
    items[first] = items[second];
    items[second] = temp;
  }
}
