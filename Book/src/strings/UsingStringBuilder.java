package strings;

import java.util.Random;

public class UsingStringBuilder {
    public static Random rand = new Random(47);
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 25; i++) {
            sb.append(rand.nextInt(100));
            sb.append(", ");
        }
        sb.delete(sb.length()-2,sb.length());
        sb.append("]");
        return sb.toString();
    }
    public static void main(String[] args){
        UsingStringBuilder usb = new UsingStringBuilder();
        System.out.println(usb);
    }
}
