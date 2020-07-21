package 反射;


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
        System.out.println("对象实例化~~~~~~");
        this.id = "111111111";
        this.name = "张三";
        this.age = 45;
    }

    public void tell() {
        System.out.println("我是一个学生！");
    }

    private void say() {
        System.out.println("可执行私有方法");
    }
}


