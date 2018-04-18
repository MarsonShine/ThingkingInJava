import static ms.util.Println.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

public class ListIteration {
    public static void main(String[] args) {
        var names = Arrays.asList("marson", "shine", "summer", "zhu");
        var it = names.listIterator();
        while (it.hasNext()) {
            print(it.next() + ", " + it.nextIndex() + ", " + it.previousIndex() + "; ");
        }
        while (it.hasPrevious()) {
            print(it.previous() + " ");
        }
        print(names);

        it = names.listIterator(3);
        while (it.hasNext()) {
            it.next();
            it.set("alias");
        }
        print(names);
    }
}
