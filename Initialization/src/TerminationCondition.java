public class TerminationCondition {
    public static void main(String[] args){
        Book novel = new Book(true);
        //proper leanup:
        novel.checkIn();
        new Book(true);
        //Force garbage collection & finalization:
        System.gc();
    }
}
