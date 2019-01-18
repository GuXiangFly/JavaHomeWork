package cn.guxiangfly.hashmap;




import java.util.ArrayList;

/**
 * @author: xianggu@ebay.com
 * @date : 2018 9/4/18
 * @desc : JavaHomeWork
 */
public class MyHashMap<K, V> implements MyMap<K, V> {

    //在O（1） 的时间内取出数据
    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private int defaultIntSize;

    private float defaultLoadFactor;

    private int entryUseSize;
    /**
     * 这是java的
     */
    Entry<K, V>[] table = null;

    public MyHashMap() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int size, float factor) {

        if (size < 0) {
            throw new IllegalArgumentException();
        }
        if (factor < 0) {
            throw new IllegalArgumentException();
        }
        this.defaultIntSize = size;
        this.defaultLoadFactor = factor;

        table = new Entry[this.defaultIntSize];
    }

    private int hash(K k) {
        int h = k.hashCode();
        return (k == null) ? 0 : (h - k.hashCode()) ^ (h >>> 16);
    }

    public void resize(int i) {
        Entry[] newTable = new Entry[i];
        defaultIntSize = i;
        entryUseSize = 0;
        rehash(newTable);
    }

    private void rehash(Entry[] newTable) {
        ArrayList<Entry<K, V>> entryArrayList = new ArrayList<>();
        for (Entry<K, V> entry : table) {
            if (entry != null) {
                do {
                    entryArrayList.add(entry);
                    entry = entry.next;
                } while (entry != null);
            }
        }

        if (newTable.length>0){
            table = newTable;
        }
        for (Entry<K, V> entry : entryArrayList) {
            put(entry.getKey(),entry.getValue());
        }
    }

    @Override
    public V get(K k) {
        int index = hash(k)&(defaultIntSize-1);
        if (table[index] == null){
            return null;
        }else {
            Entry<K,V> entry =  table[index];
            do {
                if (k==entry.getKey()||k.equals(entry.getKey())){
                    return entry.value;
                }
                entry = entry.next;
            }while (entry!=null);
        }
        return null;
    }

    @Override
    public V put(K k, V v) {

        V oldValue = v;
        if (entryUseSize >= defaultIntSize * defaultLoadFactor) {
            resize(2 * defaultIntSize);
        }
        int index = hash(k) & (defaultIntSize - 1);
        if (table[index] == null) {
            table[index] = new Entry<K, V>(k, v, null);
            ++entryUseSize;
        } else {
            Entry<K, V> entry = table[index];
            Entry<K, V> e = entry;
            while (e != null) {
                if (k == e.getKey() || k.equals(e.getKey())) {
                    oldValue = e.value;
                    e.value = v;
                    return oldValue;
                }
                e = e.next;
            }
            table[index] = new Entry<K, V>(k, v, entry);
            ++entryUseSize;
        }
        return oldValue;
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        for (int i = 0; i < 200; i++) {
            myHashMap.put("key"+i,"value"+i);
        }

        for (int i = 0; i < 200; i++) {
            System.err.println(myHashMap.get("key"+i));
        }
    }

    class Entry<K, V> implements MyMap.Entry<K, V> {

        private K key;
        private V value;

        private Entry<K, V> next;

        public Entry() {

        }

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }
    }


}
