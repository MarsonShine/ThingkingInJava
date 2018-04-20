package performance;

public class Stopwatch {
    private long startTime;
    private long endTime;
    public void start(){
        startTime = System.currentTimeMillis();
    }
    public void end(){
        endTime = System.currentTimeMillis();
    }
    public void restart(){
        startTime = System.currentTimeMillis();
    }
    public long ElapsedMilliseconds(){
        return endTime - startTime;
    }
}
