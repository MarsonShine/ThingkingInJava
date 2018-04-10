package multipleinterfaces;

public class Adventure {
    public static void u(CanFight x){x.fight();}
    public static void t(CanFly x){x.fly();}
    public static void v(CanSwin x){x.swim();}
    public static void w(ActionCharacter x){x.fight();}
    public static void main(String[] args){
        Hero h = new Hero();
        t(h);   //Treat it as a CanFly
        u(h);   //Treat it as a CanFight
        w(h);   //Treat it as a ActionCharacter
        v(h);   //Treat it as a CanSwim
    }
}
