import javafx.util.Builder;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    private static List<String> list = Arrays.asList("11", "222", "3333", "444", "55555", "8888888", "6787868");

    public static void main(String[] args) {
/*        Scanner sc = new Scanner(System.in);
        System.out.println("ÇëÊäÈëÄãµÄÐÕÃû");
        String name = sc.nextLine();
        System.out.println(name);*/

        list.stream().filter(s -> s.length() > 3).collect(Collectors.toList()).forEach(System.out::println);
        list.stream().collect(Collectors.toMap(x -> x, y -> y.length())).entrySet().forEach(System.out::println);


        Function<String, Integer> function = s -> s.length();
        System.out.println(function.apply("345"));
        Builder<String> builder = () -> {
            System.out.println("1111111112343445566757");
            return "000000";
        };

        builder.build();
        BinaryOperator<Integer> binaryOperator = Comparable::compareTo;
        System.out.println(binaryOperator.apply(1111, 222));
    }
}
