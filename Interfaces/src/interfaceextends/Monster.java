package interfaceextends;

public interface Monster {
    void menace();
}
interface DangerousMonster extends Monster {
    void destory();
}
interface Lethal{
    void kill();
}

class DragonZilla implements DangerousMonster{

    public void menace() {

    }

    public void destory() {

    }
}

interface Vampire extends DangerousMonster,Lethal{
    void drinkBlood();
}
class VeryBadVampire implements Vampire {

    public void menace() {

    }

    public void destory() {

    }

    public void kill() {

    }

    public void drinkBlood() {

    }
}
