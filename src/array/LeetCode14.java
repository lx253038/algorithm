package array;

/**
 * @Author LX
 * @Date 2020/8/30 20:05
 * @Description
 */
public class LeetCode14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < ans.length() && j < strs[i].length(); j++) {
                if (ans.charAt(j) != strs[i].charAt(j))
                    break;
            }
            ans = ans.substring(0, j);
            if (ans.equals(""))
                return ans;
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode14().longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }
}
