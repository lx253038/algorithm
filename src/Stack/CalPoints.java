package Stack;

import java.util.Stack;

/*你现在是棒球比赛记录员。
        给定一个字符串列表，每个字符串可以是以下四种类型之一：
        1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
        2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
        3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
        4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
        每一轮的操作都是永久性的，可能会对前一轮和后一轮产生影响。
        你需要返回你在所有回合中得分的总和。*/
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
