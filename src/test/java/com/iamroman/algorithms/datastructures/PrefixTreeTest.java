package com.iamroman.algorithms.datastructures;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
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

  @Test
  public void findWords_success() {
    PrefixTree prefixTree = new PrefixTree();
    List<String> words = asList("car", "camera", "cartoon", "can", "color", "care", "careful");
    words.forEach(prefixTree::insert);

    assertThat(prefixTree.findWords("car")).containsOnly("car", "cartoon", "care", "careful");
    assertThat(prefixTree.findWords("care")).containsOnly("care", "careful");
    assertThat(prefixTree.findWords("co")).containsOnly("color");
  }

  @Test
  public void findWords_whenPrefixIsNotPresent_returnsEmptyList() {
    PrefixTree prefixTree = new PrefixTree();
    prefixTree.insert("car");
    prefixTree.insert("camera");
    prefixTree.insert("caffeine");

    assertThat(prefixTree.findWords("co")).isEmpty();
  }

  @Test
  public void findWords_whenPrefixIsEmptyString_returnsAllWords() {
    PrefixTree prefixTree = new PrefixTree();
    List<String> words = asList("car", "camera", "can", "color");
    words.forEach(prefixTree::insert);

    assertThat(prefixTree.findWords("")).containsAll(words);
  }
}
