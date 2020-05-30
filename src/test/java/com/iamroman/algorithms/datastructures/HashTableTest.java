package com.iamroman.algorithms.datastructures;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class HashTableTest {
  private HashTable hashTable;

  @Before
  public void setUp() {
    hashTable = new HashTable();
  }

  @Test
  public void put() {
    hashTable.put("price", 200);

    assertThat(hashTable.size()).isEqualTo(1);
    assertThat(hashTable.toString()).isEqualTo("[{price:200}]");
  }

  @Test
  public void put_duplicated() {
    hashTable.put("age", 25);
    hashTable.put("age", 32);

    assertThat(hashTable.size()).isEqualTo(1);
    assertThat(hashTable.toString()).isEqualTo("[{age:32}]");
  }

  @Test
  public void get() {
    hashTable.put("count", 10);

    assertThat(hashTable.get("count")).isEqualTo(10);
  }

  @Test
  public void get_keyDoesNotExist_returnsNull() {
    assertThat(hashTable.get("item")).isNull();
  }

  @Test
  public void toString_empty() {
    assertThat(hashTable.toString()).isEqualTo("[]");
  }
}
