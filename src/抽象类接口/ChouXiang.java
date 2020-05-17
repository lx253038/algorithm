package 抽象类接口;

/**
 * @Author LX
 * @Date 2020/5/17 12:58
 * @Description abstract修改的方法为抽象方法，修饰的类为抽象类
 * 1.抽象方法必须在抽象类中，抽象类中不全是抽象方法
 * 2.抽象方法不能包含方法体
 * 3.继承抽象类必须实现其抽象方法
 * 4.抽象类不能被实例化，即：不能 new ChouXiang()
 */
public abstract class ChouXiang {


    //抽象方法
    protected abstract void test();

    public void test2() {
        System.out.println("非抽象方法可以存在方法体");
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