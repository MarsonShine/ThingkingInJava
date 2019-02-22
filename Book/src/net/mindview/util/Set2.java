package net.mindview.util;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class Set2 {
    protected static <T> Set<T> copy(Set<T> s){
        if(s instanceof EnumSet){
            return ((EnumSet)s).clone();
        }
        return new HashSet<>(s);
    }
}
