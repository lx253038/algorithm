package Stack;
/*����һ��ֻ���� '('��')'��'{'��'}'��'['��']' ���ַ������ж��ַ����Ƿ���Ч��
        ��Ч�ַ��������㣺�����ű�������ͬ���͵������űպϡ������ű�������ȷ��˳��պϡ�ע����ַ����ɱ���Ϊ����Ч�ַ�����
        ʾ�� 1:����: "()"
               ���: true
        ʾ�� 2:����: "()[]{}"
               ���: true
        ʾ�� 3:����: "(]"
               ���: false
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
