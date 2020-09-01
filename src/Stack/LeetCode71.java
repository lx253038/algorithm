package Stack;

import java.util.Stack;

/**
 * @Author LX
 * @Date 2020/8/31 21:16
 * @Description ʾ�� 1��
 * ���룺"/home/"
 * �����"/home"
 * ���ͣ�ע�⣬���һ��Ŀ¼������û��б�ܡ�
 * ʾ�� 2��
 * ���룺"/../"
 * �����"/"
 * ���ͣ��Ӹ�Ŀ¼����һ���ǲ����еģ���Ϊ��������Ե������߼���
 * ʾ�� 3��
 * ���룺"/home//foo/"
 * �����"/home/foo"
 * ���ͣ��ڹ淶·���У��������б����Ҫ��һ��б���滻��
 */
public class LeetCode71 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for (String s : path.split("/")) {
            if ("..".equals(s)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!s.equals("") && !s.equals(".")) {
                stack.push(s);
            }
        }

        String str = "";
        while (!stack.isEmpty()) {
            str = "/" + stack.pop() + str;
        }
        return str.isEmpty() ? "/" : str;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode71().simplifyPath("/a/../../b/../c//.//"));
    }
}
