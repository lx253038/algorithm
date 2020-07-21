package 内部类;

/**
 * @Author LX
 * @Date 2020/5/17 13:35
 * @Description 内部类：静态内部类 成员内部类 局部内部类 匿名内部类
 * 1.带static修饰的内部类为静态内部类 可使用 new 外部类.类名() new NeiBuLei.A()实现
 * 2.不带static修饰的内部类为成员内部类，必须在外部类实例化后内部类才能实例化  neiBuLei.new B()实现
 * 3.局部内部类定义在代码块内的类，包含局部静态内部类（同静态内部类）和局部内部类（统成员内部类）
 * 4.匿名内部类是一种没有类名的内部类，没有构造函数，不能定义静态变量、方法、类，一定是跟在new后面
 */
//外部类
public class NeiBuLei {
    private static String id;
    private String name;

    //静态内部类
    static class A {
        public A() {
            //可以访问外部类的静态成员变量和方法，不能访问普通成员变量和方法
            System.out.println(id);
            test1();
        }
    }

    //成员内部类
    public class B {
        //不能有静态的成员变量和方法，只能定义在外部类中
        //static int a;
        public B() {
            //成员内部类可以访问外部类的所有变量和方法
            System.out.println(name);
            System.out.println(id);
            test();
            test1();
        }
    }

    public static void test1() {
        class D {
            public D() {
                //局部静态内部类可以访问外部类的所有变量和方法
                System.out.println(id);
                test1();
            }
        }
    }

    public void test() {
        //局部内部类
        class C {
            public C() {
                //局部内部类可以访问外部类的所有变量和方法
                System.out.println(name);
                System.out.println(id);
                test();
                test1();
            }
        }
        Thread thread = new Thread(new Runnable() {  //匿名内部类
            @Override
            public void run() {
                System.out.println("匿名内部类执行方法");
                System.out.println();
            }
        });
        thread.start();

    }

}

class Test {
    public static void main(String[] args) {
        NeiBuLei neiBuLei = new NeiBuLei();
        NeiBuLei.A a = new NeiBuLei.A();
        NeiBuLei.B b = neiBuLei.new B();
    }
}
