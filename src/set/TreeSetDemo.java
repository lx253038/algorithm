package set;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author LX
 * @Date 2019/10/15 20:00
 * @Description TODO
 * TreeSet会将插入的内容进行排序；
 * 对于自定义Person对象 自身不存在比较功能(
 * 1.需实现Comparable接口并实现其compareTo(Object o)方法定义比较规则
 * 2.自定义比较器实现Comparator接口并实现compare(Object o1, Object o2)方法，并在TreeSet创建时传入自定义比较器
 */
public class TreeSetDemo {


    public static void main(String[] args) {
/*        Set<String> set = new TreeSet<>(new Compare1());
        set.add("zhangsan");
        set.add("lisi");
        set.add("wangwu");
        set.add("chaoliu");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }*/

        Set<Person> set = new TreeSet<>(new Compare1());
        set.add(new Person("zhangsan", 22));
        set.add(new Person("lisi", 18));
        set.add(new Person("wangwu", 56));
        set.add(new Person("aishang", 78));
        set.add(new Person("zhangsan", 30));

        Iterator<Person> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

class Compare1 implements Comparator {


    /*    @Override
        public int compare(Object o1, Object o2) {//自定义比较器;使TreeSet按照插入的顺序遍历
            return 1;
        }*/
/*    @Override
    public int compare(Object o1, Object o2) {//自定义比较器;使TreeSet按照字符串长度
        return String.valueOf(o1).length() - String.valueOf(o2).length();
    }*/

    @Override
    public int compare(Object o1, Object o2) {//自定义Person比较器
        Person p1 = (Person) o1;
        Person p2 = (Person) o2;

        int temp = p1.getName().compareTo(p2.getName());
        return temp == 0 ? p1.getAge() - p2.getAge() : temp;
    }
}


class Person /*implements Comparable*/ {
    private String name;
    private int age;

/*    @Override
    public int compareTo(Object o) {
        Person p = (Person) o;
        int temp = this.name.compareTo(p.getName());
        return temp == 0 ? this.age - p.getAge() : temp;
    }*/

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}