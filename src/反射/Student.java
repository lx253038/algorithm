package ����;


/**
 * @Author LX
 * @Date 2020/5/16 14:49
 * @Description
 */


public class Student {
    private String id;
    private String name;
    private int age;

    public Student() {
        System.out.println("����ʵ����~~~~~~");
        this.id = "111111111";
        this.name = "����";
        this.age = 45;
    }

    public void tell() {
        System.out.println("����һ��ѧ����");
    }

    private void say() {
        System.out.println("��ִ��˽�з���");
    }
}


