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
        personList.add(new Person1("����", 33, "��"));
        personList.add(new Person1("����", 12, "��"));
        personList.add(new Person1("������", 48, "��"));
        personList.add(new Person1("��ޱ", 26, "Ů"));
        personList.add(new Person1("Ůһ��", 50, "Ů"));
        personList.add(new Person1("������", 25, "Ů"));
        personList.add(new Person1("��ѩ", 16, "Ů"));
        personList.add(new Person1("��ޥ��", 56, "Ů"));
        personList.add(new Person1("ëһ��", 64, "��"));
        personList.add(new Person1("�����", 39, "��"));

    }


    @Test
    public void test1() {//map ��һ������ת������һ������
        personList.stream().map(p -> p.getName()).forEach(System.out::println);
    }

    @Test
    public void test2() {//sorted ���򣬻����������Ϳ��Բ�������������������Ҫ����һ���Ƚ���,reversed()��ת˳��

        List<String> list = Arrays.asList("12", "16", "22", "45", "120", "55");
        personList.stream().sorted(Person1::compared).forEach(System.out::println);
        list.stream().sorted().forEach(x -> System.out.println(x));
        System.out.println("===============================================");
        list.stream().sorted(Comparator.comparingInt(String::length).reversed()).forEach(x -> System.out.println(x));
    }

    @Test
    public void test3() {//filter ���˷���Ҫ�������
        personList.stream().filter(x -> x.getAge() > 40 && x.getName().contains("һ")).forEach(System.out::println);
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

