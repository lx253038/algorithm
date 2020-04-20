import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

import javafx.util.Builder;

public class Main {

    private static List<String> list = Arrays.asList("11", "222", "3333", "444", "55555", "8888888", "6787868");

    public static void main(String[] args) {
        System.out.println("ȡ��ǰʱ��֮ǰ������");
        Date da = new Date();//��ȡ��ǰʱ��
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance(); //�õ�����
        calendar.setTime(da);//�ѵ�ǰʱ�丳������
        calendar.add(Calendar.MONTH, -2); //����Ϊǰ2��
        calendar.add(Calendar.YEAR, -3); //����Ϊǰ2��
        da = calendar.getTime();
        System.out.println(sdf.format(da));

//        System.out.println("�ӿ���̨�����ַ�");
//        Scanner sc = new Scanner(System.in);
//        System.out.println("�������������");
//        String name = sc.nextLine();
//        System.out.println(name);
        System.out.println("\nlambda���ʽ��stream��ʽ��̡�filter()�������ˡ�collect��Collectors.toList()");
        list.stream().filter(s -> s.length() > 3).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("\nlambda���ʽ��stream��ʽ��̡�collect��Collectors.toMap()�Ȳ���");
        Map<String, Integer> collect = list.stream().collect(Collectors.toMap(x -> x, y -> y.length()));
        System.out.println(collect);

        System.out.println("\nFunction����ʽ�ӿڣ�����һ��T���͵Ĳ�����������һ��R���͵���ֵ");
        Function<String, Integer> function = s -> s.length();
        System.out.println(function.apply("345"));

        System.out.println("\nBuilder����ʽ�ӿڣ������ղ���������һ��T���͵���ֵ");
        Builder<String> builder = () -> "Builder����ʽ�ӿ�";
        System.out.println(builder.build());

        System.out.println("\nBinaryOperator����ʽ�ӿڣ���������T���͵Ĳ���������һ��T���͵���ֵ");
        BinaryOperator<Integer> binaryOperator = (x, y) -> x - y;
        BinaryOperator<Integer> binaryOperator2 = Comparable::compareTo;

        System.out.println("�������㣺" + binaryOperator.apply(1111, 222));
        System.out.println("�Ƚ����㣺" + binaryOperator2.apply(111, 222));

    }
}
