package com.iamroman.algorithms;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class SearchingTest {

  @Test
  public void binarySearch_success() {
    var sortedArray = new int[] {3, 25, 33, 66, 70, 82, 99, 100};

    assertThat(Searching.binarySearch(sortedArray, 100)).isEqualTo(7);
    assertThat(Searching.binarySearch(sortedArray, 3)).isEqualTo(0);
    assertThat(Searching.binarySearch(sortedArray, 66)).isEqualTo(3);
    assertThat(Searching.binarySearch(sortedArray, 25)).isEqualTo(1);
    assertThat(Searching.binarySearch(sortedArray, 0)).isEqualTo(-1);
    assertThat(Searching.binarySearch(sortedArray, 69)).isEqualTo(-1);
    assertThat(Searching.binarySearch(sortedArray, 101)).isEqualTo(-1);
  }
}
