package interfaceprocessor;

public interface Processor {
    String name();

    default Object process(Object input) {
        return null;
    }
}
