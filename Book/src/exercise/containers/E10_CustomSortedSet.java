package exercise.containers;

import java.util.*;

import static java.util.Collections.binarySearch;

/*
 * 使用LinkedList作为实现，定义自己的SortedSet
 */
class CustomSortedSet<T> implements SortedSet<T> {
    private final List<T> list;

    CustomSortedSet() {
        list = new LinkedList<>();
    }

    private CustomSortedSet(List<T> list) {
        this.list = list;
    }

    public String toString() {
        return list.toString();
    }

    @Override
    public Comparator<? super T> comparator() {
        return null;
    }

    @Override
    public SortedSet<T> subSet(T fromElement, T toElement) {
        return null;
    }

    @Override
    public SortedSet<T> headSet(T toElement) {
        return null;
    }

    @Override
    public SortedSet<T> tailSet(T fromElement) {
        return null;
    }

    @Override
    public T first() {
        return null;
    }

    @Override
    public T last() {
        return null;
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean contains(Object o) {
        checkForNull(o);
        return binarySearch((List<Comparable<T>>) list, (T) o) >= 0;
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return list.toArray(a);
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean add(T t) {
        checkForNull(t);
        var ip = binarySearch((List<Comparable<T>>) list, t);
        if (ip < 0) {
            ip = -(ip + 1);
            if(ip == list.size())
                list.add(t);
            else
                list.add(ip,t);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        checkForNull(o);
        return list.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        checkForNull(c);
        checkForNullElements(c);
        return list.containsAll(c);
    }


    @Override
    public boolean addAll(Collection<? extends T> c) {
        checkForNull(c);
        checkForNullElements(c);
        return list.addAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        checkForNull(c);
        checkForNullElements(c);
        return list.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    private void checkForNull(Object o) {
        if (o == null)
            throw new NullPointerException();
    }
    private void checkForNullElements(Collection<?> c) {
        for (var it = c.iterator();it.hasNext();){
            if (it.next() == null)
                throw new NullPointerException();
        }
    }
}

public class E10_CustomSortedSet {
}
