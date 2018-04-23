package net.mindview.util;

import javafx.util.Pair;
import typeinfo.pets.Pet;

import java.util.*;
import java.util.List;

public class MapData<K, V> extends LinkedHashMap<K, V> {
    //一个键值对生产着
    public MapData(Generator<Pair<K, V>> gen, int quanlity) {
        for (int i = 0; i < quanlity; i++) {
            Pair<K, V> p = gen.next();
            put(p.getKey(), p.getValue());
        }
    }

    //两个单独生成器
    public MapData(Generator<K> genK, Generator<V> genV,
                   int quanlity) {
        for (int i = 0; i < quanlity; i++) {
            put(genK.next(), genV.next());
        }
    }
    //一个键生成器 一个值
    public MapData(Generator<K> genK, V value, int quantity){
        for (int i = 0; i < quantity; i++) {
            put(genK.next(),value);
        }
    }

    // An Iterable and a value Generator:
    public MapData(Iterable<K> genK, Generator<V> genV) {
        for(K key : genK) {
            put(key, genV.next());
        }
    }
    // An Iterable and a single value:
    public MapData(Iterable<K> genK, V value) {
        for(K key : genK) {
            put(key, value);
        }
    }
    // Generic convenience methods:
    public static <K,V> MapData<K,V>
    map(Generator<Pair<K,V>> gen, int quantity) {
        return new MapData<K,V>(gen, quantity);
    }
    public static <K,V> MapData<K,V>
    map(Generator<K> genK, Generator<V> genV, int quantity) {
        return new MapData<K,V>(genK, genV, quantity);
    }
    public static <K,V> MapData<K,V>
    map(Generator<K> genK, V value, int quantity) {
        return new MapData<K,V>(genK, value, quantity);
    }
    public static <K,V> MapData<K,V>
    map(Iterable<K> genK, Generator<V> genV) {
        return new MapData<K,V>(genK, genV);
    }
    public static <K,V> MapData<K,V> map(Iterable<K> genK, V value) {
        return new MapData<K,V>(genK, value);
    }
}
