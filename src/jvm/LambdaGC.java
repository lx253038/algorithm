package jvm;

import java.util.function.IntFunction;

/**
 * @Author LX
 * @Date 2020/8/15 19:59
 * @Description
 */
public class LambdaGC {


    public static void main(String[] args) {
        for (; ; ) {
            IntFunction f = Student::name;

        }

    }


}


class Student {

    public static int name(int t) {
        return t;
    }
}