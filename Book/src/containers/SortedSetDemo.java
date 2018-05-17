package containers;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

import static net.mindview.util.Println.*;

public class SortedSetDemo {
    public static void main(String[] args) {
        SortedSet<String> sortedSet = new TreeSet<>();
        Collections.addAll(sortedSet, "one two three four five six seven eight"
                .split(" "));
        print(sortedSet);
        var low = sortedSet.first();
        var high = sortedSet.last();
        print(low);
        print(high);
        var it = sortedSet.iterator();
        for (var i = 0; i <= 6; i++) {
            if (i == 3) low = it.next();
            if (i == 6) high = it.next();
            else print(i + "=" + it.next());
        }
        print(low);
        print(high);
        print(sortedSet.subSet(low, high));
        print(sortedSet.headSet(high));
        print(sortedSet.tailSet(low));
    }
}
