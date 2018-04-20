package strings;

import performance.Stopwatch;

import java.lang.invoke.CallSite;

import static ms.util.Println.*;

public class Concatenation {
    public static void main(String[] args) {
        Stopwatch sw = new Stopwatch();
        sw.start();
        String mango = "mango";
        String s = "abc" + mango + "def" + 47;
        print(s);
        sw.end();
        print("程序运行时间： " + sw.ElapsedMilliseconds() + " ms");
    }

    public void UsingStringBuilder() {
        StringBuilder sb = new StringBuilder();
        sb.append("abc")
                .append("mango")
                .append("def")
                .append(47);
        print(sb.toString());
    }
}
