package String;

/**
 * @Author LX
 * @Date 2020/8/30 19:32
 * @Description 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II
 */
public class LeetCode13 {
    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public int romanToInt2(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = getValue(s.charAt(i));
            if (preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }


    public int romanToInt(String s) {
        int sum = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char curr = chars[i];
            char next = ' ';
            if (i != chars.length - 1) {
                next = chars[i + 1];
            }
            if ((curr == 'I' && (next == 'V' || next == 'X')) || (curr == 'X' && (next == 'L' || next == 'C')) || (curr == 'C' && (next == 'D' || next == 'M'))) {
                sum = sum + (getValue(next) - getValue(curr));
                i++;
            } else {
                sum += getValue(curr);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode13().romanToInt("IV"));
    }
}
