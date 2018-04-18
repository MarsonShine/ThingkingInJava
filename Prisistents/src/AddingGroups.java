import java.util.*;

public class AddingGroups {
    public static void main(String[] args) {
        Collection<Integer> collection =
                new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Integer[] moreInts = {6, 7, 8, 9, 10};
        collection.addAll(Arrays.asList(moreInts));
        //collection.addAll明显运行得很快
        // 但是不能像下面那样构造集合
        Collections.addAll(collection, 11, 12, 13, 14, 15);
        Collections.addAll(collection,moreInts);
        //produces a list "backed by" an array:
        List<Integer> list = Arrays.asList(16,17,18,19,20);//这种asList生成是数组，不能调整尺寸大小
        list.set(1,99); //修改一个元素节点
        //list.add(21); //运行时报错,因为underlying array canot be resized.
    }
}
