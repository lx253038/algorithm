package ������ӿ�;

/**
 * @Author LX
 * @Date 2020/5/17 13:09
 * @Description interface��ʶ�ӿ�   implementsʵ�ֽӿ�
 * 1���ӿ��еķ���Ĭ�϶��� public��abstract���ε�
 * 2���ӿ��еĳ�Ա�������� public static final ���εĲ��ұ��븳��ֵ��final�ؼ��ʵ����ԣ�
 * 3��java8֮����ڽӿ���ʹ��default �ؼ������η������Ĭ��ʵ�ַ�����
 */
public interface JieKou {

    String name = null;

    public abstract void test();

    default void test2() {
        System.out.println("default�ؼ������η�����Ҫ��ӷ�����");
    }

}
