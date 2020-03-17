import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @Author LX
 * @Date 2019/11/18 14:07
 * @Description TODO
 */
public class Test6 {

    public static void main(String[] args) {
        /*Scanner scanner=new Scanner(System.in);
        System.out.println("请输入姓名：");
        String s=scanner.nextLine();
        System.out.println("您输入的姓名是："+s);*/

/*
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println(reader.readLine());
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
*/
        List<String> strings = new ArrayList<>(Arrays.asList("AAA", "AAA", "CCC"));
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            if ("BBB".equals(s)) {
                iterator.remove();
            }
        }

        System.out.println(strings);

    }
}
