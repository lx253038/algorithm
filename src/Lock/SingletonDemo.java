package Lock;

/**
 * @Author LX
 * @Date 2019/10/30 20:08
 * @Description TODO
 */
public class SingletonDemo {

    private static volatile SingletonDemo instance = null;

/*    static {  //也可使用静态代码块或者静态内部类的方式且多线程下线程安全
        instance = new SingletonDemo();
    }*/

    private SingletonDemo() {
        System.out.println(Thread.currentThread().getName() + "调用构造函数创建对象！");
    }

    public static SingletonDemo getInstance() {
        if (instance == null) { //DCL 双端检索机制
            synchronized (SingletonDemo.class) {
                if (instance == null) {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

    /**
     * 单线程没问题，多线程存在线程安全问题
     *
     * @return
     */
/*    public static SingletonDemo getInstance() {
        if (instance == null) { //DCL 双端检索机制
            instance = new SingletonDemo();
        }
        return instance;
    }*/
    public static void setInstance(SingletonDemo instance) {
        SingletonDemo.instance = instance;
    }

    public static void main(String[] args) {
        //单线程下  此单例模式正确
       /* System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());*/

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                SingletonDemo.getInstance();
            }, String.valueOf(i)).start();
        }

    }

}
