package interfaceprocessor;

import java.util.Arrays;

class Upcase extends StringProcessor {
    public String process(Object input) {
        return ((String) input).toUpperCase();
    }
}

class Downcase extends StringProcessor {

    public String process(Object input) {
        return ((String) input).toLowerCase();
    }
}

class Splitter extends StringProcessor {

    public String process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}
