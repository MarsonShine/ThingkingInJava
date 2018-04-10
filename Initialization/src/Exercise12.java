public class Exercise12 {
    public static void main(String[] args){
        new Tank().empty();
        new Tank();
        //Don't empty second one
        System.gc();
        System.runFinalization();
    }
}
