public class Exercise11 {
    protected void finalize(){
        System.out.println("finalize() called");
    }

    public static void main(String[] args){
        new Exercise11();
        System.gc();
        System.runFinalization();
    }
}

