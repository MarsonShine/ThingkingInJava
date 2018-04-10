package interfacesnesting;
import static ms.util.Println.*;

public interface Service {
    void method1();
    void method2();
}

interface ServiceFactory{
    Service getService();
}

class Implementation1 implements Service {

    Implementation1(){} // 包访问
    @Override
    public void method1() {
        print("Implementation1 method1");
    }

    @Override
    public void method2() {
        print("implementation1 method2");
    }
}

class Implementation1Factory implements ServiceFactory {

    @Override
    public Service getService() {
        return new Implementation1();
    }
}

class Implementation2 implements Service {
    Implementation2(){}
    @Override
    public void method1() {
        print("Implementation2 method1");
    }

    @Override
    public void method2() {
        print("Implementation2 method2");
    }
}

class Implementation2Factory implements ServiceFactory {

    @Override
    public Service getService() {
        return new Implementation2();
    }
}
