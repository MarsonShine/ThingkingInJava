package generics;

import net.mindview.util.ThreeTuple;
import net.mindview.util.TwoTuple;

import static net.mindview.util.Tuple.tuple;

public class TupleTest2 {
    static TwoTuple<String,Integer> f() {
        return tuple("hi",47);
    }
    static TwoTuple f2(){return tuple("hi",47);}
//    static ThreeTuple<Amphibian,String,Integer> g(){
//        return tuple(new Vehicle(),"hi",47);
//    }
}
