package Lock;

/**
 * @Author LX
 * @Date 2019/10/30 20:08
 * @Description TODO
 */
public class SingletonDemo {

    private static volatile SingletonDemo instance = null;

/*    static {  //Ҳ��ʹ�þ�̬�������߾�̬�ڲ���ķ�ʽ�Ҷ��߳����̰߳�ȫ
        instance = new SingletonDemo();
    }*/

    private SingletonDemo() {
        System.out.println(Thread.currentThread().getName() + "���ù��캯����������");
    }

    public static SingletonDemo getInstance() {
        if (instance == null) { //DCL ˫�˼�������
            synchronized (SingletonDemo.class) {
                if (instance == null) {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

    /**
     * ���߳�û���⣬���̴߳����̰߳�ȫ����
     *
     * @return
     */
/*    public static SingletonDemo getInstance() {
        if (instance == null) { //DCL ˫�˼�������
            instance = new SingletonDemo();
        }
        return instance;
    }*/
    public static void setInstance(SingletonDemo instance) {
        SingletonDemo.instance = instance;
    }

    public static void main(String[] args) {
        //���߳���  �˵���ģʽ��ȷ
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
