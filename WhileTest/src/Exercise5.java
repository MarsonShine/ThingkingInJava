public class Exercise5 {
    private static void toBinaryString(int i) {
        char[] buffer = new char[32];
        int bufferPosition = 32;
        do {
            buffer[--bufferPosition] =
                    ((i & 0x01) != 0) ? '1' : '0';
            i >>>= 1;
        }while(i!=0);
        for (int j = bufferPosition;i<32;j++){
            System.out.println(buffer[j]);
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int i1 = 0xaaaaaaaa;
        int i2 = 0x55555555;
        System.out.println("i2 = "); toBinaryString(i1);
        System.out.println("i2 = "); toBinaryString(i2);
        System.out.println("~i1 = "); toBinaryString(~i1);
    }
}
