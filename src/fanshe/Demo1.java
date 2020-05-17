package fanshe;


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
    }


}
