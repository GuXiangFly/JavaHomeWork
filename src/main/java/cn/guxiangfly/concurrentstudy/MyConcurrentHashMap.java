package cn.guxiangfly.concurrentstudy;

import java.io.Serializable;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: xianggu@ebay.com
 * @date : 2018 11/11/18
 * @desc : JavaHomeWork
 */
public class MyConcurrentHashMap {

    static final class HashEntry<K,V>{
        final int hash;
        final K key;
        volatile V value;

        volatile HashEntry<K,V> next;

        public HashEntry(int hash,K key,V value,HashEntry<K,V> next){
            this.hash=hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    static final class Segment<K,V> extends ReentrantLock implements Serializable{
        volatile HashEntry<K,V> table;
    }
}
