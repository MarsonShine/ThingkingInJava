public class Exercise10 {
    protected void finalize(){
        System.out.println("finalize() called");
    }

    public static void main(String[] args){
        new Exercise10();
    }
    //程序运行可能看不到终结器被调用
    //因为应用程序内存还没频临满的状态
}
