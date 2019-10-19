package set;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author LX
 * @Date 2019/10/15 20:00
 * @Description TODO
 * TreeSet�Ὣ��������ݽ�������
 * �����Զ���Person���� �������ڱȽϹ���(
 * 1.��ʵ��Comparable�ӿڲ�ʵ����compareTo(Object o)��������ȽϹ���
 * 2.�Զ���Ƚ���ʵ��Comparator�ӿڲ�ʵ��compare(Object o1, Object o2)����������TreeSet����ʱ�����Զ���Ƚ���
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
        public int compare(Object o1, Object o2) {//�Զ���Ƚ���;ʹTreeSet���ղ����˳�����
            return 1;
        }*/
/*    @Override
    public int compare(Object o1, Object o2) {//�Զ���Ƚ���;ʹTreeSet�����ַ�������
        return String.valueOf(o1).length() - String.valueOf(o2).length();
    }*/

    @Override
    public int compare(Object o1, Object o2) {//�Զ���Person�Ƚ���
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