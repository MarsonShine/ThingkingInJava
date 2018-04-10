package filters;

public class Waveform {
    private static long counter;
    private final long id = counter++;

    public String toString() {
        return "filters.Waveform " + id;
    }
}
