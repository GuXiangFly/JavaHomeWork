package cn.guxiangfly.hashmap;

/**
 * @author: xianggu@ebay.com
 * @date : 2018 9/4/18
 * @desc : JavaHomeWork
 */
public interface MyMap<K,V> {
    public V get(K k);
    public V put(K k,V v);
    interface Entry<K,V>{
        public K getKey();
        public V getValue();
    }
}