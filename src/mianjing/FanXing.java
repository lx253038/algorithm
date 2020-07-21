package mianjing;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author LX
 * @Date 2020/7/21 19:29
 * @Description 泛型擦除
 */
public class FanXing {

    public static void main(String[] args) throws Exception {
        List<Integer> list1 = new ArrayList();
        List<String> list2 = new ArrayList();
        System.out.println(list1.getClass().getName());
        System.out.println(list1.getClass() == list2.getClass());

        list1.add(1);
        //泛型关系编译报错
        //list1.add("aaa");
        Method method = list1.getClass().getMethod("add", Object.class);
        method.invoke(list1, "aaa");
        //说明运行时泛型被擦出
        System.out.println(list1.get(0).getClass());
        //报错，java.lang.String cannot be cast to java.lang.Integer
        //System.out.println(list1.get(1).getClass());
        System.out.println(list1.get(1));
        System.out.println(list1);

    }
}
