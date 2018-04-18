import java.util.Iterator;
import static ms.util.Println.*;

public class CustomIterator implements Iterable<String> {

    protected String[] names = ("marson shine summer zhu").split(" ");

    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < names.length;
            }

            @Override
            public String next() {
                return names[index++];
            }

            public void remove() {

            }
        };
    }

    public static void main(String[] agrs) {
        for (var s : new CustomIterator()) {
            print(s + " ");
        }
    }
}
