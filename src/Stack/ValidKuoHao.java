package Stack;
/*给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
        有效字符串需满足：左括号必须用相同类型的右括号闭合。左括号必须以正确的顺序闭合。注意空字符串可被认为是有效字符串。
        示例 1:输入: "()"
               输出: true
        示例 2:输入: "()[]{}"
               输出: true
        示例 3:输入: "(]"
               输出: false
*/

import java.util.Stack;

public class ValidKuoHao {

    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        if( s.length()%2==0){
            for(int i=0;i<s.length();i++){
                char c=s.charAt(i);
                if(c=='('||c=='{'||c=='['){
                    stack.push(c);
                }else{
                    if(stack.isEmpty()){
                        return false;
                    }
                    char pop=stack.pop();
                    if(pop=='{'&&c!='}'){
                        return false;
                    }
                    if(pop=='('&&c!=')'){
                        return false;
                    }
                    if(pop=='['&&c!=']'){
                        return false;
                    }

                }
            }
            return stack.isEmpty();
        }else{
            return false;
        }
    }


    public static void main(String[] args) {
        ValidKuoHao vkh=new ValidKuoHao();
        boolean res1=vkh.isValid("{[(())}}");
        System.out.println(res1);
        boolean res2=vkh.isValid("");
        System.out.println(res2);

    }
}
