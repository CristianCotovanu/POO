package com.task1;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap<K, V> {
    List<MyEntry> entries;

    public MyHashMap() {
        entries = new ArrayList<>();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    private class MyEntry {
        K key;
        V value;

        MyEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(K key, V value) {
        MyEntry myEntry = new MyEntry(key, value);

        if (entries.contains(myEntry)) {
            return;
        }

        entries.add(myEntry);
    }

    public V get(K key) {
        for (MyEntry entry : entries) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        return null;
    }
}
