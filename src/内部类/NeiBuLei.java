package �ڲ���;

/**
 * @Author LX
 * @Date 2020/5/17 13:35
 * @Description �ڲ��ࣺ��̬�ڲ��� ��Ա�ڲ��� �ֲ��ڲ��� �����ڲ���
 * 1.��static���ε��ڲ���Ϊ��̬�ڲ��� ��ʹ�� new �ⲿ��.����() new NeiBuLei.A()ʵ��
 * 2.����static���ε��ڲ���Ϊ��Ա�ڲ��࣬�������ⲿ��ʵ�������ڲ������ʵ����  neiBuLei.new B()ʵ��
 * 3.�ֲ��ڲ��ඨ���ڴ�����ڵ��࣬�����ֲ���̬�ڲ��ࣨͬ��̬�ڲ��ࣩ�;ֲ��ڲ��ࣨͳ��Ա�ڲ��ࣩ
 * 4.�����ڲ�����һ��û���������ڲ��࣬û�й��캯�������ܶ��徲̬�������������࣬һ���Ǹ���new����
 */
//�ⲿ��
public class NeiBuLei {
    private static String id;
    private String name;

    //��̬�ڲ���
    static class A {
        public A() {
            //���Է����ⲿ��ľ�̬��Ա�����ͷ��������ܷ�����ͨ��Ա�����ͷ���
            System.out.println(id);
            test1();
        }
    }

    //��Ա�ڲ���
    public class B {
        //�����о�̬�ĳ�Ա�����ͷ�����ֻ�ܶ������ⲿ����
        //static int a;
        public B() {
            //��Ա�ڲ�����Է����ⲿ������б����ͷ���
            System.out.println(name);
            System.out.println(id);
            test();
            test1();
        }
    }

    public static void test1() {
        class D {
            public D() {
                //�ֲ���̬�ڲ�����Է����ⲿ������б����ͷ���
                System.out.println(id);
                test1();
            }
        }
    }

    public void test() {
        //�ֲ��ڲ���
        class C {
            public C() {
                //�ֲ��ڲ�����Է����ⲿ������б����ͷ���
                System.out.println(name);
                System.out.println(id);
                test();
                test1();
            }
        }
        Thread thread = new Thread(new Runnable() {  //�����ڲ���
            @Override
            public void run() {
                System.out.println("�����ڲ���ִ�з���");
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
