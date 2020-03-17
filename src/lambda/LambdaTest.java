package lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author LX
 * @Date 2019/12/27 9:08
 * @Description
 */
public class LambdaTest {


    private static List<Person1> personList = new ArrayList<>();

    static {
        personList.add(new Person1("张三", 33, "男"));
        personList.add(new Person1("李四", 12, "男"));
        personList.add(new Person1("张良仔", 48, "男"));
        personList.add(new Person1("赵薇", 26, "女"));
        personList.add(new Person1("女一号", 50, "女"));
        personList.add(new Person1("赵依依", 25, "女"));
        personList.add(new Person1("杨雪", 16, "女"));
        personList.add(new Person1("杨蕙嘉", 56, "女"));
        personList.add(new Person1("毛一朴", 64, "男"));
        personList.add(new Person1("孙武家", 39, "男"));

    }


    @Test
    public void test1() {//map 将一个对象转换成另一个对象
        personList.stream().map(p -> p.getName()).forEach(System.out::println);
    }

    @Test
    public void test2() {//sorted 排序，基本数据类型可以不传参数，引用类型需要传入一个比较器,reversed()反转顺序

        List<String> list = Arrays.asList("12", "16", "22", "45", "120", "55");
        personList.stream().sorted(Person1::compared).forEach(System.out::println);
        list.stream().sorted().forEach(x -> System.out.println(x));
        System.out.println("===============================================");
        list.stream().sorted(Comparator.comparingInt(String::length).reversed()).forEach(x -> System.out.println(x));
    }

    @Test
    public void test3() {//filter 过滤符合要求的数据
        personList.stream().filter(x -> x.getAge() > 40 && x.getName().contains("一")).forEach(System.out::println);
    }
}


@AllArgsConstructor
@Data
class Person1 {
    private String name;

    private int age;

    private String sex;


    public static int compared(Person1 p1, Person1 p2) {
        return p1.getAge() - p2.getAge();
    }

}

