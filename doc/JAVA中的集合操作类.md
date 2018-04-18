[TOC]

# JAVA中的集合容器操作类

Java容器类库总共分为两个概念：

1. Collection。标识所含元素的序列，这里面又包含多种集合类，比如List，Set，Queue；它们都有各自的特点，比如List是按顺序插入元素，Set是不重复元素集合，Queue则是典型的FIFO结构
2. Map。这是一个“键值对”的集合对象，允许你通过键来查找值。把你的键对象与值对象关联，映射起来；而Map又细分很多中集合，比如HashMap，TreeMap这其中的实现的数据结构又有所不同，所以其使用的功能场景也有所不同

## List集合

List是可以将元素维护在特定的序列中的集合。List继承自Collection类，并添加了属于自己大量的操作方法。具体有两种类型的List：

- ArrayList：由名字就可以看出是数组形式的数据结构，所以查询访问元素非常快（索引查询），但是添加或者删除元素时慢
- LinkedList：链表形式的数据结构，即查询是很慢（时间复杂度为O(n)），新增，删除数据是很快的

### ArrayList的操作方法说明

> 注意：这里讨论的集合都是泛型集合

- `subList(int fromIndex,int toIndex)`由原来的list构造从索引为fromIndex到toIndex之间的数据集合（包含fromIndex,toIndex）
- `set(int index,T element)`在指定的index位置出用指定元素element代替
- `addAll(collection<? extends E> c)`除了Collection.addAll，实例方法addAll也能在初始list中插入集合列表
- `add()`集合类中最常用的添加数据的方法
- `toArray()`创建一个具有合适尺寸的数组
- ...

### LinkedList

LinkedList也跟ArrayList一样实现了List接口，前面说了，它在删除和添加操作时（准确的讲是在中间插入）要比ArrayList更高效，但是访问要逊色于ArrayList。LinkedList还添加了使其用作栈、队列或双向链表的方法。他们彼此的方法也存在些许差异，所以在不同的List类型中用不同的方法操作集合是非常重要的。

- getFirst和element方法完全一样，都返回列表的头，而不移除它，如果List为空则抛出异常—NoSuchElementException。peek方法同样是返回列表的头并不移除它，但是List为空则返回null而不会抛出异常

  ------

  这有点像C#的Linq.FirstOrDefault与Linq.First的区别

- removeFirst与remove也是完全一样的，它们移除并返回列表的头部信息，而在列表为空是抛出NoSuchElementException异常。poll则列表为空是返回null

- addFirst与add和addLast相同，都将元素插入到列表尾部或头部

- removeLast移除并返回列表的最后一个元素

### Stack

栈，是指“LIFO”先进后出的集合容器，最后一个压入的元素是第一个出来的，就好比我们洗碗一样（或者叠罗汉）第一个摆放的碗放在最下面，自然是最后一个拿出来的。Stack是由LinkedList实现的，作为Stack的实现，下面是《java编程思想》给出基本的Stack实现：

```java
import java.util.LinkedList;
public class Stack<T> {
    private LinkedList<T> storage = new LinkedList<>();
    public void push(T v) {
        storage.addFirst(v);
    }
    public T peek() {
        return storage.getFirst();
    }
    public T pop() {
        return storage.removeFirst();
    }
    public boolean empty() {
        return storage.isEmpty();
    }
    public String toString() {
        return storage.toString();
    }
}
```

下面说一些方法的区别

peek和pop是返回T类型的对象。peek方法提供栈顶元素，但不删除栈顶，而pop是返回并删除栈顶元素;

### Set

Set是保存不重复的集合容器，Set经常被用作判断某元素是否在集合中存在，所以查找就成为最重要的操作，在内部，Set选择一个HashSet的实现，它专门对快速查找进行了优化。

Set具有与Collection完全一样的接口，没有额外的任何功能。所以把Set就是Collection，只是行为不同（这就是多态）；Set是基于对象的值来判断归属的，由于查询速度非常快速，HashSet使用了散列，HashSet维护的顺序与TreeSet或LinkedHashSet都不同，因为它们的数据结构都不同，元素存储方式自然也不同。TreeSet的数据结构是“红-黑树”，HashSet是散列函数，LinkedHashSet也用了散列函数；

> 如果想要对结果进行排序，那么选择TreeSet代替HashSet是个不错的选择

### Map

Map具有将对象映射到其他对象的功能，是一个K-V形式存储容器，你可以通过containsKey()和containsValue()来判断集合是否包含某个减或某个值。Map可以很容以拓展到多维（值可以是其他容器甚至是其他Map）：

`Map<Object,List<Object>>`

> 学C#的就知道，这就像字典基一样Dictionary<K,V>

### Queue

队列与栈相反，是个先进先出“FIFO”的容器。即第一个放进去就是第一个拿出来的元素（从一端进去，从另一端出来）。队列常作被当作一个可靠的将对象从程序的某个区域传输到另一个区域的途径。

LinkedList提供了方法以支持队列的行为，并且实现了Queue接口。通过LinkedList向上转型（up cast）为Queue，看Queue的实现就知道相对于LinkedList，Queue添加了element、offer、peek、poll、remove方法

offer：在允许的情况下，将一个元素插入到队尾，或者返回false

peek，element：在不移除的情况下返回队头，peek在队列为空返回null，element抛异常NoSuchElementException

poll,remove：移除并返回队头，poll当队列为空是返回null，remove抛出NoSuchElementException异常

*注意：queue.offer在自动包装机制会自动的把random.nextInt转化程Integer，把char转化成Character*

## 总结

Java内置了大量容器操作对象：

1. 数组，将数组与对象结合起来，数组一旦生成，容量就不允许修改
2. Collection保存单一的元素，Map保存的是K-V键值对形式的元素对象，可以在集合中添加元素并自动调整尺寸。容器不能持有基本类型，但是自动包装机制会执行基本类型到容器中所持有的类型之间的转换
3. List类似与数组，简历数字索引与对象的关联，都是排序好的容器，List能自动扩容
4. ArrayList擅长随机访问，要插入删除元素，LinkedList合适
5. Queue是LinkedList实现的
6. Map对象映射对象的关联设计。HashMap主要用来快速访问；TreeMap保持“键”始终处于排序状态，没有HashMap快。LinkedHashSet保持元素插入的顺序，但通过散列函数提供了快速访问的能力
7. Set可以用来去重，能提供最快的查询速度

Java还在处于初学阶段，还有很多知识面都还没有涉及到，等学到后面，又有新启发了，回过头来在补充

