package strings;

public class StringIntern {
    public static void main(String[] args) {
        var s = "MarsonShine";
        var ss = new String("MarsonShine");
        var sss = ss.intern();
        System.out.println("s == ss: " + (s == ss));
        System.out.println("s == sss: "+(s == sss));
        System.out.println("ss == sss: "+(ss == sss));
    }
}
