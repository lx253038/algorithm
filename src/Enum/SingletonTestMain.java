package Enum;

/**
 * @author LX
 * @date 2019-8-5 20:37
 */
enum Singleton {
    INSTANCE;

    private String string = name();

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public void test() {
        System.out.println("²âÊÔ¿ªÊ¼");
    }
}

public class SingletonTestMain {
    public static void main(String[] args) {
        Singleton one = Singleton.INSTANCE;
        Singleton two = Singleton.INSTANCE;

        System.out.println(one.getString());
        one.test();
        one.setString("8888888888888899999999999999999");
        System.out.println(two.getString());
        System.out.println(one.getString());
        System.out.println(one == two);
    }
}

