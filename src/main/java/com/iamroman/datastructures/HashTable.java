package com.iamroman.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HashTable {
  private List<Entry>[] array = new List[10];
  private int count = 0;

  // TODO: Handle case when key already exists
  public void put(String key, int value) {
    int hashCode = hash(key);
    int index = hashCode % array.length;

    List<Entry> list = array[index];
    if (list == null) {
      list = new ArrayList();
      array[index] = list;
    }
    Entry entry = find(key, list);

    if (entry == null) {
      list.add(new Entry(key, value));
      count++;
    } else {
      entry.setValue(value);
    }
  }

  public Integer get(String key) {
    int hashCode = hash(key);
    int index = hashCode % array.length;

    List<Entry> bucket = array[index];
    if (bucket == null) {
      return null;
    }

    Entry entry = find(key, bucket);

    if (entry == null) {
      return null;
    }

    return entry.value;
  }

  private Entry find(String key, List<Entry> list) {

    return list.stream().filter(entry -> entry.getKey().equals(key)).findFirst().orElse(null);
  }

  public int size() {
    return count;
  }

  @Override
  public String toString() {
    String items =
        Arrays.stream(array)
            .filter(i -> i != null)
            .flatMap(List::stream)
            .map(i -> i.toString())
            .collect(Collectors.joining(","));

    return String.format("[%s]", items);
  }

  private int hash(String key) {
    return key.length();
  }
}

class Entry {
  String key;
  Integer value;

  Entry(String key, Integer value) {
    this.key = key;
    this.value = value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public String getKey() {
    return this.key;
  }

  public String toString() {
    return String.format("{%s:%s}", key, value);
  }
}
