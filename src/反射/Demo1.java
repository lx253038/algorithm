package ����;


import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author LX
 * @Date 2020/5/16 14:42
 * @Description �������
 */
public class Demo1 {



    public static void main(String[] args) throws Exception {
        //3�ַ�ʽ��ȡ��Class����
        //Class c = Class.forName("fanshe.Student");
        Class c = Student.class;
        //Student s = new Student();
        //Class c = s.getClass();
        System.out.println(c.getCanonicalName());
        //ͨ��class.newInstance();ʵ��������
        Student student = (Student) c.newInstance();
        student.tell();
        System.out.println(student);
        System.out.println("========ͨ�������ȡ˽�����Ժ�����˽������ֵ==========");
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println(field.get(student));
        }
        System.out.println("====����name����ֵ====");
        Field field = c.getDeclaredField("name");
        field.setAccessible(true);
        field.set(student, "����");
        System.out.println(field.get(student));

        Method[] declaredMethods = c.getDeclaredMethods();
        for (Method method : declaredMethods) {
            method.setAccessible(true);
            method.invoke(student);
        }

    }


}
