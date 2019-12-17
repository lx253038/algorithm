package lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author LX
 * @Date 2019/11/23 15:16
 * @Description lambda ���ʽ��Ӧ��
 */
public class LambdaAndStream {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();

        personList.add(new Person("AAA", 16));
        personList.add(new Person("BBB", 22));
        personList.add(new Person("CCC", 67));
        personList.add(new Person("EEE", 15));
        personList.add(new Person("FFF", 38));
        personList.add(new Person("DDD", 32));


        //�����ڲ��෽ʽʵ������
/*        Collections.sort(personList, new Comparator<lambda.Person>() {
            @Override
            public int compare(lambda.Person o1, lambda.Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        */
        //lambda���ʽʵ��
//        Collections.sort(personList, (x, y) -> x.getAge() - y.getAge());

        //��̬��������
//        Collections.sort(personList, lambda.Person::compareByAge);
//        Collections.sort(personList, Comparator.comparingInt(lambda.Person::getAge));

        //ʵ������
  /*      lambda.PersonUtil util = new lambda.PersonUtil();
        Collections.sort(personList, util::compareByName);*/


        //lambda���ʽ���stream�����򻯴���
        System.out.println();
        System.out.println(personList.stream().filter((p) -> p.getAge() > 20 && p.getName().compareTo("CCC") > 0)
                .collect(Collectors.toList()));//תLIst
//                    .toArray(lambda.Person[]::new));   //ת����
        personList.stream().filter((p) -> p.getAge() > 20 && p.getName().compareTo("CCC") > 0)
                .forEach(System.out::println);

        Map<String, Integer> map = new HashMap<>();
        map.put("AAA", 100);
        map.put("BBB", 200);
        map.put("CCC", 300);
        Stream<Map.Entry<String, Integer>> stream = map.entrySet().stream();
        Map<String, Integer> collect = stream.collect(Collectors.toMap(x -> x.getKey(), y -> y.getValue()));
        System.out.println(collect);


    }


}


@Data
@AllArgsConstructor
@NoArgsConstructor
class Person {
    private String name;

    private int age;


    public static int compareByAge(Person p1, Person p2) {
        return p1.getAge() - p2.getAge();
    }


}

class PersonUtil {

    public int compareByName(Person p1, Person p2) {

        return p1.getName().compareTo(p2.getName());

    }
}