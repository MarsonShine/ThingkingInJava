package strings;

import performance.Stopwatch;

public class StringVsStringBuilder {
    protected static final String INIT_STRING = "abcdefghijklmn";

    public static void main(String[] args) {
        var sw = new Stopwatch();
        sw.start();
        var str = "";
        for (int i = 0; i < 1000; i++) {
            str += INIT_STRING;
        }
        sw.end();
        System.out.println("String + 运行时间：" + sw.ElapsedMilliseconds() + " ms");

        sw.restart();
        var sb = new StringBuilder();
        for (int i = 0; i < 20000000; i++) {
            sb.append(INIT_STRING);
        }
        sw.end();
        System.out.println("StringBuilder 运行时间：" + sw.ElapsedMilliseconds() + " ms");
    }
}
