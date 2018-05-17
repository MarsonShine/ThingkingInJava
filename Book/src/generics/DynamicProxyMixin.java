package generics;

import net.mindview.util.TwoTuple;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

class MixinProxy implements InvocationHandler{
    Map<String,Object> delegatesByMethod;
    public MixinProxy(TwoTuple<Object,Class<?>>... pairs){
        delegatesByMethod = new HashMap<>();
        for (TwoTuple<Object,Class<?>> pair : pairs){
            for (Method method: pair.second.getMethods()){
                String methodName = method.getName();
                //在map实现第一个接口的方法
                if(!delegatesByMethod.containsKey(methodName))
                    delegatesByMethod.put(methodName,pair.first);
            }
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
public class DynamicProxyMixin {
}
