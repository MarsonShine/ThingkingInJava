package multipleinterfaces;

public interface CanFight {
    void fight();
}

interface CanSwin {
    void swim();
}

interface CanFly {
    void fly();
}

class ActionCharacter {
    public void fight() {
    }
}

class Hero extends ActionCharacter
        implements CanFight, CanSwin, CanFly {
    public void swim() {
    }

    public void fly() {
    }
}
