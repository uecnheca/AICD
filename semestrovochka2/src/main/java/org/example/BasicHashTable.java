package org.example;

public class BasicHashTable<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private Entry<K, V>[] table;
    private int size;
    private final float loadFactor;
    private int threshold;


    private static class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }


    public BasicHashTable() {
        this.table = new Entry[DEFAULT_CAPACITY];
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        this.threshold = (int)Math.min(table.length * loadFactor, Integer.MAX_VALUE - 8 + 1);
    }


    public V put(K key, V value) {
        if (key == null) {
            throw new NullPointerException("Key cannot be null");
        }

        int hash = hash(key);
        int index = indexFor(hash, table.length);

        for (Entry<K, V> e = table[index]; e != null; e = e.next) {
            if (e.key.equals(key)) {
                V oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }

        addEntry(key, value, index);
        return null;
    }

    public V get(K key) {
        if (key == null) {
            throw new NullPointerException("Key cannot be null");
        }

        int hash = hash(key);
        int index = indexFor(hash, table.length);

        for (Entry<K, V> e = table[index]; e != null; e = e.next) {
            if (e.key.equals(key)) {
                return e.value;
            }
        }

        return null;
    }

    public V remove(K key) {
        if (key == null) {
            throw new NullPointerException("Key cannot be null");
        }

        int hash = hash(key);
        int index = indexFor(hash, table.length);
        Entry<K, V> prev = table[index];
        Entry<K, V> e = prev;

        while (e != null) {
            Entry<K, V> next = e.next;
            if (e.key.equals(key)) {
                if (prev == e) {
                    table[index] = next;
                } else {
                    prev.next = next;
                }
                size--;
                return e.value;
            }
            prev = e;
            e = next;
        }

        return null;
    }


    private int hash(K key) {
        return key.hashCode();
    }

    private int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

    private void addEntry(K key, V value, int bucketIndex) {
        Entry<K, V> e = table[bucketIndex];
        table[bucketIndex] = new Entry<>(key, value, e);

        if (size++ >= threshold) {
            resize(2 * table.length);
        }
    }


    private void resize(int newCapacity) {
        Entry<K, V>[] oldTable = table;
        int oldCapacity = oldTable.length;

        Entry<K, V>[] newTable = new Entry[newCapacity];
        transfer(newTable);
        table = newTable;
        threshold = (int)(newCapacity * loadFactor);
    }

    private void transfer(Entry<K, V>[] newTable) {
        Entry<K, V>[] src = table;
        int newCapacity = newTable.length;

        for (int j = 0; j < src.length; j++) {
            Entry<K, V> e = src[j];
            if (e != null) {
                src[j] = null;
                do {
                    Entry<K, V> next = e.next;
                    int i = indexFor(hash(e.key), newCapacity);
                    e.next = newTable[i];
                    newTable[i] = e;
                    e = next;
                } while (e != null);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        boolean firstEntry = true;

        for (int i = 0; i < table.length; i++) {
            Entry<K, V> current = table[i];
            while (current != null) {
                if (!firstEntry) {
                    sb.append(", ");
                }
                sb.append(current.key).append("=").append(current.value);
                firstEntry = false;
                current = current.next;
            }
        }

        sb.append("}");
        return sb.toString();
    }
}