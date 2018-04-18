import static ms.util.Println.print;

/**
 * 直接常量
 */
public class Literals {
    /**
     * @param args 参数
     */
    public static void main(String[] args) {
        int i1 = 0x2f; //Hexadecimal (lowercase)
        print("i1: " + Integer.toBinaryString(i1));
        int i2 = 0X2F;
        print("i2: " + Integer.toBinaryString(i2));
        int i3 = 0177; // Octal (leading zero);
        print("i3: " + Integer.toBinaryString(i3));
        char c = 0xffff; //max char hex value;
        print("c: " + Integer.toBinaryString(c));
        byte b = 0x7f; //max byte hex value
        print("b: " + Integer.toBinaryString(b));
        short s = 0x7fff; //max short hex value;
        print("s:" + Integer.toBinaryString(s));

        long n1 = 200L;  //long stuffix
        long b2 = 200l; //long stuffix but can be confusing;
        double d1 = 1d;
        double d2 = 1D;
    }
}
