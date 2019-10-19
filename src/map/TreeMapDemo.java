package map;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author LX
 * @Date 2019/10/16 18:37
 * @Description TODO
 * 统计一个字符串中字母出现的次数，并按照字母顺序排序
 * aedfbcedakrl: 按照这个a(1)b(2)格式输出
 */
public class TreeMapDemo {

    public static void main(String[] args) {
        Map<Character, Integer> map = new TreeMap<>();
        String s = "aedfbcedakrl";
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> next = iterator.next();
            System.out.print(next.getKey() + "(" + next.getValue() + ")");
        }

    }

}
