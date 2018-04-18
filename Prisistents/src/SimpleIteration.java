import typeinfo.pets.Pet;

import java.util.*;
import static ms.util.Println.*;

public class SimpleIteration {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("marson", "shine", "summer", "zhu");
        Iterator<String> it = names.iterator();
        while(it.hasNext()){
            String s = it.next();
            print(s);
        }

        for (String s : names){
            print(s);
        }
        System.out.println();
        it = names.iterator();
        for (int i = 0; i < 2; i++) {
            it.next();
            it.remove();
        }
        print(names);
    }
}
