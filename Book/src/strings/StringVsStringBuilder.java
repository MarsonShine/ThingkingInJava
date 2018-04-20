package strings;

import performance.Stopwatch;

public class StringVsStringBuilder {
    protected static final String INIT_STRING = "132";

    public static void main(String[] args) {
        var sw = new Stopwatch();
        sw.restart();
        var sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(INIT_STRING);
        }
        sw.end();
        System.out.println("StringBuilder 运行时间：" + sw.ElapsedMilliseconds() + " ms");

        sw.start();
        var str = "";
        for (int i = 0; i < 10; i++) {
            str += INIT_STRING;
        }
        sw.end();
        System.out.println("String + 运行时间：" + sw.ElapsedMilliseconds() + " ms");


    }
}
