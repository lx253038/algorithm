package ������ӿ�;

/**
 * @Author LX
 * @Date 2020/5/17 12:58
 * @Description abstract�޸ĵķ���Ϊ���󷽷������ε���Ϊ������
 * 1.���󷽷������ڳ������У��������в�ȫ�ǳ��󷽷�
 * 2.���󷽷����ܰ���������
 * 3.�̳г��������ʵ������󷽷�
 * 4.�����಻�ܱ�ʵ�������������� new ChouXiang()
 */
public abstract class ChouXiang {


    //���󷽷�
    protected abstract void test();

    public void test2() {
        System.out.println("�ǳ��󷽷����Դ��ڷ�����");
    }

}

class B extends ChouXiang {

    @Override
    public void test() {

    }

    public static void main(String[] args) {
        ChouXiang chouXiang = new B();
        chouXiang.test2();
    }
}