import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Snow {
}

class Powder extends Snow {
}

class Light extends Powder {
}

class Heavy extends Powder {
}

class Crusty extends Snow {
}

class Slush extends Snow {
}

public class AsListInterface {
    public static void main(String[] args) {
        List<Snow> snow1 = Arrays.asList(
                new Powder(), new Crusty(), new Slush()
        );
        //won't compile:
        //List<Snow> snow2 = Arrays.asList(new Light(),new Heavy())
        //Compiler says:
        //found: java.util.List<Powder>
        //required: java.util.List<Snow>
        //Collections.addAll() doesn't get confused:
        List<Snow> snow3 = new ArrayList<>();
        Collections.addAll(snow3,new Light(),new Heavy());
    }
}
