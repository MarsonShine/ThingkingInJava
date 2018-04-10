package interfaceprocessor;

import static ms.util.Println.*;

public class Apply {
    public static void process(Processor p, Object s) {
        print("Using filters.Processor " + p.name());
        print(p.process(s));
    }
}
