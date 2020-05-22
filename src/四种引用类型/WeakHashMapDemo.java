package 四种引用类型;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * @Author LX
 * @Date 2020/5/22 14:56
 * @Description WeakHashMap：弱应用WeakHashMap和HashMap的区别
 */
public class WeakHashMapDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("===============HashMap执行结果===============");
        myHashMap();
        System.out.println("===============WeakHashMap执行结果===============");
        myWeakHashMap();
    }

    public static void myHashMap() {
        HashMap<String, String> map = new HashMap<>();
        String key = new String("k1");
        String value = "v1";
        map.put(key, value);
        System.out.println(map);

        key = null;
        System.gc();

        System.out.println(map);
    }

    public static void myWeakHashMap() {
        WeakHashMap<String, String> map = new WeakHashMap<>();
        //String key = "weak";
        // 刚开始写成了上边的代码
        //思考一下，写成上边那样会怎么样？ 那可不是引用了
        String key = new String("weak");
        String value = "map";
        map.put(key, value);
        System.out.println(map);
        //去掉强引用
        key = null;
        System.gc();

        System.out.println(map);
    }
}

