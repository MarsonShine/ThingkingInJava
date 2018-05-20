package exercise.containers;

import java.util.*;

import static java.util.Collections.binarySearch;
import static net.mindview.util.Println.print;

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
        checkForNull(fromElement);
        checkForNull(toElement);
        var fromIndex = list.indexOf(fromElement);
        var toIndex = list.indexOf(toElement);
        checkForValidIndex(fromIndex);
        checkForValidIndex(toIndex);
        try{
            return new CustomSortedSet<T>(
                    list.subList(fromIndex,toIndex)
            );
        }catch(IndexOutOfBoundsException e){
            throw new IllegalArgumentException(e);
        }
    }


    @Override
    public SortedSet<T> headSet(T toElement) {
        checkForNull(toElement);
        var toIndex = list.indexOf(toElement);
        checkForValidIndex(toIndex);
        try{
            return new CustomSortedSet<T>(
                    list.subList(0,toIndex)
            );
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public SortedSet<T> tailSet(T fromElement) {
        checkForNull(fromElement);
        var fromIndex = list.indexOf(fromElement);
        checkForValidIndex(fromIndex);
        try{
            return new CustomSortedSet<>(
                    list.subList(fromIndex,list.size())
            );
        }catch (IndexOutOfBoundsException e){
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public T first() {
        try{
            return list.get(0);
        }catch(IndexOutOfBoundsException e){
            throw new NoSuchElementException();
        }
    }

    @Override
    public T last() {
        try{
            return list.get(list.size()-1);
        }catch(IndexOutOfBoundsException e){
            throw new NoSuchElementException();
        }
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
        checkForNull(c);
        checkForNullElements(c);
        return list.removeAll(c);
    }

    @Override
    public void clear() {
        list.clear();
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
    private void checkForValidIndex(int fromIndex) {
        if(fromIndex == -1)
            throw new IllegalArgumentException();
    }
}

public class E10_CustomSortedSet {
    public static void main(String[] args){
        SortedSet<String> sortedSet =
                new CustomSortedSet<String>();
        Collections.addAll(sortedSet,"one two three four five six seven eight".split(" "));
        print(sortedSet);
        var low = sortedSet.first();
        var high = sortedSet.last();
        print(low);
        print(high);
        var it = sortedSet.iterator();
        for (var i=0;i<=6;i++){
            if(i == 3) low = it.next();
            if(i==6) high = it.next();
            else it.next();
        }
        print(low);
        print(high);
        print(sortedSet.subSet(low, high));
        print(sortedSet.headSet(high));
        print(sortedSet.tailSet(low));
        print(sortedSet.contains("three"));
        print(sortedSet.contains("eleven"));
        print(sortedSet.addAll(Arrays.asList(
                "three", "eleven")));
        print(sortedSet);
        print(sortedSet.retainAll(Arrays.asList(
                "three", "eleven")));
        print(sortedSet);
        // Demonstrate data integrity
        try {
            sortedSet.addAll(Arrays.asList("zero", null));
        } catch(NullPointerException e) {
            System.out.println("Null elements not supported!");
        }
        // The set will not contain "zero"!
        print(sortedSet);
    }
}
