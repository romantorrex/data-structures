package com.iamroman.algorithms.datastructures;

// TODO: Add methods addLast(), addFirst, removeLast(), removeFirst()
/**
 * A sequence of nodes in which each node has a reference to the next node in the list.
 *
 * <p>Each node can hold data of type {@code T}.
 */
public class LinkedList<T> {
  private Node<T> first;
  private int size = 0;

  /** Adds {@code element} to the end of this list. */
  public void add(T element) {
    Node<T> node = new Node<>(element);
    size++;
    if (first == null) {
      first = node;
      return;
    }

    Node<T> current = first;
    while (current.next != null) {
      current = current.next;
    }
    current.next = node;
  }

  /**
   * Returns the position of the {@code element} in this list or {@code -1} if the list does not
   * contain the element.
   */
  public int indexOf(T element) {
    int index = 0;
    Node<T> current = first;
    while (current != null) {
      if (element.equals(current.data)) {
        return index;
      }
      index++;
      current = current.next;
    }

    return -1;
  }

  /** Deletes all the occurrences of the given {@code element} from this list. */
  public void delete(T element) {
    while (first != null && element.equals(first.data)) {
      first = first.next;
      size--;
    }

    Node<T> previous = first;
    Node<T> current = first;
    while (current != null) {
      if (element.equals(current.data)) {
        previous.next = current.next;
        size--;
      } else {
        previous = current;
      }
      current = current.next;
    }
  }

  /** Returns the number of elements in this list. */
  public int size() {
    return size;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("[");
    Node<T> current = first;

    while (current != null) {
      sb.append(current.data + ", ");
      current = current.next;
    }

    // if the list has elements its necessary to remove the trailing  ", ".
    if (sb.length() > 2) sb.delete(sb.length() - 2, sb.length());

    sb.append("]");

    return sb.toString();
  }
}
