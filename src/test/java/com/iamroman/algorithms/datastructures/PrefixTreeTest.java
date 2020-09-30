package com.iamroman.algorithms.datastructures;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrefixTreeTest {

  @Test
  public void contains() {
    PrefixTree prefixTree = new PrefixTree();
    prefixTree.insert("cantine");

    assertThat(prefixTree.contains("cantine")).isTrue();
    assertThat(prefixTree.contains("can")).isFalse();
  }

  @Test
  public void contains_whenWordIsNull_returnsFalse() {
    PrefixTree prefixTree = new PrefixTree();

    assertThat(prefixTree.contains(null)).isFalse();
  }
}
