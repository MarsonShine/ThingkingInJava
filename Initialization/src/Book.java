import static ms.util.Println.*;

public class Book {
    boolean checkedOut = false;
    Book(boolean checkOut){
        checkedOut = checkOut;
    }
    void checkIn(){
        checkedOut = false;
    }
    protected void finalize(){
        if(checkedOut)
            print("Error: checked out");
            //Normally, you'll also do this:
//            super.finalize(); //call the base-class version
    }
}
