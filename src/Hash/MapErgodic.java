package Hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author LX
 * @date 2019-8-5 20:51
 * Map����
 */

public class MapErgodic {


    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("111", 123);
        map.put("222", 222);
        map.put("333", 333);
        map.put("444", 444);

        //1.forѭ������entrySet
        System.out.println("==============forѭ������entrySet====================");
        Set<Map.Entry<String, Object>> entries = map.entrySet();
        System.out.println(entries.size());
        for (Map.Entry<String, Object> entry : entries) {
            System.out.println(entry);
        }

        //2.Iterator������
        System.out.println("====================Iterator������====================");
        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> next = iterator.next();
            System.out.println("key:" + next.getKey() + "\tvalue:" + next.getValue());
        }

        //3.ֻȡkeys
        System.out.println("====================��ȡ����key��ͨ��map.get()ȡvalue====================");
        for (String key : map.keySet()) {
            System.out.println(key + "=" + map.get(key));
        }
        //4.ֻȡvalue
        System.out.println("====================��ȡ����value====================");
        for (Object value : map.values()) {
            System.out.println(value);
        }


    }


}
