package Stack;

import java.util.Stack;

/*�������ǰ��������¼Ա��
        ����һ���ַ����б�ÿ���ַ���������������������֮һ��
        1.������һ�ֵĵ÷֣���ֱ�ӱ�ʾ���ڱ����л�õĻ�������
        2. "+"��һ�ֵĵ÷֣�����ʾ���ֻ�õĵ÷���ǰ������Ч �غϵ÷ֵ��ܺ͡�
        3. "D"��һ�ֵĵ÷֣�����ʾ���ֻ�õĵ÷���ǰһ����Ч �غϵ÷ֵ�������
        4. "C"��һ���������ⲻ��һ���غϵķ���������ʾ����õ����һ����Ч �غϵķ�������Ч�ģ�Ӧ�ñ��Ƴ���
        ÿһ�ֵĲ������������Եģ����ܻ��ǰһ�ֺͺ�һ�ֲ���Ӱ�졣
        ����Ҫ�����������лغ��е÷ֵ��ܺ͡�*/
public class CalPoints {
    public int calPoint(String[] ops) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ops.length; i++) {

            if ("+".equals(ops[i])) {
                int s = stack.pop();
                int b = s + stack.peek();
                stack.push(s);
                stack.push(b);
                sum += b;
            } else if ("D".equals(ops[i])) {
                int a = 2 * stack.peek();
                stack.push(a);
                sum += a;
            } else if ("C".equals(ops[i])) {
                sum -= stack.pop();
            } else {
                stack.push(Integer.valueOf(ops[i]));
                sum += Integer.valueOf(ops[i]);
            }

        }
        return sum;
    }


    public static void main(String[] args) {
        CalPoints calPoints = new CalPoints();
        int i = calPoints.calPoint(new String[]{"5", "2", "C", "D", "+"});
        System.out.println(i);
    }
}
