import static ms.util.Println.*;

public class Fruit {
    public void show_name(int num) {
        print("Fruit: " + num);
    }

    public static void main(String[] args) {
        Fruit f = new Apple();
        f.show_name(2);
    }
}

class Apple extends Fruit {
    @Override
    public void show_name(int num) {
        print("Apple: " + num);
    }
}
