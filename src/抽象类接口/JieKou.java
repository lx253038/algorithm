package 抽象类接口;

/**
 * @Author LX
 * @Date 2020/5/17 13:09
 * @Description interface标识接口   implements实现接口
 * 1、接口中的方法默认都是 public、abstract修饰的
 * 2、接口中的成员变量都是 public static final 修饰的并且必须赋初值（final关键词的特性）
 * 3、java8之后可在接口中使用default 关键字修饰方法添加默认实现方法体
 */
public interface JieKou {

    String name = null;

    public abstract void test();

    default void test2() {
        System.out.println("default关键字修饰方法需要添加方法体");
    }

}
