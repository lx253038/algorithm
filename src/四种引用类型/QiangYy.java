package ������������;

/**
 * @Author LX
 * @Date 2020/5/22 14:24
 * @Description ǿ����
 * ��һ�����󸳸�һ�����ñ�����������ñ�������һ��ǿ���á����� ��Object obj = new Object()�� ��������á�
 * ���ڴ治�㣬JVM ��ʼ�������գ�����ǿ���õĶ���**�����ǳ����� OOM Ҳ����Ըö�����л��գ����������ա�**���ǿ������ʱҲ����� Java �ڴ�й¶��ԭ��֮һ��
 */
public class QiangYy {

    public static void main(String[] args) {
        Object object = new Object();
        Object ob1 = object;

        System.out.println(ob1);
        System.out.println(object);

        System.out.println("=======================ob1��Ϊnull��==================");
        object = null;
        System.gc();

        System.out.println(ob1);
        System.out.println(object);

    }

}
