package String;

/**
 * @Author LX
 * @Date 2020/8/29 19:54
 * @Description
 */
public class LeetCode1661 {

    public String compressString(String S) {
        if (S == null || S.length() < 2) {
            return S;
        }
        int a = 1;
        StringBuilder stringBuilder = new StringBuilder().append(S.charAt(0));
        char[] chars = S.toCharArray();
        for (int i = 1; i < S.length(); i++) {
            if (chars[i] == chars[i - 1]) {
                a++;
            } else {
                stringBuilder.append(a).append(chars[i]);
                a = 1;
            }
        }
        String res = stringBuilder.append(a).toString();
        return res.length() >= S.length() ? S : res;
    }

    public String compressString2(String S) {
        if (S.length() < 2) {
            return S;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int l = 0, r = 1;
        while (r < S.length()) {
            if (S.charAt(l) != S.charAt(r)) {
                stringBuilder.append(S.charAt(l)).append((r - l));
                l = r;
            }
            r++;
        }
        stringBuilder.append(S.charAt(l)).append(r - l);
        String res = stringBuilder.toString();
        return res.length() >= S.length() ? S : res;
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode1661().compressString2(""));
    }
}
