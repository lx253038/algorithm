import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

import javafx.util.Builder;

public class Main {

    private static List<String> list = Arrays.asList("11", "222", "3333", "444", "55555", "8888888", "6787868");

    public static void main(String[] args) {
        System.out.println("取当前时间之前的日期");
        Date da = new Date();//获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance(); //得到日历
        calendar.setTime(da);//把当前时间赋给日历
        calendar.add(Calendar.MONTH, -2); //设置为前2月
        calendar.add(Calendar.YEAR, -3); //设置为前2月
        da = calendar.getTime();
        System.out.println(sdf.format(da));

//        System.out.println("从控制台输入字符");
//        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入你的姓名");
//        String name = sc.nextLine();
//        System.out.println(name);
        System.out.println("\nlambda表达式、stream流式编程、filter()条件过滤、collect、Collectors.toList()");
        list.stream().filter(s -> s.length() > 3).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("\nlambda表达式、stream流式编程、collect、Collectors.toMap()等操作");
        Map<String, Integer> collect = list.stream().collect(Collectors.toMap(x -> x, y -> y.length()));
        System.out.println(collect);

        System.out.println("\nFunction函数式接口，接收一个T类型的参数，返回另一个R类型的数值");
        Function<String, Integer> function = s -> s.length();
        System.out.println(function.apply("345"));

        System.out.println("\nBuilder函数式接口，不接收参数，返回一个T类型的数值");
        Builder<String> builder = () -> "Builder函数式接口";
        System.out.println(builder.build());

        System.out.println("\nBinaryOperator函数式接口，接收两个T类型的参数，返回一个T类型的数值");
        BinaryOperator<Integer> binaryOperator = (x, y) -> x - y;
        BinaryOperator<Integer> binaryOperator2 = Comparable::compareTo;

        System.out.println("减法运算：" + binaryOperator.apply(1111, 222));
        System.out.println("比较运算：" + binaryOperator2.apply(111, 222));

    }
}
