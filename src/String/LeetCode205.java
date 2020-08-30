package String;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author LX
 * @Date 2020/8/29 20:58
 * @Description ���������ַ���?s?��?t���ж������Ƿ���ͬ���ġ�
 * ���?s?�е��ַ����Ա��滻�õ�?t?����ô�������ַ�����ͬ���ġ�
 * ���г��ֵ��ַ�����������һ���ַ��滻��ͬʱ�����ַ���˳�������ַ�����ӳ�䵽ͬһ���ַ��ϣ����ַ�����ӳ���Լ�����
 * ʾ�� 1:
 * ����: s = "egg", t = "add"
 * ���: true
 */
public class LeetCode205 {

    public boolean isIsomorphic(String s, String t) {
        return isIsomorphicHelp(s, t) && isIsomorphicHelp(t, s);

    }

    public boolean isIsomorphicHelp(String s, String t) {

        Map<Character, Character> map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) {
                    return false;
                }
            } else {
                map.put(c1, c2);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode205().isIsomorphic("ab", "aa"));
    }
}
