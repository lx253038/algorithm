package String;

import java.util.HashSet;

/**
 * @Author LX
 * @Date 2020/6/6 17:35
 * @Description
 */
public class FindStrChild {

    public static void main(String[] args) {
        System.out.println(getStr("223"));
        HashSet hashSet = new HashSet<String>();
    }

    private static String getStr(String str) {
        if (str == null || "".equals(str)) {
            return "";
        }
        if (str.length() <= 1) {
            return str;
        }
        String result = "";
        int length = 0;

        char[] chars = str.toCharArray();
        String tmpStr = chars[0] + "";
        int tmplen = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] == chars[i]) {
                tmpStr += chars[i];
                tmplen++;
            } else {
                if (tmplen > length) {
                    length = tmplen;
                    result = tmpStr;
                }
                tmplen = 1;
                tmpStr = chars[i] + "";
            }
        }
        if (tmplen > length) {
            result = tmpStr;
        }
        return result;
    }

}
