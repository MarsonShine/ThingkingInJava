package net.mindview.util;

public class BasicGenerator<T> implements Generator<T> {
    private Class<T> type;
    public BasicGenerator(Class<T> type){this.type = type;}
    public T next(){
        try{
            //假设是个共有类型
            return type.newInstance();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    //生成一个默认的给定类型的生成器
    public static <T> Generator<T> create(Class<T> type){
        return new BasicGenerator<>(type);
    }
}
