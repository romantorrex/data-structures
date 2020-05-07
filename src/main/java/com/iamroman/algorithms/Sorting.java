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

  public static void bubbleSort(int[] array) {
    boolean sorted = false;

    while (!sorted) {
      sorted = true;
      for (int i = 0; i < array.length - 1; i++) {
        if (array[i] > array[i + 1]) {
          swap(array, i, i + 1);
          sorted = false;
        }
      }
    }
  }

  private static void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
