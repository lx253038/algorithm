package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author LX
 * @Date 2020/4/6 18:05
 * @Description 两个Map list中存在相同的key  如果key值相等就将两个Map合为一个Map并返回所有的Map集合
 */
public class MergeMapList2List {

    public static void main(String[] args) {
        List<Map<String, Object>> list1 = new ArrayList<>();
        list1.add(new HashMap<String, Object>() {
            {
                put("id", "1");
                put("name", "111");
            }
        });
        list1.add(new HashMap<String, Object>() {
            {
                put("id", "2");
                put("name", "222");
            }
        });
        list1.add(new HashMap<String, Object>() {
            {
                put("id", "3");
                put("name", "333");
            }
        });


        List<Map<String, Object>> list2 = new ArrayList<>();
        list2.add(new HashMap<String, Object>() {
            {
                put("id", "1");
                put("name", "AAA");
                put("price", 100);
            }
        });
        list2.add(new HashMap<String, Object>() {
            {
                put("id", "2");
                put("name", "BBB");
                put("price", 500);

            }
        });
        list2.add(new HashMap<String, Object>() {
            {
                put("id", "5");
                put("name", "CCC");
                put("price", 400);

            }
        });

        System.out.println(mergeList(list1, list2, "id"));
        System.out.println();
    }

    private static List<Map<String, Object>> mergeList(List<Map<String, Object>> list1, List<Map<String, Object>> list2, String fieldName) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        Map<Object, Object> resMap = new HashMap<>();
        for (Map<String, Object> map : list1) {
            resMap.put(map.get(fieldName), map);
        }

        for (Map<String, Object> map : list2) {
            if (resMap.containsKey(map.get(fieldName))) {
                Map<String, Object> map1 = (Map<String, Object>) resMap.get(map.get(fieldName));
                map.putAll(map1);
                resultList.add(map);
            }
        }

        return resultList;
    }
}
