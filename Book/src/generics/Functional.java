package generics;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static net.mindview.util.Println.print;

//不同类型的函数对象
interface Combiner<T> {
    T combine(T x, T y);
}

interface UnaryFunction<R, T> {
    R function(T x);
}

interface Collector<T> extends UnaryFunction<T, T> {
    T result(); //提取集合参数类型的结果
}

interface UnaryPredicate<T> {
    boolean test(T x);
}

public class Functional {
    //在每一个元素节点上调用Combiner对象去计算并最终返回结果
    public static <T> T reduce(Iterable<T> seq,Combiner<T> combiner){
        Iterator<T> it = seq.iterator();
        if(it.hasNext()){
            T result = it.next();
            while (it.hasNext())
                result = combiner.combine(result,it.next());
            return result;
        }
        //如果队列是空的
        return null;
    }
    //在列表里每一个元素传递一个函数对象，并调用它，忽略返回的值
    //这个函数对象作为一个集合的参数，它最后会返回
    public  static <T> Collector<T> forEach(Iterable<T> seq,Collector<T> func){
        for (T t : seq)
            func.function(t);
        return func;
    }
    //通过在集合里调用函数对象生成一个集合的结果
    public static <R,T> List<R> transform(Iterable<T> seq, UnaryFunction<R,T> func){
        List<R> result = new ArrayList<>();
        for (T t:seq){
            result.add(func.function(t));
        }
        return result;
    }
    //给队列中每一个元素提供一个一元谓词表达式，并返回一个满足表达式（true）的集合
    public static <T> List<T> filter(Iterable<T> seq,UnaryPredicate<T> predicate){
        List<T> result = new ArrayList<>();
        for (T t : seq){
            if(predicate.test(t))
                result.add(t);
        }
        return result;
    }
    //使用下面的泛型方法，我们去新建一些满足我们特定需要的函数对象
    static class IntegerAdder implements Combiner<Integer>{
        @Override
        public Integer combine(Integer x, Integer y) {
            return x + y;
        }
    }
    static class IntegerSubstractter implements Combiner<Integer>{
        @Override
        public Integer combine(Integer x, Integer y) {
            return x - y;
        }
    }
    static class BigDecimalAdder implements Combiner<BigDecimal>{
        @Override
        public BigDecimal combine(BigDecimal x, BigDecimal y) {
            return x.add(y);
        }
    }
    static class BigIntegerAdder implements Combiner<BigInteger>{
        @Override
        public BigInteger combine(BigInteger x, BigInteger y) {
            return x.add(y);
        }
    }
    static class
    AtomicLongAdder implements Combiner<AtomicLong> {
        public AtomicLong combine(AtomicLong x, AtomicLong y) {
            // Not clear whether this is meaningful:
            return new AtomicLong(x.addAndGet(y.get()));
        }
    }
    // We can even make a UnaryFunction with an "ulp"
    // (Units in the last place):
    static class BigDecimalUlp
            implements UnaryFunction<BigDecimal,BigDecimal> {
        public BigDecimal function(BigDecimal x) {
            return x.ulp();
        }
    }
    static class GreaterThan<T extends Comparable<T>>
            implements UnaryPredicate<T> {
        private T bound;
        public GreaterThan(T bound) { this.bound = bound; }
        public boolean test(T x) {
            return x.compareTo(bound) > 0;
        }
    }
    static class MultiplyingIntegerCollector
            implements Collector<Integer> {
        private Integer val = 1;
        public Integer function(Integer x) {
            val *= x;
            return val;
        }
        public Integer result() { return val; }
    }

    public static void main(String[] args){
        List<Integer> li = Arrays.asList(1,2,3,4,5,6,7);
        Integer result = reduce(li,new IntegerSubstractter());
        print(result);

        result = reduce(li,new IntegerSubstractter());
        print(result);

        print(filter(li,new GreaterThan<>(4)));

        print(forEach(li,new MultiplyingIntegerCollector()).result());

        print(forEach(filter(li,new GreaterThan<>(4)),new MultiplyingIntegerCollector()).result());

        MathContext mc = new MathContext(7);
        List<BigDecimal> lbd = Arrays.asList(
                new BigDecimal(1.1,mc), new BigDecimal(2.2,mc),
                new BigDecimal(3.3,mc),new BigDecimal(4.4,mc)
        );
        BigDecimal rbd = reduce(lbd,new BigDecimalAdder());
        print(rbd);

        print(filter(lbd,new GreaterThan<>(new BigDecimal(3))));
        // Use the prime-generation facility of BigInteger:
        List<BigInteger> lbi = new ArrayList<BigInteger>();
        BigInteger bi = BigInteger.valueOf(11);
        for(int i = 0; i < 11; i++) {
            lbi.add(bi);
            bi = bi.nextProbablePrime();
        }
        print(lbi);

        BigInteger rbi = reduce(lbi, new BigIntegerAdder());
        print(rbi);
        // The sum of this list of primes is also prime:
        print(rbi.isProbablePrime(5));

        List<AtomicLong> lal = Arrays.asList(
                new AtomicLong(11), new AtomicLong(47),
                new AtomicLong(74), new AtomicLong(133));
        AtomicLong ral = reduce(lal, new AtomicLongAdder());
        print(ral);

        print(transform(lbd,new BigDecimalUlp()));
    }
}
