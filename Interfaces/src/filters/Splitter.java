package filters;

import java.util.Arrays;

public class Splitter extends  Processor {
    String process(Object input){
        return Arrays.toString(((String)input).split(" "));
    }
}
