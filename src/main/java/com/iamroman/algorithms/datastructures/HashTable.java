package com.iamroman.algorithms.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A data structure that maps a {@code String} key to an {@code Integer} value.
 *
 * <p>Collisions are handled via chaining.
 */
public class HashTable {
  private List<Entry>[] buckets = new List[10];
  private int count = 0;

  /** Maps the given {@code key} to the given {@code value} in this hash table. */
  public void put(String key, Integer value) {
    List<Entry> bucket = getBucket(key);
    Entry entry = find(key, bucket);

    if (entry == null) {
      bucket.add(new Entry(key, value));
      count++;
    } else {
      entry.setValue(value);
    }
  }

  /**
   * Returns the value mapped to the given {@code key}, or null if the key is not mapped to any
   * value in this hash table.
   */
  public Integer get(String key) {
    List<Entry> bucket = getBucket(key);
    Entry entry = find(key, bucket);

    if (entry == null) {
      return null;
    }

    return entry.value;
  }

  /** Returns the number of keys in this hash table. */
  public int size() {
    return count;
  }

  // TODO: Add implementation for removing a key-value pair.
  @Override
  public String toString() {
    String items =
        Arrays.stream(buckets)
            .filter(i -> i != null)
            .flatMap(List::stream)
            .map(i -> i.toString())
            .collect(Collectors.joining(","));

    return String.format("[%s]", items);
  }

  private List<Entry> getBucket(String key) {
    int hashCode = hash(key);
    int index = hashCode % buckets.length;

    if (buckets[index] == null) {
      buckets[index] = new ArrayList<>();
    }

    return buckets[index];
  }

  private int hash(String key) {
    return key.length();
  }

  private Entry find(String key, List<Entry> list) {

    return list.stream().filter(entry -> entry.getKey().equals(key)).findFirst().orElse(null);
  }

  private static class Entry {
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

    @Override
    public String toString() {
      return String.format("{%s:%s}", key, value);
    }
  }
}
