package net.mindview.util;

import java.util.HashSet;
import java.util.Set;

public class Sets {
    public static <T> Set<T> union(Set<T> a,Set<T> b){
        Set<T> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }
    public static <T> Set<T> intersection(Set<T> a,Set<T> b){
        Set<T> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }
    public static <T> Set<T> difference(Set<T> superset,Set<T> subset){
        Set<T> result = new HashSet<>(superset);
        result.removeAll(subset);
        return result;
    }
    //Reflexive -- everything not in the intersection:
    //除交集之外的所有元素
    public static <T> Set<T> complement(Set<T> a,Set<T> b){
        return difference(union(a,b),intersection(a,b));
    }
}
