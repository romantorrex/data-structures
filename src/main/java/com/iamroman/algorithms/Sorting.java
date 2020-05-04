package com.iamroman.algorithms;

public abstract class Sorting {

  public static void insertionSort(int[] data) {
    for (int i = 1; i < data.length; i++) {
      int position = i;
      int value = data[i];

      while (position > 0 && data[position - 1] > value) {
        data[position] = data[position - 1];
        position--;
      }

      data[position] = value;
    }
  }
}
