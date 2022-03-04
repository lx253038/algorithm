package 反射;


import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author LX
 * @Date 2020/5/16 14:42
 * @Description 反射机制
 */
public class Demo1 {



    public static void main(String[] args) throws Exception {
        //3种方式获取到Class对象
        //Class c = Class.forName("fanshe.Student");
        Class c = Student.class;
        //Student s = new Student();
        //Class c = s.getClass();
        System.out.println(c.getCanonicalName());
        //通过class.newInstance();实例化对象
        Student student = (Student) c.newInstance();
        student.tell();
        System.out.println(student);
        System.out.println("========通过反射获取私有属性和设置私有属性值==========");
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println(field.get(student));
        }
        System.out.println("====更改name属性值====");
        Field field = c.getDeclaredField("name");
        field.setAccessible(true);
        field.set(student, "李四");
        System.out.println(field.get(student));

        Method[] declaredMethods = c.getDeclaredMethods();
        for (Method method : declaredMethods) {
            method.setAccessible(true);
            method.invoke(student);
        }

    }


}
