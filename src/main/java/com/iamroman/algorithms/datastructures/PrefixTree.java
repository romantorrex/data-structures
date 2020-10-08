package com.iamroman.algorithms.datastructures;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;


public class PrefixTree {
  private Node root = new Node(' ');

  public void insert(String word) {
    Node current = root;

    for (char c : word.toCharArray()) {
      Node node = current.getChildWithValue(c);
      if (node == null) {
        node = new Node(c);
      }
      current.addChild(node);
      current = node;
    }

    current.setEndOfWord(true);
  }

  public void remove(String word) {
    remove(root, word, 0);
  }

  private static void remove(Node node, String word, int index) {
    if (index == word.length()) {
      node.setEndOfWord(false);
      return;
    }

    char ch = word.charAt(index);
    Node child = node.getChildWithValue(ch);
    if (child == null) {
      return;
    }
    remove(child, word, index + 1);

    if (!child.hasChildren() && !child.isEndOfWord()) {
      node.removeChild(ch);
    }
  }

  // TODO: Use a hash table for the children.
  public boolean contains(String word) {
    if (word == null) {
      return false;
    }

    Node current = root;
    for (char ch : word.toCharArray()) {
      if (!current.hasChildWithVallue(ch)) {
        return false;
      }

      current = current.getChildWithValue(ch);
    }

    return current.isEndOfWord();
  }

  public List<String> findWords(String prefix) {
    List<String> words = new ArrayList<>();
    Node lastNode = findLastNodeOf(prefix);
    findWords(lastNode, prefix, words);
    return words;
  }

  private Node findLastNodeOf(String prefix) {
    Node current = root;
    for (char ch : prefix.toCharArray()) {
      if (!current.hasChildWithVallue(ch)) {
        return null;
      }

      current = current.getChildWithValue(ch);
    }
    return current;
  }

  private static void findWords(Node node, String prefix, List<String> words) {
    if (node == null) {
      return;
    }

    if (node.isEndOfWord()) {
      words.add(prefix);
    }

    for (Node child : node.getChildren()) {
      findWords(child, prefix + child.getValue(), words);
    }
  }

  private class Node {
    private char value;
    private final Node[] children = new Node[26];
    private boolean endOfWord;
    private int childrenCount;

    public Node(char value) {
      this.value = value;
    }

    public char getValue() {
      return value;
    }

    public List<Node> getChildren() {
      return asList(children).stream().filter(n -> n != null).collect(toList());
    }

    public boolean isEndOfWord() {
      return endOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
      this.endOfWord = endOfWord;
    }

    public boolean hasChildWithVallue(char value) {

      return children[indexOf(value)] != null;
    }

    public Node getChildWithValue(char value) {
      return children[indexOf(value)];
    }

    public void addChild(Node child) {
      children[indexOf(child.getValue())] = child;
      childrenCount++;
    }

    @Override
    public String toString() {
      return String.format("(%s)", value);
    }

    private int indexOf(char letter) {
      return letter - 'a';
    }

    public boolean hasChildren() {
      return childrenCount > 0;
    }

    public void removeChild(char ch) {
      children[indexOf(ch)] = null;
      childrenCount--;
    }
  }
}
