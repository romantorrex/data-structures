package com.iamroman.algorithms.datastructures;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

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

  @Test
  public void remove_success() {
    PrefixTree prefixTree = new PrefixTree();
    prefixTree.insert("car");
    prefixTree.insert("care");

    prefixTree.remove("car");
    assertThat(prefixTree.contains("care")).isTrue();
    assertThat(prefixTree.contains("car")).isFalse();
  }

  @Test
  public void remove_whenWordDoesNotExist_success() {
    PrefixTree prefixTree = new PrefixTree();
    prefixTree.insert("car");
    prefixTree.insert("care");

    prefixTree.remove("cat");
    assertThat(prefixTree.contains("car")).isTrue();
    assertThat(prefixTree.contains("care")).isTrue();
  }
}
